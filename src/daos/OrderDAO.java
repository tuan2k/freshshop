
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import models.Order;
import util.ConnectDBUlti;

public class OrderDAO {
	
	private Connection conn;
	
	private Statement st;
	
	private ResultSet rs;
	
	private PreparedStatement pst;
	
	public List<Order> getOrders(){
		String SQL = "SELECT * FROM orders";
		List<Order> orders = new ArrayList<>();
		conn = ConnectDBUlti.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while(rs.next()) {
				int id = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				int total = rs.getInt("total");
				int status = rs.getInt("status");
				Timestamp date = rs.getTimestamp("date"); 
				Order order = new Order(id,user_id, total, date,status);
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUlti.close(conn, pst, rs);
		}
		return orders;
	}
	public int numberOfOrder() {
		int count  =0;
		String SQL = "SELECT COUNT(*) AS count FROM orders";
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
	
	public int add(Order order){
		String SQL = "INSERT INTO orders (user_id,total,status) VALUE (?,?,?)";
		int result = 0;
		conn = ConnectDBUlti.getConnection();
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1,order.getUser_id());
			pst.setInt(2,order.getTotal());
			pst.setInt(3,order.getStatus());
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUlti.close(conn, pst);
		}
		return result;
	}
	
	public int Delete(int id){
		String SQL = "DELETE FROM orders where id = ? "; 
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
	

	public Order getById(int id) {
		conn = ConnectDBUlti.getConnection();
		Order order = null;
		String sql = "select * from orders where id = ?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				int cid = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				Timestamp date = rs.getTimestamp("date");
			    int total = rs.getInt("total");
			    int status = rs.getInt("status");
			    order = new Order(cid, user_id, total, date, status);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return order;
	}

	public int update(Order order) {
		String SQL = "UPDATE orders set user_id=?,total=?,date=?,status=? where id = ?";
		int result = 0;
		conn = ConnectDBUlti.getConnection();
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, order.getUser_id());
			pst.setInt(2,order.getTotal());
			pst.setTimestamp(3,order.getDate());
			pst.setInt(4, order.getStatus());
			pst.setInt(5, order.getId());
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUlti.close(conn, pst);
		}
		return result;
	}
	public Order getByUserId(int userid) {
		conn = ConnectDBUlti.getConnection();
		Order order = null;
		String sql = "select * from orders where user_id = ?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setInt(1, userid);
			rs = pst.executeQuery();
			if (rs.next()) {
				int cid = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				Timestamp date = rs.getTimestamp("date");
			    int total = rs.getInt("total");
			    int status = rs.getInt("status");
			    order = new Order(cid, user_id, total, date,status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return order;
	}
	public List<Order> getMonthOrders(int month) {
		String SQL = "SELECT * FROM orders WHERE MONTH(date) = ?";
		List<Order> orders = new ArrayList<>();
		conn = ConnectDBUlti.getConnection();
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, month);
			rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				int total = rs.getInt("total");
				int status = rs.getInt("status");
				Timestamp date = rs.getTimestamp("date"); 
				Order order = new Order(id,user_id, total, date,status);
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUlti.close(conn, pst, rs);
		}
		return orders;
	}
	
	
}

