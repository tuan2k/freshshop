package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.GlobalConstant;
import daos.CategoryDAO;
import models.Category;
import util.AuthUtil;


public class AdminAddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (!AuthUtil.checkLoginAdmin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/cat/add.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		CategoryDAO categoryDAO = new CategoryDAO();
		String name = request.getParameter("name");
		// check if name = script or html tag <nam>...</name>
		boolean checkinp=true;
		if (name.startsWith("<") && name.contains(">") && name.contains("/")
				|| name.contains(">") && name.endsWith(">") && name.contains("/")) {
			checkinp = false;
		}
		Category category = new Category(name);
		boolean validate;
		int countRecordInserted=0;
		validate = categoryDAO.getByName(name);
		if (validate == true && checkinp == true) {
			countRecordInserted = categoryDAO.add(category);
		}
	 	String url = "";
	 	StringBuilder sbd = new StringBuilder();
	 	if(countRecordInserted > 0 && checkinp == true) {
	 		// success
	 		sbd = new StringBuilder();
	 		url = sbd.append(request.getContextPath()).append("/admin/cat/index?msg=").append(GlobalConstant.SUCCESS).toString();
	 		response.sendRedirect(url);
	 		return;
	 	} 
	 	// fail
 		url = sbd.append(request.getContextPath()).append("/admin/cat/index?msg=").append(GlobalConstant.ERROR).toString();
	 	response.sendRedirect(url);
	}

}
