package atm;

/**
 * @author aditya.a
 *
 */
public class CustomerInfo {
	private int accountNum;
	private String name;
	private double balance;
	private int pinNum;
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getPinNum() {
		return pinNum;
	}
	public void setPinNum(int pinNum) {
		this.pinNum = pinNum;
	}
	@Override
	public String toString() {
		return "CustomerInfo [accountNum=" + accountNum + ", name=" + name + ", balance=" + balance + ", pinNum="
				+ pinNum + "]";
	}
	

}
