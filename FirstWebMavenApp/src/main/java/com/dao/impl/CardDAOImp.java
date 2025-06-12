package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.cdac.exception.CardExpiredException;
import com.cdac.exception.InsufficentBalanceException;
import com.cdac.exception.InvalidCardException;
import com.cdac.tables.Card;

public class CardDAOImp implements CardDAO {
	Connection dbConnection;
	
	public CardDAOImp(Connection db) {
		this.dbConnection = db;
	}
	
	@Override
	public void validCard(Card card, float amount) throws InvalidCardException, CardExpiredException, InsufficentBalanceException {
		try {
			LocalDate currDate = LocalDate.now();
			if(card.getExpiry().isBefore(currDate)) {
				throw new CardExpiredException("Card is Expired");
			}
			PreparedStatement ps = dbConnection.prepareStatement("Select * from carddetail where cardnumber=? and cardcvv=?");
			ps.setString(1, card.getCardNumber());
			ps.setInt(2, card.getCvv());
			ResultSet rs = ps.executeQuery();
			if(!rs.next()) {
				throw new InvalidCardException("Invalid Card Number");
			}
			if(amount>rs.getFloat("balance")) {
				throw new InsufficentBalanceException("Low Balance");
			}else {
				ps = dbConnection.prepareStatement("update carddetail set balance = ? where cardnumber=? and cardcvv=?");
				ps.setFloat(1, rs.getFloat("balance")-amount);
				ps.setString(2, card.getCardNumber());
				ps.setInt(3, card.getCvv());
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	

}
