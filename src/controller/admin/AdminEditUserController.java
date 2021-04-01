package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.GlobalConstant;
import daos.UserDAO;
import models.User;
import util.AuthUtil;

public class AdminEditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (!AuthUtil.checkLoginAdmin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getById(id);
		String url = "";
	 	StringBuilder sbd = new StringBuilder();
		if (user != null) {
			sbd = new StringBuilder();
			request.setAttribute("user", user);
	 		//url = sbd.append(request.getContextPath()).append("/admin/user/edit").toString();
	 		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/user/edit.jsp");
	 		rd.forward(request, response);
	 		return;
		}else {
			url = sbd.append(request.getContextPath()).append("/admin/user/index.jsp").toString();
		 	response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("uid"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		int role_id  = Integer.parseInt(request.getParameter("role"));
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		User user = new User(id,username, password, fullname, role_id, address, phone, gender);
		boolean check;
		UserDAO userDAO = new UserDAO();
		int countRecordInserted = 0;
	 	String url = "";
	 	StringBuilder sbd = new StringBuilder();
		//check = userDAO.Validate(user);
	 	check = true;
		if (check == true) {
			countRecordInserted = userDAO.update(user);
		}
	 	if(countRecordInserted > 0) {
	 		// success
	 		sbd = new StringBuilder();
	 		url = sbd.append(request.getContextPath()).append("/admin/user/index?msg=").append(GlobalConstant.SUCCESS).toString();
	 		response.sendRedirect(url);
	 		return;
	 	} 
	 	// fail
 		url = sbd.append(request.getContextPath()).append("/admin/user/index?msg=").append(GlobalConstant.ERROR).toString();
	 	response.sendRedirect(url);
	}
	
}
