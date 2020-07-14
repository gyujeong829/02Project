package my.model;

import java.util.Date;

public class Purchase {
	private int purchaseId;
	private String userId;
	private int movieId;
	private int amount;
	private int payment;
	private Date purchaseDate;;
	public Purchase(){}
	public Purchase(String userId, int movieId, int amount, int payment, Date purchaseDate) {
		super();
		this.userId = userId;
		this.movieId = movieId;
		this.amount = amount;
		this.payment = payment;
		this.purchaseDate = purchaseDate;
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
}
