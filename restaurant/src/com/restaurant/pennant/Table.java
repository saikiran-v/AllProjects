/**
 * 
 */
package com.restaurant.pennant;

/**
 * @author saikiran.v
 *
 */
public class Table {

	private boolean isReserved;
	private int tableNo;

	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public boolean isReserved() {
		return isReserved;
	}

	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

	public void releaseTable(Table table) {
		table.isReserved = false;
	}

}
