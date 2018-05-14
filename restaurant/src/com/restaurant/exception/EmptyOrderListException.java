/**
 * 
 */
package com.restaurant.exception;

/**
 * @author saikiran.v
 *
 */
public class EmptyOrderListException extends Exception {

	/**
	 * 
	 */
	public EmptyOrderListException() {
		
	}

	public EmptyOrderListException(String msg) {
		super(msg);
	}

}
