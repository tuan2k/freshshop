

package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Cart;
import util.ConnectDBUlti;

public class CartDAO {
	
	private Connection conn;
	
	private Statement st;
	
	private ResultSet rs;
	
	private PreparedStatement pst;
	
	public List<Cart> getCarts(){
		String SQL = "SELECT * FROM cart";
		List<Cart> carts = new ArrayList<>();
		conn = ConnectDBUlti.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while(rs.next()) {
				int id = rs.getInt("id");
				int order_id = rs.getInt("order_id");
				int product_id = rs.getInt("product_id");
				int user_id = rs.getInt("user_id");
				int counter = rs.getInt("counter");
				Cart cart = new Cart(id, order_id, user_id, product_id, counter);
				carts.add(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUlti.close(conn, pst, rs);
		}
		return carts;
	}
	public int numberOfOrder() {
		int count  =0;
		String SQL = "SELECT COUNT(*) AS count FROM carts";
		conn = ConnectDBUlti.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUlti.close(conn, st,rs);
		}
		return count;
	}
	
	public int add(Cart cart){
		String SQL = "INSERT INTO cart (order_id,user_id,product_id,counter) VALUE (?,?,?,?)";
		int result = 0;
		conn = ConnectDBUlti.getConnection();
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1,cart.getOrder_id());
			pst.setInt(2,cart.getUser_id());
			pst.setInt(3,cart.getProduct_id());
			pst.setInt(4, cart.getCounter());
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUlti.close(conn, pst);
		}
		return result;
	}
	
	public int Delete(int id){
		String SQL = "DELETE FROM cart where id = ? "; 
		int result = 0;
		conn = ConnectDBUlti.getConnection();
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1,id);
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUlti.close(conn, pst);
		}
		return result;
	}
	

	public Cart getById(int id) {
		conn = ConnectDBUlti.getConnection();
		Cart cart = null;
		String sql = "select * from cart where id = ?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				int cid = rs.getInt("id");
				int order_id = rs.getInt("order_id");
				int product_id = rs.getInt("product_id");
				int user_id = rs.getInt("user_id");
				int counter = rs.getInt("counter");
			    cart = new Cart(cid, order_id, user_id, product_id, counter);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return cart;
	}

	public int update(Cart cart) {
		String SQL = "UPDATE cart set order_id = ?,user_id=?,product_id= ?,counter=? where id = ?";
		int result = 0;
		conn = ConnectDBUlti.getConnection();
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, cart.getOrder_id());
			pst.setInt(2, cart.getUser_id());
			pst.setInt(3, cart.getProduct_id());
			pst.setInt(4, cart.getCounter());
			pst.setInt(5, cart.getId());
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUlti.close(conn, pst);
		}
		return result;
	}
	public Cart getByIdOderidUserIdProid(int orderid,int userid,int proid) {
		conn = ConnectDBUlti.getConnection();
		Cart cart = null;
		String sql = "select * from cart where order_id=? and user_id=? and product_id=?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setInt(1, orderid);
			pst.setInt(2, userid);
			pst.setInt(3, proid);
			rs = pst.executeQuery();
			if (rs.next()) {
				int cid = rs.getInt("id");
				int order_id = rs.getInt("order_id");
				int product_id = rs.getInt("product_id");
				int user_id = rs.getInt("user_id");
				int counter = rs.getInt("counter");
			    cart = new Cart(cid, order_id, user_id, product_id, counter);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return cart;
	}
	
	public List<Cart> getByOderId(int orderid){
		String sql = "SELECT * FROM cart where order_id = ? ";
		List<Cart> carts = new ArrayList<>();
		conn = ConnectDBUlti.getConnection();
		try {
			pst= conn.prepareStatement(sql);
			pst.setInt(1, orderid);
			rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int order_id = rs.getInt("order_id");
				int product_id = rs.getInt("product_id");
				int user_id = rs.getInt("user_id");
				int counter = rs.getInt("counter");
				Cart cart = new Cart(id, order_id, user_id, product_id, counter);
				carts.add(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUlti.close(conn, pst, rs);
		}
		return carts;
	}
		
}