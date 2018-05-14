/**
 * 
 */
package com.restaurant.pennant;

import java.lang.reflect.Method;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.restaurant.menucard.Items;
import com.restaurant.menucard.MenuCard;
import com.restaurant.userdetails.Customer;

/**
 * @author saikiran.v
 *
 */

public class Restaurant {
	private static final int NUMBEROFTABLES = 3;
	private Map<String, List<Items>> menuCard;
	private List<Table> tables;
	private List<Customer> customer;
	private static Restaurant restaurant = null;

	private Restaurant() {
		menuCard = getMenuCard();
		tables = ListOfTables();
		customer = new ArrayList<>();
		Customer c = new Customer();
		c.setCustomerId(1);
		c.setCustomerName("saikiran");
		c.setCustomerNumber("2121");
		c.setInTime(LocalTime.now());
		customer.add(c);

	}

	/**
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	@RestaurantName(value = "Pennant Restaurant")
	public String getRestaurantName() throws NoSuchMethodException, SecurityException {
		Class<Restaurant> c = Restaurant.class;
		Method method = c.getMethod("getRestaurantName");
		RestaurantName annotation = method.getAnnotation(RestaurantName.class);

		return annotation.value();
	}

	public Customer getExistingCustomerDetails(int eid) {
		Customer cust = null;
		if (customer == null) {
			return cust;
		} else {
			for (Customer c : customer) {
				if (c.getCustomerId() == eid) {
					cust = c;
				}
			}

		}
		return cust;

	}

	public List<Table> ListOfTables() {
		List<Table> tables = new ArrayList<Table>();
		for (int i = 0; i < NUMBEROFTABLES; i++) {
			Table table = new Table();
			table.setTableNo(i);
			tables.add(table);
		}
		return tables;
	}

	// restaurant is Singleton class
	public static Restaurant getInstance() {
		if (restaurant == null) {
			restaurant = new Restaurant();
		}
		return restaurant;
	}

	public Table getTable(int tableNo) {
		for (Table t : tables) {
			if (t.getTableNo() == tableNo)
				return t;
		}
		return null;
	}

	/**
	 * @return the menuCard
	 */
	public Map<String, List<Items>> getMenuCard() {
		return MenuCard.getMenuCard();
	}

	public void displayMenuCard() {
		// To Display the MenuCard Items using Lambda
		menuCard.forEach((s, c) -> {
			System.out.println(s);
			//c.forEach(a -> System.out.println(a));
			System.out.println("Item id || Item Name  	||Description || Quantity || Price");	
			c.forEach(System.out::println);
		});
	}

	public boolean isAnyTableReserved() {
		for (int i = 0; i < NUMBEROFTABLES; i++) {
			if (tables.get(i).isReserved() == true) {
				return true;
			}
		}
		return false;
	}

	private int findTheEmptyTable() {

		for (int i = 0; i < NUMBEROFTABLES; i++) {
			if (tables.get(i).isReserved() == false) {
				return i;
			}
		}
		return -1;
	}

	public boolean isAllTableOccupied() {
		int val = findTheEmptyTable();
		if (val == -1) {
			return true;
		} else {
			return false;
		}
	}

	public Table bookATable() {
		boolean flag = isAllTableOccupied();// To Check any wheather all tables
		Table table = null; // filled or empty
		if (!flag) {
			int tableNo = findTheEmptyTable();
			table = tables.get(tableNo);
			table.setReserved(true);
			return table;
		} else {
			return null;
		}

	}

	public void addCustomer(Customer newCustomer) {
		customer.add(newCustomer);

	}

	public void releaseTable(int tableNo) {
		Table table = tables.get(tableNo);
		table.releaseTable(table);
		System.out.println("table released ::" + tableNo);
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * Restaurant restaurant = new Restaurant(); int tno1 =
	 * restaurant.bookATable(); int tno2 = restaurant.bookATable(); int tno3 =
	 * restaurant.bookATable(); restaurant.releaseTable(tno3);
	 * restaurant.releaseTable(tno2); restaurant.releaseTable(tno1); int tno4 =
	 * restaurant.bookATable();
	 * 
	 * System.out.println("table1 " + tno1); System.out.println("table2 " +
	 * tno2); System.out.println("table3 " + tno3);
	 * 
	 * System.out.println("table4 " + tno4);
	 * 
	 * }
	 */

}
