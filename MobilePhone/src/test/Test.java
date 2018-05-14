package test;

import com.mobile.Mobile;
import com.pt.samsung.Samsung;

import nokia.Nokia;

/**
 * @author saikiran.v
 *
 */
public class Test {
	public static void main(String[] args) {

		Mobile m = new Nokia();
		m.dial();
		m.receiveCall();
		m.sendMessage();

		Mobile m2 = new Samsung();
		m2.dial();
		m2.sendMessage();
		m2.receiveCall();

	}

}
