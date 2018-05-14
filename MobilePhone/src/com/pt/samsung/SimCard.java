package com.pt.samsung;

/**
 * @author saikiran.v
 *
 */
public class SimCard {
	private long MobileNumber;

	public SimCard(long mobileNumber) {
		super();
		MobileNumber = mobileNumber;
	}

	public long getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		MobileNumber = mobileNumber;
	}
}
