package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.UserDAO;
import models.User;
import util.AuthUtil;

public class AdminIndexUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminIndexUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get user list
		
		if (!AuthUtil.checkLoginAdmin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return;
		}
		UserDAO userDAO = new UserDAO();
		List<User> users = userDAO.getAllUser();
		request.setAttribute("listuser", users);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/user/index.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
