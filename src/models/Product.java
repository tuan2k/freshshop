package models;

public class Product {
	private int id;
	private String name;
	private String image;
	private String price;
	private String number;
	private String preview;
	private int cat_id;
	
	
	public Product(int id, String name, String image, String price, String number, String preview, int cat_id) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.number = number;
		this.preview = preview;
		this.cat_id = cat_id;
	}
	
	public Product( String name, String image, String price, String number, String preview, int cat_id) {
		super();
		this.name = name;
		this.image = image;
		this.price = price;
		this.number = number;
		this.preview = preview;
		this.cat_id = cat_id;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	
}
