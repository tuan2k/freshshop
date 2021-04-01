package models;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String fullname;
	private int role_id;
	private String address;
	private String phone;
	private String gender;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String password, String fullname, int role_id, String address, String phone,
			String gender) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.role_id = role_id;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
	}
	public User(String username, String password, String fullname, int role_id, String address, String phone,
			String gender) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.role_id = role_id;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
