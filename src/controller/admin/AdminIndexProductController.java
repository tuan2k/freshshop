package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ProductDAO;
import models.Product;
import util.AuthUtil;

public class AdminIndexProductController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public AdminIndexProductController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.checkLoginAdmin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return;
		}
		ProductDAO productDAO = new ProductDAO();	
		List<Product> products = productDAO.getAll();
		request.setAttribute("products", products);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/product/index.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
