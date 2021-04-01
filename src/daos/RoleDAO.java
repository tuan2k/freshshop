package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Role;
import util.ConnectDBUlti;

public class RoleDAO {
private Connection conn;
	
	private Statement st;
	
	private ResultSet rs;
	
	private PreparedStatement pst;
	
	public ArrayList<Role> getAllRole(){
		String SQL = "SELECT * FROM role";
		ArrayList<Role> roles = new ArrayList<>();
		conn = ConnectDBUlti.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("role");
				Role role = new Role(id, name);
				roles.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUlti.close(conn, pst, rs);
		}
		return roles;
	}
	
}
