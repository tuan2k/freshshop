package models;

public class Cart {
	
	private int id;
	private int order_id;
	private int user_id;
	private int product_id;
	private int counter;
	
	public Cart(int id, int order_id, int user_id, int product_id, int counter) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.counter = counter;
	}
	
	public Cart( int order_id, int user_id, int product_id, int counter) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.counter = counter;
	}
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	

}
