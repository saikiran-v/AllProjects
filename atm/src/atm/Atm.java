package atm;

import java.util.InputMismatchException;

import java.util.Scanner;

/**
 * @author aditya.a
 *
 */
public class Atm {
	public static void main(String[] args) {
		int atmPin;
		int accountNo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome");
		System.out.println("Enter Account number");
		accountNo = sc.nextInt();
		CustomerData customer = new CustomerData();
		CustomerInfo info = customer.getAccount(accountNo);
		if (info != null) {
			System.out.println("Enter pin number");
			atmPin = sc.nextInt();
			if (info.getPinNum() == atmPin) { // checks if the pin matches
				System.out.println("Select option");
				System.out.println("1)withdraw");
				System.out.println("2)Deposit");
				System.out.println("3)BalanceCheck");
				System.out.println("4)pinChange");
				int option = sc.nextInt();
				switch (option) { // Based on option appropriate option is
									// performed.
				case 1:
					System.out.println("Enter amount to withdraw");
					double WithdrawAmount = sc.nextDouble();
					if (WithdrawAmount > 0) {
						customer.withdraw(info, WithdrawAmount);
						System.out.println("present balance : " + info.getBalance());
					} else {
						System.out.println("Please enter valid amount");
					}

					break;
				case 2:
					System.out.println("Enter amount to deposit ");
					double deposit = sc.nextInt();
					if (deposit > 0) {
						customer.deposit(info, deposit);
						System.out.println("Amount deposited : " + deposit);
						// System.out.println("Total balance : " +
						// info.getBalance());
					} else {
						System.out.println("Please enter valid amount to deposit");
					}
				case 3:
					System.out.println("Your balance is : " + info.getBalance());
					break;
				case 4:
					boolean flag = true;

					while (flag) { // flag becomes false when new pin is updated
									// from the user

						try {
							System.out.println("Enter new pin : ");
							Integer pin = takeValueFromUser(sc);
							customer.pinChange(info, pin);
							System.out.println("Your new Pin number : " + info.getPinNum());
							flag = false;

						} catch (InputMismatchException e) {
							System.out.println("Enter only Integers");
						} catch (InValidPin e) {
							System.out.println(e.getMessage());
						}
					}
					break;
				default:
					sc.close();
					System.out.println("Invalid option");
					break;
				}
			} else {
				try {
					throw new InValidPin("Invalid Pin ");

				} catch (InValidPin e) {
					System.out.println(e.getMessage());
				} finally {
					sc.close();
				}
			}
		} else {
			System.out.println("please enter valid Account number");
		}
	}

	// checks if the user entered four digit pin or not
	public static int takeValueFromUser(Scanner sc) throws InValidPin {
		int pin = sc.nextInt();
		if (digitSize(pin) == 4) {
			return pin;
		} else
			throw new InValidPin("Please Enter 4 digit valid pin Number ");

	}

	public static int digitSize(int pin) {
		int count = 0;
		int temp = pin;
		while (temp != 0) {
			temp = temp / 10;
			count++;
		}
		return count;

	}

}