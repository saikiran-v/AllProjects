package com.restaurant.pennant;

import java.util.List;

import com.restaurant.menucard.Items;

/**
 * @author saikiran.v
 *
 */
public class Order {

	List<Items> items;

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

}
