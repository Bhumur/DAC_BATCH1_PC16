package com.cdac.exception;

@SuppressWarnings("serial")
public class InsufficentBalanceException extends Exception {
	public InsufficentBalanceException(String s) {
		super(s);
	}
}
