package com.dao.impl;

import java.util.Iterator;

import com.cdac.tables.Transaction;

public interface TransactionDAO {
	public void addTransaction(Transaction t);
	public Iterator<Transaction> showAllTransaction();
}
