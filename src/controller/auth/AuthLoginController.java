package controller.auth;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.ProductDAO;
import daos.UserDAO;
import models.Product;
import models.User;
import util.AuthUtil;

public class AuthLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthLoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Nếu đã đăng nhập rồi thì chuyển hướng sang trang admin luôn
		if (AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/shop");
			return; // thoát luôn, không xử lý tiếp theo
		}
		// Chuyển tiếp sang trang login
		RequestDispatcher rd = request.getRequestDispatcher("/view/public/checkout.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAO userDAO = new UserDAO();
		ProductDAO productDAO = new ProductDAO();
		ArrayList<Product> products = productDAO.getAll();
		User user = null;
		user = userDAO.findByUserAndPassword(username, password);
		if (user != null ) {
			session.setAttribute("userLogin", user);
			request.setAttribute("products", products);
			response.getWriter().write("True");
		}else {
			response.getWriter().write("False");
		}
		
	}

}
