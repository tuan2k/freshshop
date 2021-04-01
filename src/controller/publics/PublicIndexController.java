
package controller.publics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.ProductDAO;
import models.Cart;
import models.Product;

public class PublicIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Cart> listCarts;
       
    public PublicIndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("listCarts") == null) {
			listCarts = new ArrayList<>();
		}
		ProductDAO productDAO = new ProductDAO();
		ArrayList<Product> products =  productDAO.getAll();
		request.setAttribute("products", products);
		RequestDispatcher rd = request.getRequestDispatcher("/view/public/shop.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

