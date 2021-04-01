package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.GlobalConstant;
import daos.OrderDAO;
import models.Order;
import util.AuthUtil;

public class AdminAddOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminAddOrderController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!AuthUtil.checkLoginAdmin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/order/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		OrderDAO orderDAO = new OrderDAO();
		int userid = Integer.parseInt(request.getParameter("userid"));
		int total = Integer.parseInt(request.getParameter("counter"));
		int status = Integer.parseInt(request.getParameter("status"));
		Order order = new Order(userid, total,status);
		int countRecordInserted = 0;
	 	String url = "";
	 	StringBuilder sbd = new StringBuilder();
		countRecordInserted = orderDAO.add(order);
	 	if(countRecordInserted > 0) {
	 		// success
	 		sbd = new StringBuilder();
	 		url = sbd.append(request.getContextPath()).append("/admin/order/index?msg=").append(GlobalConstant.SUCCESS).toString();
	 		response.sendRedirect(url);
	 		return;
	 	} 
	 	// fail
 		url = sbd.append(request.getContextPath()).append("/admin/order/index?msg=").append(GlobalConstant.ERROR).toString();
	 	response.sendRedirect(url);
	}

}
