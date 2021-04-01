
package controller.publics;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constants.GlobalConstant;
import daos.CartDAO;
import models.Cart;

public class PulicOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Cart> listCarts;
       
    public PulicOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		CartDAO cDao = new CartDAO();
		HttpSession session = request.getSession();
		if (session.getAttribute("listCarts") != null) {
			listCarts = (List<Cart>) session.getAttribute("listCarts");
			for (Cart c: listCarts) {
				cDao.add(c);
			}
		}
		String url = "";
	 	StringBuilder sbd = new StringBuilder();
		url = sbd.append(request.getContextPath()).append("/cart?msg=").append(GlobalConstant.SUCCESS).toString();
 		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}


