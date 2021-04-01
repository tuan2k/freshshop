package controller.publics;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ProductDAO;
import models.Product;


public class PublicDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public PublicDetailController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("pid"));
		ProductDAO pDao = new ProductDAO();
		Product product = pDao.getProductById(id);
		request.setAttribute("product", product);
		RequestDispatcher rd = request.getRequestDispatcher("view/public/shop-detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
