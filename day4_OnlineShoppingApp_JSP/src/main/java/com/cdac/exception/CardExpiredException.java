package com.cdac.exception;

@SuppressWarnings("serial")
public class CardExpiredException extends Exception {
	public CardExpiredException(String s) {
		super(s);
	}
}
