package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoryDAO;
import models.Category;
import util.AuthUtil;

public class AdminIndexCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.checkLoginAdmin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return;
		}
		CategoryDAO categoryDAO = new CategoryDAO();		
		List<Category> caterogies = categoryDAO.getCategories();
		request.setAttribute("catlist", caterogies);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/cat/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
