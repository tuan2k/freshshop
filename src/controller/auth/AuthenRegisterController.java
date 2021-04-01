package controller.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.UserDAO;
import models.User;

public class AuthenRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AuthenRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath() + "/view/public/checkout.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String mobile = request.getParameter("mobile");
		String fullname = request.getParameter("fullname");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		System.out.println(mobile);
		UserDAO userDAO = new UserDAO();
		User user = new User(username, password, fullname, 2 , address, mobile, gender);
		int InsertCounter = 0;
		InsertCounter = userDAO.add(user);
		if (InsertCounter > 0) {
			response.getWriter().write("True");
		}else {
			response.getWriter().write("False");
		}
	}

}
