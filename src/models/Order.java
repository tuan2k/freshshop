package models;

import java.sql.Timestamp;

public class Order {
	
	private int id;
	private int user_id;
	private int total;
	private Timestamp date;
	private int status;

	public Order(int id, int user_id, int total, Timestamp date,int status) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.total = total;
		this.date = date;
		this.status = status;
	}
	
	public Order(int user_id, int total,int status) {
		super();
		this.user_id = user_id;
		this.total = total;
		this.status = status;
	}
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
	
}
