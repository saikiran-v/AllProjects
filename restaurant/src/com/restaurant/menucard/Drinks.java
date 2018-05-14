/**
 * 
 */
package com.restaurant.menucard;

/**
 * @author saikiran.v
 *
 */
public class Drinks extends Items {

	@Override
	public String toString() {
		return getItemId() + "	|| " + getItemName() + "	||" + getItemDescription() + "	||" + getQuantity()
				+ "		||" + getItemPrice();
	}
}
