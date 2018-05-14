
package com.restaurant.test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.restaurant.exception.EmptyOrderListException;
import com.restaurant.menucard.Items;
import com.restaurant.payment.Payment;
import com.restaurant.pennant.Restaurant;
import com.restaurant.pennant.Table;
import com.restaurant.staff.GeneralManager;
import com.restaurant.staff.Manager;
import com.restaurant.userdetails.Customer;

/**
 * @author saikiran.v
 * 
 */
public class MainRestaurant {

	public static void selectItems(Scanner scn, Customer customer) throws EmptyOrderListException {
		List<Items> orderedItems = null;
		Restaurant restaurant = Restaurant.getInstance();
		Map<String, List<Items>> menuCard = restaurant.getMenuCard();
		boolean whileFlag = true;
		boolean billGenerateFlag = false;
		do {

			System.out.println("1. Starters");
			System.out.println("2. Drinks");
			System.out.println("3. Bill Gernerate");
			System.out.println("4. exit");
			int categoryNo = scn.nextInt();
			String categoryName = null;
			switch (categoryNo) {

			case 1:
				boolean flag1 = true;
				String selectMore = "no";
				categoryName = "Starters";
				List<Items> staterItems = menuCard.get(categoryName);
				if (orderedItems == null) {
					orderedItems = new ArrayList<>();
				}
				while (flag1) {
					int quantity = 0;
					boolean quantityFlag = true;
					System.out.println("Enter  itemid");
					int itemId = scn.nextInt();
					System.out.println(itemId);
					Items newItem = staterItems.get(itemId);
					while (quantityFlag) {
						System.out.println("Enter the Quantity");
						quantity = scn.nextInt();
						if (quantity > 0 && quantity < 20) {
							newItem.setQuantity(quantity);
							orderedItems.add(newItem);
							quantityFlag = false;
						} else {
							System.out.println("quantity must greater than Zero");
						}
					}

					System.out.println("If u want to select more starters enter yes else no  ");
					selectMore = scn.next();
					if (selectMore.equalsIgnoreCase("no")) {
						flag1 = false;
					}
				}
				break;
			case 2: {
				categoryName = "Drinks";
				boolean flag2 = true;
				String selectMore1 = "no";
				List<Items> drinksItems = menuCard.get(categoryName);
				if (orderedItems == null) {
					orderedItems = new ArrayList<>();
				}
				while (flag2) {
					int quantity1 = 0;
					boolean quantityFlag = true;
					System.out.println("Enter  itemid");
					int itemId = scn.nextInt();
					System.out.println(itemId);
					Items newItem = drinksItems.get(itemId);

					while (quantityFlag) {
						System.out.println("Enter the Quantity");
						quantity1 = scn.nextInt();
						if (quantity1 > 0 && quantity1 < 20) {
							newItem.setQuantity(quantity1);
							orderedItems.add(newItem);
							quantityFlag = false;
						} else {
							System.out.println("quantity must greater than Zero");
						}
					}

					System.out.println("If u want to select more starters enter yes else no  ");
					selectMore = scn.next();
					if (selectMore1.equalsIgnoreCase("no")) {
						flag2 = false;
					}
				}
				break;
			}
			case 3:
				if (orderedItems == null) {
					orderedItems = new ArrayList<Items>();
				}
				if (!orderedItems.isEmpty()) {
					billGenerateFlag = generateBill(orderedItems, customer);
					System.out.println("If u wanna order more select below");
				} else {
					throw new EmptyOrderListException("Please select items to place order or exit ");

				}
				break;
			case 4:
				if (billGenerateFlag == false && orderedItems != null)
					billGenerateFlag = generateBill(orderedItems, customer);
				restaurant.releaseTable(customer.getTable().getTableNo());

				whileFlag = false;
				break;
			}
		} while (whileFlag);

	}

	public static void bookTableAndOrder(Restaurant restaurant, Customer customer, Scanner scn)
			throws EmptyOrderListException {
		Table table;
		if (restaurant.isAllTableOccupied() == false) {
			table = restaurant.bookATable();
			customer.setTable(table);
			System.out.println("Please occupy table ::" + table.getTableNo());
			System.out.println("select Items");
			restaurant.displayMenuCard();
			selectItems(scn, customer);
		} else {
			System.out.println("No table free");
		}
	}

	public static boolean generateBill(List<Items> orderedItems, Customer customer) {
		double billAmount = 0.0;
		Manager manager = new GeneralManager();
		diplayItemsOrdered(orderedItems);
		billAmount = new Payment().generateBill(orderedItems);
		System.out
				.println("Bill For customer id  ::" + customer.getCustomerId() + " Name " + customer.getCustomerName());
		System.out.println(" Bill Amount is before Discount :: " + billAmount);
		// 10% Discount is given between 6 pm to 8 pm
		billAmount = manager.discount(customer.getInTime(), billAmount);
		System.out.println("10% Discount is given for customers you visit restaurant  between 17-19 (6pm to 8pm )");
		System.out.println(" Bill Amount is after Discount :: " + billAmount);
		return true;
	}

	public static void diplayItemsOrdered(List<Items> orderedItems) {
		System.out.println("List Of Items Ordered ::");
		System.out.println("Item id || Item Name  	||Description || Quantity || Price");
		orderedItems.forEach(System.out::println);
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Scanner scn = null;
		Restaurant restaurant = Restaurant.getInstance();
		System.out.println("------Welcome to " + restaurant.getRestaurantName() + "------");
		boolean whileflag = true;// used to open or close Restaurant
		Customer customer = null;
		int customerId = 1;// autoIncrement customer Id value
		scn = new Scanner(System.in);
		while (whileflag) {
			System.out.println("If New Customer enter yes/no ");
			String newCustomer = scn.next();
			// this if condition for checking new Employee or existingEmployee
			if (newCustomer.equals("yes")) {
				customer = new Customer();
				customer.setCustomerId(customerId);
				customerId = customerId + 1;
				scn.nextLine();
				System.out.println("Enter Customer Name");
				customer.setCustomerName(scn.nextLine());
				System.out.println("Enter customer Mobile Number");
				customer.setCustomerNumber(scn.nextLine());
				customer.setInTime(LocalTime.now());
				restaurant.addCustomer(customer);
				try {
					bookTableAndOrder(restaurant, customer, scn);
				} catch (EmptyOrderListException e) {
					System.out.println(e.getMessage());
				}
			} else if (newCustomer.equals("no")) {
				System.out.println("Enter Employee ID");
				int eid = scn.nextInt();
				Customer existingCustomer = restaurant.getExistingCustomerDetails(eid);
				if (existingCustomer != null) {
					try {
						System.out.println("hello , mr/mrs " + existingCustomer.getCustomerName());
						bookTableAndOrder(restaurant, existingCustomer, scn);
					} catch (EmptyOrderListException e) {
						System.out.println(e.getMessage());
					}
				} else {
					System.out.println("No data Found register as new Customer");
				}
			} else {
				System.out.println("Restaurant Closed ");
				whileflag = false;
			}
		}

	}
}
