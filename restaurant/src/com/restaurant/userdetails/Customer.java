/**
 * 
 */
package com.restaurant.userdetails;

import java.time.LocalTime;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.restaurant.pennant.Table;

/**
 * @author saikiran.v
 *
 */
public class Customer {

	private int customerId;
	private String customerName;
	private String customerNumber;
	private LocalTime inTime;
	// private boolean proCustomer;
	private Table table;

	// private String feedback;

	public LocalTime getInTime() {
		return inTime;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public void setInTime(LocalTime inTime) {
		this.inTime = inTime;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

}
