package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CartDAO;
import daos.OrderDAO;
import models.Cart;
import models.Order;

public class AdminViewOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminViewOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
	    OrderDAO orderDao = new OrderDAO();
	    CartDAO cartDAO = new CartDAO();
		Order order = orderDao.getById(id);
		List<Cart> carts = cartDAO.getByOderId(id);
		String url = "";
	 	StringBuilder sbd = new StringBuilder();
		if (order != null) {
			sbd = new StringBuilder();
			request.setAttribute("order", order);
			request.setAttribute("carts", carts);
	 		//url = sbd.append(request.getContextPath()).append("/admin/user/edit").toString();
	 		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/order/view.jsp");
	 		rd.forward(request, response);
	 		return;
		}else {
			url = sbd.append(request.getContextPath()).append("/admin/order/index.jsp").toString();
		 	response.sendRedirect(url);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
