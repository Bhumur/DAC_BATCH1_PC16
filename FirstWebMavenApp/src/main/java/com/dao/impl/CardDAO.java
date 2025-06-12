package com.dao.impl;

import com.cdac.exception.CardExpiredException;
import com.cdac.exception.InsufficentBalanceException;
import com.cdac.exception.InvalidCardException;
import com.cdac.tables.Card;

public interface CardDAO {
	void validCard(Card card, float amount) throws InvalidCardException, CardExpiredException, InsufficentBalanceException;
}
