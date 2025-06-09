package com.cdac.tables;

import java.time.LocalDate;

public class Card {
	String cardNumber;
	LocalDate expiry;
	int cvv;
	float balance;
	public Card() {}
	public Card(String cardNumber, LocalDate expiry, int cvv, float balance) {
		super();
		this.cardNumber = cardNumber;
		this.expiry = expiry;
		this.cvv = cvv;
		this.balance = balance;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getExpiry() {
		return expiry;
	}
	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", expiry=" + expiry + ", cvv=" + cvv + ", balance=" + balance + "]";
	}
	
	
	
}
