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

import daos.CartDAO;
import daos.OrderDAO;
import daos.ProductDAO;
import models.Cart;
import models.Order;
import models.Product;
import models.User;

public class PublicIndexShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Cart> listCarts;

	public PublicIndexShopController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("listCarts") == null) {
			listCarts = new ArrayList<>();
		}
		ProductDAO productDAO = new ProductDAO();
		ArrayList<Product> products = productDAO.getAll();
		request.setAttribute("products", products);
		RequestDispatcher rd = request.getRequestDispatcher("/view/public/shop.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("listCarts") != null) {
			listCarts = (List<Cart>) session.getAttribute("listCarts");
		}
		int idPro = Integer.parseInt(request.getParameter("aidPro"));
		User user = (User) session.getAttribute("userLogin");
		ProductDAO productDAO = new ProductDAO();
		CartDAO cartDAO = new CartDAO();
		OrderDAO orderDAO = new OrderDAO();
		Order order = orderDAO.getByUserId(user.getId());
		Product product = productDAO.getProductById(idPro);
		boolean check = false;
		boolean newbie = false;
		// Kiểm tra sản phẩm đã có trong giỏ hàng chưa?
		if (listCarts.size() > 0) {
			for (Cart objCart : listCarts) {
				if (objCart.getProduct_id() == idPro) {
					objCart.setCounter(1 + objCart.getCounter());
					check = true;
					Order o = orderDAO.getById(order.getId());
					order.setTotal(o.getTotal() + Integer.parseInt(product.getPrice()));
					orderDAO.update(order);
					// cartDAO.update(objCart);
					break;
				}
			}
		}
		// kiem tra ton tai order chua
		if (order == null) {
			order = new Order(user.getId(), Integer.parseInt(product.getPrice()), 0);
			orderDAO.add(order);
			order = orderDAO.getByUserId(user.getId());
			newbie = true;
		}
		// them vao gio hang
		if (!check) {
			Cart cart = new Cart(listCarts.size(), order.getId(), user.getId(), idPro, 1);
			if (newbie == false) {
				Order o = orderDAO.getById(order.getId());
				order.setTotal(o.getTotal() + Integer.parseInt(product.getPrice()));
			}
			orderDAO.update(order);
			// cartDAO.add(cart);
			// Cart c = cartDAO.getByIdOderidUserIdProid(order.getId(),user.getId(),idPro);
			listCarts.add(cart);
		}
		if (session.getAttribute("listCarts") == null) {
			session.setAttribute("listCarts", listCarts);
		}
		response.getWriter().print(listCarts.size());
	}

}
