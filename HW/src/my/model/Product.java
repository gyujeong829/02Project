package my.model;

public class Product {
	private int  productId;
	 private String  title;
	 private String  maker;
	 private int  price;
	 private String  productImage;
	 private int  accessCount;
	 private String  productType;
	 private String  detail;
	 public Product() {}
	public Product(int productId, String title, String maker, int price, String productImage, String productType,
			String detail) {
		super();
		this.productId = productId;
		this.title = title;
		this.maker = maker;
		this.price = price;
		this.productImage = productImage;
		this.productType = productType;
		this.detail = detail;
	}
	public Product(String title, String maker, int price, String productImage, String productType, String detail) {
		super();
		this.title = title;
		this.maker = maker;
		this.price = price;
		this.productImage = productImage;
		this.productType = productType;
		this.detail = detail;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public int getAccessCount() {
		return accessCount;
	}
	public void setAccessCount(int accessCount) {
		this.accessCount = accessCount;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	 

}
