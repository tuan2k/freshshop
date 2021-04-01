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


public class AdminAddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.checkLoginAdmin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		UserDAO userDAO = new UserDAO();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		int role_id  = Integer.parseInt(request.getParameter("role"));
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		User user = new User(username, password, fullname, role_id, address, phone, gender);
		boolean check;
		int countRecordInserted = 0;
	 	String url = "";
	 	StringBuilder sbd = new StringBuilder();
		check = userDAO.Validate(user);
		if (check == true) {
			countRecordInserted = userDAO.add(user);
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
