package my.model;

import java.util.Date;

public class Book {
	private int bookId;
	private String name;
	private int price;
	private Date registerDate;

	public Book(String name, int price, Date registerDate) {
		super();
		this.name = name;
		this.price = price;
		this.registerDate = registerDate;
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
}

