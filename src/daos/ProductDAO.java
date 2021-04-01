package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Product;
import util.ConnectDBUlti;

public class ProductDAO {
	
	private Connection con;
	private Statement st;
	private PreparedStatement pstm;
	private ResultSet res;
	public ArrayList<Product> getAll(){
		ArrayList<Product> list = new ArrayList<Product>();
		final String query = "select * from products" ;
		try {
			con = ConnectDBUlti.getConnection();
			st = con.createStatement();
			res = st.executeQuery(query);
			while(res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				String preview = res.getString("preview");
				String price = res.getString("price");
				String number = res.getString("number");
				String image = res.getString("image");
				int cat_id = res.getInt("cat_id");
				Product product = new Product(id, name, image, price,number, preview, cat_id);
				list.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectDBUlti.close(con,st,res);
		}
		return list;
	}
	
	public int numberOfProduct() {
		int count  =0;
		String SQL = "SELECT COUNT(*) AS count FROM Products";
		con = ConnectDBUlti.getConnection();
		try {
			st = con.createStatement();
			res = st.executeQuery(SQL);
			if (res.next()) {
				count = res.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUlti.close(con, st,res);
		}
		return count;
	}
	
	public int add(Product product){
		String SQL = "INSERT INTO products (name,image,price,number,preview,cat_id) VALUE (?,?,?,?,?,?)";
		int result = 0;
		con = ConnectDBUlti.getConnection();
		try {
			pstm = con.prepareStatement(SQL);
			pstm.setString(1, product.getName());
			pstm.setString(2, product.getImage());
			pstm.setString(3, product.getPrice());
			pstm.setString(4, product.getNumber());
			pstm.setString(5, product.getPreview());
			pstm.setInt(6, product.getCat_id());
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUlti.close(con, pstm);
		}
		return result;
	}
	public int update(Product product) {
		String SQL = "UPDATE products set name=?, image=?, price=?,number=?,preview=?,cat_id=? where id = ?";
		int result = 0;
		con = ConnectDBUlti.getConnection();
		try {
			pstm = con.prepareStatement(SQL);
			pstm.setString(1, product.getName());
			pstm.setString(2, product.getImage());
			pstm.setString(3, product.getPrice());
			pstm.setString(4, product.getNumber());
			pstm.setString(5, product.getPreview());
			pstm.setInt(6,product.getCat_id());
			pstm.setInt(7, product.getId());
			result = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUlti.close(con, pstm);
		}
		return result;
	}
	public int delete(int id) {
		String SQL = "DELETE from products where id = ?";
		int result = 0;
		con = ConnectDBUlti.getConnection();
		try {
			pstm = con.prepareStatement(SQL);
			pstm.setInt(1, id);
			result = pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Product getProductById(int _id) {
		Product product = null;
        con = ConnectDBUlti.getConnection();
        try {
        	
            String q = "select * from products where id = ?";
            pstm  = con.prepareStatement(q);
            pstm.setInt(1,_id);
            res = pstm.executeQuery();
            if (res.next()) {
            	int id = res.getInt("id");
				String name = res.getString("name");
				String preview = res.getString("preview");
				String price = res.getString("price");
				String number = res.getString("number");
				String image = res.getString("image");
				int cat_id = res.getInt("cat_id");
				product = new Product(id, name, image, price, number , preview, cat_id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

//	public List<Product> getProductPagination(int offset) {
//		
//		ArrayList<Product> list = new ArrayList<Product>();
//		final String query = "select * from products limit ?,?" ;
//		try {
//			con = ConnectDBUlti.getConnection();
//			pstm = con.prepareStatement(query);
//			pstm.setInt(1, offset);
//			pstm.setInt(2, DefineUtil.NUMBER_PER_PAGE);
//			res = pstm.executeQuery();
//			while(res.next()) {
//				int id = res.getInt("id");
//				String name = res.getString("name");
//				String preview = res.getString("preview_text");
//				String detail = res.getString("detail_text");
//				Timestamp date = res.getTimestamp("date_create");
//				String pic = res.getString("picture");
//				int counter = res.getInt("counter");
//				int cat_id = res.getInt("cat_id");
//				Product Product = new Product(id, name, preview, detail, date, pic, counter, cat_id);
//				list.add(Product);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}

//	public List<Product> getProductPaginationByCatID(int cid, int offset) {
//		ArrayList<Product> list = new ArrayList<Product>();
//		final String query = "select * from Products where cat_id = ? limit ?,?" ;
//		try {
//			con = ConnectDBUlti.getConnection();
//			pstm = con.prepareStatement(query);
//			pstm.setInt(1, cid);
//			pstm.setInt(2, offset);
//			pstm.setInt(3, DefineUtil.NUMBER_PER_PAGE);
//			res = pstm.executeQuery();
//			while(res.next()) {
//				int id = res.getInt("id");
//				String name = res.getString("name");
//				String preview = res.getString("preview_text");
//				String detail = res.getString("detail_text");
//				Timestamp date = res.getTimestamp("date_create");
//				String pic = res.getString("picture");
//				int counter = res.getInt("counter");
//				int cat_id = res.getInt("cat_id");
//				Product Product = new Product(id, name, preview, detail, date, pic, counter, cat_id);
//				list.add(Product);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}

//	public ArrayList<Product> getProductSearch(String nsearch) {
//		ArrayList<Product> list = new ArrayList<Product>();
//		final String query = "select * from Products where name LIKE ? " ;
//		try {
//			con = ConnectDBUlti.getConnection();
//			pstm = con.prepareStatement(query);
//			pstm.setString(1,"%"+ nsearch + "%");
//			res = pstm.executeQuery();
//			while(res.next()) {
//				int id = res.getInt("id");
//				String name = res.getString("name");
//				String preview = res.getString("preview_text");
//				String detail = res.getString("detail_text");
//				Timestamp date = res.getTimestamp("date_create");
//				String pic = res.getString("picture");
//				int counter = res.getInt("counter");
//				int cat_id = res.getInt("cat_id");
//				Product Product = new Product(id, name, preview, detail, date, pic, counter, cat_id);
//				list.add(Product);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}
	
//	public List<Product> getProductPaginationBySearch(String search,int offset) {
//		ArrayList<Product> list = new ArrayList<Product>();
//		final String query = "select * from Products where name LIKE ? limit ?,?" ;
//		try {
//			con = ConnectDBUlti.getConnection();
//			pstm = con.prepareStatement(query);
//			pstm.setString(1, "%"+ search + "%");
//			pstm.setInt(2, offset);
//			pstm.setInt(3, DefineUtil.NUMBER_PER_PAGE);
//			res = pstm.executeQuery();
//			while(res.next()) {
//				int id = res.getInt("id");
//				String name = res.getString("name");
//				String preview = res.getString("preview_text");
//				String detail = res.getString("detail_text");
//				Timestamp date = res.getTimestamp("date_create");
//				String pic = res.getString("picture");
//				int counter = res.getInt("counter");
//				int cat_id = res.getInt("cat_id");
//				Product Product = new Product(id, name, preview, detail, date, pic, counter, cat_id);
//				list.add(Product);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}

	public boolean getProductNameByName(String name) {
		String SQL = "select * from products where name = ?";
		boolean result = true;
		con = ConnectDBUlti.getConnection();
		try {
			pstm = con.prepareStatement(SQL);
			pstm.setString(1, name);
			res = pstm.executeQuery();
			if (res.next()) {
				result = false;
			}else result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDBUlti.close(con, pstm,res);
		}
		return result;
	}

}

