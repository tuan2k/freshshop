package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.GlobalConstant;
import daos.CartDAO;
import daos.CategoryDAO;
import daos.OrderDAO;
import daos.ProductDAO;
import models.Cart;
import models.Order;
import models.Product;
import util.AuthUtil;

public class AdminDeleteCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDeleteCartController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.checkLoginAdmin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		CartDAO cartDAO = new CartDAO();
		OrderDAO orderDAO = new OrderDAO();
		ProductDAO productDAO = new ProductDAO();
		Cart c = cartDAO.getById(id);
		Product p = productDAO.getProductById(c.getProduct_id());
		Order o = orderDAO.getById(c.getOrder_id());
		o.setTotal(o.getTotal() - c.getCounter()*Integer.parseInt(p.getPrice()));
		orderDAO.update(o);
		int countRecordInserted = cartDAO.Delete(id);
		String url = "";
	 	StringBuilder sbd = new StringBuilder();
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
