
package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.GlobalConstant;
import daos.ProductDAO;
import util.AuthUtil;

public class AdminDeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDeleteProductController() {
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
		int countRecordInserted = productDAO.delete(id);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

