package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.OrderDAO;
import models.Order;
import util.AuthUtil;


public class AdminIndexOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminIndexOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (!AuthUtil.checkLoginAdmin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return;
		}
		OrderDAO orderDAO = new OrderDAO();
		List<Order> orders = orderDAO.getOrders();
		request.setAttribute("orders", orders);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/order/index.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
