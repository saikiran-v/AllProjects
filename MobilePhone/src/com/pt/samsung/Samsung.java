package com.pt.samsung;

import com.mobile.Mobile;

/**
 * @author saikiran.v
 *
 */
public class Samsung implements Mobile {

	private String iEMICode;
	private SimCard simCard;
	private String processor;
	private int internalMemory;
	private boolean isSingleSIM;

	/**
	 * no Param Constructor
	 */
	public Samsung() {
		// TODO Auto-generated constructor stub
	}

	public Samsung(String iEMICode, SimCard sIMCard, String processor, int internalMemory, boolean isSingleSIM) {
		super();
		this.iEMICode = iEMICode;
		this.simCard = sIMCard;
		this.processor = processor;
		this.internalMemory = internalMemory;
		this.isSingleSIM = isSingleSIM;
	}

	public String getIEMICode() {
		return iEMICode;
	}

	public void setIEMICode(String iEMICode) {
		this.iEMICode = iEMICode;
	}

	public SimCard getSIMCard() {
		return this.simCard;
	}

	public void setSIMCard(SimCard sIMCard) {
		this.simCard = sIMCard;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public int getInternalMemory() {
		return internalMemory;
	}

	public void setInternalMemory(int internalMemory) {
		this.internalMemory = internalMemory;
	}

	public boolean isIsSingleSIM() {
		return isSingleSIM;
	}

	public void setIsSingleSIM(boolean isSingleSIM) {
		this.isSingleSIM = isSingleSIM;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mobile.Mobile#Dial()
	 */
	@Override
	public void dial() {
		System.out.println("**Dailing*** from samsung Phone");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mobile.Mobile#ReceiveCall()
	 */
	@Override
	public void receiveCall() {
		System.out.println("**Receiving Call*** to samsung Phone");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mobile.Mobile#SendMessage()
	 */
	@Override
	public void sendMessage() {
		System.out.println("**Sending message*** from samsung Phone");
	}

}
