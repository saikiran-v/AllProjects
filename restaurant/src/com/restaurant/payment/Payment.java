/**
 * 
 */
package com.restaurant.payment;

import java.util.List;

import com.restaurant.menucard.Items;

/**
 * @author saikiran.v
 *
 */
public class Payment implements BillGenerator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.restaurant.pennant.BillGenerator#generate(java.util.List)
	 */
	@Override
	public double generateBill(List<Items> items) {
		double totalBillAmount = 0.0;
		if (items != null) {
			for (Items item : items) {
				totalBillAmount += item.getItemPrice() * item.getQuantity();
			}
		}
		return totalBillAmount;
	}

}
