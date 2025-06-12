package com.doa;

public class Transaction {
	int transactionId;
	String username;
	String date;
	String cardNumber;
	float amount;
	boolean status;
	public Transaction() {}
	public Transaction( int t,String username, String date, String cardNumber, float amount,
			boolean status) {
		super();
		this.transactionId = t;
		this.username = username;
		this.date = date;
		this.cardNumber = cardNumber;
		this.amount = amount;
		this.status = status;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", username=" + username + ", date=" + date
				+ ", cardNumber=" + cardNumber + ", amount=" + amount + ", status=" + status + "]";
	}
	
	
}
