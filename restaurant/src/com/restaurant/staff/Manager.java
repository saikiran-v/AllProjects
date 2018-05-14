package com.restaurant.staff;

import java.time.LocalTime;

/**
 * @author saikiran.v
 *
 */
public interface Manager {

	public double discount(LocalTime time, double amount);

}
