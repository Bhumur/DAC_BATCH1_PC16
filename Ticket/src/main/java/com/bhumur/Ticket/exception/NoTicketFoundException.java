package com.bhumur.Ticket.exception;

@SuppressWarnings("serial")
public class NoTicketFoundException extends RuntimeException{
	public NoTicketFoundException(String s) {
		super(s);
	}
}
