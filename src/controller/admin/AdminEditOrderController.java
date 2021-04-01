package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.GlobalConstant;
import daos.CartDAO;
import daos.OrderDAO;
import daos.ProductDAO;
import models.Cart;
import models.Order;
import models.Product;
import util.AuthUtil;

@WebServlet("/AdminEditOrderController")
public class AdminEditOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminEditOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (!AuthUtil.checkLoginAdmin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return;
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
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
	 		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/order/edit.jsp");
	 		rd.forward(request, response);
	 		return;
		}else {
			url = sbd.append(request.getContextPath()).append("/admin/order/index.jsp").toString();
		 	response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int counter = Integer.parseInt(request.getParameter("counter"));
		int status = Integer.parseInt(request.getParameter("status"));
		int id = Integer.parseInt(request.getParameter("id"));
		OrderDAO orderDAO = new OrderDAO();
		ProductDAO pDao = new ProductDAO();
		CartDAO cdao = new CartDAO();
		Cart c = cdao.getById(id);
		Product p = pDao.getProductById(c.getProduct_id());
		Order o = orderDAO.getById(c.getOrder_id());
		o.setStatus(status);
		o.setTotal(o.getTotal() + (counter - c.getCounter())*Integer.parseInt(p.getPrice()) );
		c.setCounter(counter);
		cdao.update(c);
		int countRecordInserted = 0;
	 	String url = "";
	 	StringBuilder sbd = new StringBuilder();
	 	countRecordInserted = orderDAO.update(o);
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
//		
	}

}
