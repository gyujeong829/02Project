package my.model;

import java.util.Date;

public class TPurchase {
	private int purchaseId;
	private String userId;
	private int itemId;
	private int amount;
	private int payment;
	private Date purchaseDate;
	
	public TPurchase(){}

	public TPurchase(String userId, int itemId, int amount, int payment, Date purchaseDate) {
		super();
		this.userId = userId;
		this.itemId = itemId;
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
		return itemId;
	}

	public void setMovieId(int itemId) {
		this.itemId = itemId;
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
	};
	
}
