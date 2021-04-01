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

public class PublicCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	float totalPrice = 0;
	List<Cart> listCarts;
       
    public PublicCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if (userLogin == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		CartDAO cdao = new CartDAO();
		OrderDAO odao = new OrderDAO();
		ProductDAO pdao = new ProductDAO();
		totalPrice = 0;
		if ( request.getParameter("aid")!=null) {
			int id = Integer.parseInt(request.getParameter("aid"));
			listCarts = (List<Cart>) session.getAttribute("listCarts");
			Cart cart = null;
			for (Cart ca : listCarts) {
				if (ca.getId() == id)
					cart = ca;
			}
			listCarts.removeIf(obj -> obj.getId() == id);
			// update total after delete
			Order o = odao.getById(cart.getOrder_id());
			Product p = pdao.getProductById(cart.getProduct_id());
			o.setTotal(o.getTotal() - cart.getCounter()*Integer.parseInt(p.getPrice()));
			odao.update(o);
			// update total here and reload form in view it willl be oke to update
			return;
		}
		listCarts = (List<Cart>) session.getAttribute("listCarts");
		ProductDAO productDAO = new ProductDAO();
		int price =0;
		Product product = null;
		// caculate total of all product
		if (listCarts != null) {
			for (Cart c : listCarts) {
				product = productDAO.getProductById(c.getProduct_id());
				price = Integer.parseInt(product.getPrice());
				totalPrice +=  price*c.getCounter();
				price = 0;
				product = null;
			}
		}
		// send to cart jsp total product
		request.setAttribute("totalPrice", totalPrice);
		RequestDispatcher rd = request.getRequestDispatcher("/view/public/cart.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if (userLogin == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		int idPro = Integer.parseInt(request.getParameter("aidPro"));
		int number = Integer.parseInt(request.getParameter("anumber"));
		ProductDAO pDao = new ProductDAO();
		OrderDAO oDao = new OrderDAO();
		Product p = null;
		Order o = null;
		o = oDao.getByUserId(userLogin.getId());
		List<Integer> listNumber = new ArrayList<>();
		listCarts = (List<Cart>) session.getAttribute("listCarts");
		totalPrice = 0;
		// tang giam so luong
		for (Cart c : listCarts) {
			if (c.getProduct_id() == idPro) {
				p = pDao.getProductById(c.getProduct_id());
				if (number == 1) {
					c.setCounter(c.getCounter() + 1);
					totalPrice += Integer.parseInt(p.getPrice());
					listNumber.add(c.getCounter());
				} else if (c.getCounter()> 0) {
					c.setCounter(c.getCounter() -1);
					totalPrice -= Integer.parseInt(p.getPrice());
					listNumber.add(c.getCounter());
				} else {
					response.getWriter().print(listNumber);
					System.out.println("co vo day khong ne");
					return;
				}
				break;
			}
		}
		int totalPriceInt = (int) totalPrice;
		totalPriceInt += o.getTotal();
		o.setTotal(totalPriceInt);
		oDao.update(o);
		listNumber.add(totalPriceInt);
		response.getWriter().print(listNumber);
		
	}

}
