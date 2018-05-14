package nokia;

import com.mobile.Mobile;

/**
 * @author saikiran.v
 *
 */
public class Nokia implements Mobile {

	private String IEMICode;
	public SimCard SIMCard;
	public String Processor;
	public int InternalMemory;
	public boolean IsSingleSIM;

	public String getIEMICode() {
		return IEMICode;
	}

	public void setIEMICode(String iEMICode) {
		IEMICode = iEMICode;
	}

	public SimCard getSIMCard() {
		return SIMCard;
	}

	public void setSIMCard(SimCard sIMCard) {
		SIMCard = sIMCard;
	}

	public String getProcessor() {
		return Processor;
	}

	public void setProcessor(String processor) {
		Processor = processor;
	}

	public int getInternalMemory() {
		return InternalMemory;
	}

	public void setInternalMemory(int internalMemory) {
		InternalMemory = internalMemory;
	}

	public boolean isIsSingleSIM() {
		return IsSingleSIM;
	}

	public void setIsSingleSIM(boolean isSingleSIM) {
		IsSingleSIM = isSingleSIM;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mobile.Mobile#Dial()
	 */
	@Override
	public void dial() {
		System.out.println("**Dailing*** from Nokia Phone");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mobile.Mobile#ReceiveCall()
	 */
	@Override
	public void receiveCall() {
		System.out.println("**Receiving Call*** to Nokia Phone");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mobile.Mobile#SendMessage()
	 */
	@Override
	public void sendMessage() {
		System.out.println("**Sending message*** from Nokia Phone");
	}

}
