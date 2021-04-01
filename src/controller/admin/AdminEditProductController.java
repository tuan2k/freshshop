
package controller.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import constants.GlobalConstant;
import daos.ProductDAO;
import models.Product;
import util.AuthUtil;


@MultipartConfig
public class AdminEditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditProductController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		if (!AuthUtil.checkLoginAdmin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.getProductById(id);
		String url = "";
	 	StringBuilder sbd = new StringBuilder();
		if (product != null) {
			sbd = new StringBuilder();
			request.setAttribute("product", product);
	 		//url = sbd.append(request.getContextPath()).append("/admin/cat/edit").toString();
	 		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/product/edit.jsp");
	 		rd.forward(request, response);
	 		return;
		}else {
			url = sbd.append(request.getContextPath()).append("/admin/product/index.jsp").toString();
		 	response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String preview = request.getParameter("review");
		String price = request.getParameter("price");
		String number = request.getParameter("number");
		int catid = Integer.parseInt(request.getParameter("catid"));
		Part filePart = request.getPart("image");
		String fileName = filePart.getSubmittedFileName();
		if (!"".equals(fileName)) {
			String rootPath = request.getServletContext().getRealPath("");
			String dirUploadPath = rootPath + "files";
			File createDir = new File(dirUploadPath);
			if (!createDir.exists()) {
				createDir.mkdir();
			}
			// use String buider append to add string avoid sql 
			StringBuffer sb = new StringBuffer();
			String filePath =  sb.append(dirUploadPath).append(File.separator).append(fileName).toString();
			filePart.write(filePath);   // truyền vào đường dẫn upload file
		}
		ProductDAO productDAO = new ProductDAO();
		Product product = new Product(id, name, fileName, price,number, preview, catid);
		boolean validate;
		int countRecordInserted=0;
		validate = productDAO.getProductNameByName(name);
	 	if (validate == true) {
	 		countRecordInserted = productDAO.update(product);
	 	}
	 	String url = "";
	 	StringBuilder sbd = new StringBuilder();
	 	if(countRecordInserted > 0) {
	 		// success
	 		sbd = new StringBuilder();
	 		url = sbd.append(request.getContextPath()).append("/admin/product/index?msg=").append(GlobalConstant.SUCCESS).toString();
	 		response.sendRedirect(url);
	 		return;
	 	} 
	 	// fail
 		url = sbd.append(request.getContextPath()).append("/admin/product/index?msg=").append(GlobalConstant.ERROR).toString();
	 	response.sendRedirect(url);
	}
	
}
