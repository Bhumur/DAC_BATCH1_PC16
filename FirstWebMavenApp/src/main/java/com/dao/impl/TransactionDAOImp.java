package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

import com.cdac.tables.Transaction;

public class TransactionDAOImp implements TransactionDAO {
	Connection dbConnection;
	
	public TransactionDAOImp(Connection db) {
		this.dbConnection = db;
	}
	
	@Override
	public void addTransaction(Transaction t) {
		try {
			PreparedStatement ps = dbConnection.prepareStatement("insert into transaction(username,date,cardnumber,amount,status) values(?,?,?,?,?);");
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getDate());
			ps.setString(3, t.getCardNumber());
			ps.setFloat(4, t.getAmount());
			ps.setBoolean(5, t.isStatus());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Iterator<Transaction> showAllTransaction() {
		try {
			PreparedStatement ps = dbConnection.prepareStatement("select * from transaction");
			ArrayList<Transaction> list = new ArrayList<Transaction>();
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				list.add(new Transaction(
						rs.getInt("transactionId"),
						rs.getString("date"),
						rs.getString("username"),
						rs.getString("cardnumber"),
						rs.getFloat("amount"),
						rs.getBoolean("status")
						));
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
