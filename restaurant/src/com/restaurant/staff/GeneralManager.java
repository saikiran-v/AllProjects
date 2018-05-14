/**
 * 
 */
package com.restaurant.staff;

import java.time.LocalTime;

/**
 * @author saikiran.v
 *
 */
public class GeneralManager implements Manager {

	/*
	 * (non-Javadoc)
	 *
	 * 10% Discount is given for customers you visit restaurant  between 17-19 (6pm to 8pm )   
	 * @see com.restaurant.pennant.Manager#discount()
	 */
	@Override
	public double discount(LocalTime time, double amount) {
		int discount = 10;
		int dayTime = time.getHour();
		if (dayTime >= 17 && dayTime <= 19) {
			amount = amount - (amount / discount);
		}

		return amount;
	}

}
