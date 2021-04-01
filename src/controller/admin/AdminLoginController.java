package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constants.GlobalConstant;
import daos.UserDAO;
import models.User;

public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/auth/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findByUserAndPassword(username,password);
		if (user != null && user.getRole_id() == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("userAdmin", user);
			response.sendRedirect(request.getContextPath()+"/admin/user/index");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/login?msg="+GlobalConstant.ERROR);
			return;
		}
	}

}
