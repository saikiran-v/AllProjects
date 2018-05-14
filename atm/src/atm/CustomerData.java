package atm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aditya.a
 *
 */
public class CustomerData {
	List<CustomerInfo> cus = new ArrayList<>();

	public CustomerData() {
		CustomerInfo c = new CustomerInfo();
		c.setName("pavan");
		c.setAccountNum(1234);
		c.setBalance(5000);
		c.setPinNum(1234);
		cus.add(c);
		CustomerInfo c1 = new CustomerInfo();
		c1.setName("Aditya");
		c1.setAccountNum(13453);
		c1.setBalance(5000);
		c1.setPinNum(2390);
		cus.add(c1);
	}

	/**
	 * @param accountNo
	 * @return
	 */
	// method for checking if the account number is matches.
	public CustomerInfo getAccount(int accountNo) {
		for (CustomerInfo info : cus) {
			System.out.println();
			if (info.getAccountNum() == accountNo) {
				return info;
			}
		}
		return null;
	}

	// method for amount withdraw
	public double withdraw(CustomerInfo info, double withdrawAmount) {
		double balance = info.getBalance();
		if (balance >= withdrawAmount) {
			balance = balance - withdrawAmount;
			info.setBalance(balance);
			System.out.println("please collect your cash");
		} else {
			System.out.println("Insuffient Funds !!!");
		}
		return balance;
	}

	// method for amount deposit
	public double deposit(CustomerInfo info, double deposit) {
		double balance1 = info.getBalance();
		balance1 = balance1 + deposit;
		info.setBalance(balance1);
		return balance1;
	}

	// method for pin change
	public void pinChange(CustomerInfo info, Integer pin) {
		System.out.println(pin);
		info.setPinNum(pin.intValue());
	}
}