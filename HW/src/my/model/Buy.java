package my.model;

import java.util.Date;

public class Buy {
	private int buyId;
	private String userId;
	private int productId;
	private int amount;
	private int payment;
	private Date buyDate;
	private String option;
	public Buy(){}
	public Buy(String userId, int productId, int amount, int payment,Date buyDate, String option) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.amount = amount;
		this.payment = payment;
		this.buyDate = buyDate;
		this.option = option;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	
}
