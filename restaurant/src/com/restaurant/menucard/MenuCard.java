/**
 * 
 */
package com.restaurant.menucard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author saikiran.v
 *
 */
public class MenuCard {
	private static Map<String, List<Items>> category;

	/**
	 * 
	 */
	private MenuCard() {

	}

	static {
		category = new HashMap<String, List<Items>>();
		category.put("Starters", getStarters());
		category.put("Drinks", getDrinks());
	}

	private static List<Items> getStarters() {
		List<Items> starters = new ArrayList<Items>();
		Starters i1 = new Starters();
		i1.setItemId(0);
		i1.setItemName("spl.starters");
		i1.setItemPrice(200.0);
		i1.setItemDescription("New Starter");
		starters.add(i1);
		Starters i2 = new Starters();
		i2.setItemId(1);
		i2.setItemName("spl.starters");
		i2.setItemPrice(300.0);
		i2.setItemDescription("New Starter");
		starters.add(i2);

		return starters;
	}

	private static List<Items> getDrinks() {
		List<Items> Drinks = new ArrayList<Items>();
		Drinks i1 = new Drinks();
		i1.setItemId(0);
		i1.setItemName("spl.Drinks");
		i1.setItemPrice(200.0);
		i1.setItemDescription("New Drinks");
		Drinks i2 = new Drinks();
		i2.setItemId(1);
		i2.setItemName("Diet cock");
		i2.setItemPrice(150.0);
		i2.setItemDescription("spl Drinks");
		Drinks i3 = new Drinks();
		i3.setItemId(2);
		i3.setItemName("spl.Diet cock");
		i3.setItemPrice(250.0);
		i3.setItemDescription("New Drinks");
		Drinks.add(i1);
		Drinks.add(i2);
		Drinks.add(i3);
		return Drinks;
	}

	public static Map<String, List<Items>> getMenuCard() {
		return category;
	}

	
}
