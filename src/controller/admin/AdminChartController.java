
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

public class AdminChartController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public AdminChartController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.checkLoginAdmin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/chart/index.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDAO oDao = new OrderDAO();
		int month = Integer.parseInt(request.getParameter("month"));
		List<Order> orders = oDao.getMonthOrders(month);
		int allsalary = 0;
		for (Order o : orders) {
			allsalary += o.getTotal();
		}
		request.setAttribute("allsalary", allsalary);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/chart/index.jsp");
		rd.forward(request, response);
	}
}

