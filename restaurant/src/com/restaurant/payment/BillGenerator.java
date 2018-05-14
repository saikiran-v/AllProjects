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
public interface BillGenerator {
	
	public double generateBill(List<Items> items);
	
}
