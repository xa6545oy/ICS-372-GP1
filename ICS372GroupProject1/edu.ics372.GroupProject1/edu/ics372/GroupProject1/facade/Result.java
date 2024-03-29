package edu.ics372.GroupProject1.facade;

public class Result extends DataTransfer {
	public static final int PRODUCT_NOT_FOUND = 1;
	public static final int PRODUCT_NOT_ISSUED = 2;
	public static final int PRODUCT_ISSUED = 3;
	public static final int OPERATION_COMPLETED = 4;
	public static final int OPERATION_FAILED = 5;
	public static final int MEMBER_NOT_FOUND = 6;
	public static final int MEMBER_FOUND = 7;

	private int resultCode;

	// Getter and Setter
	public int getResultCode() {
		return resultCode;
	}

	/*
	 * Get result code
	 * 
	 * @return resultCode
	 */
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

}