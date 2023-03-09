package edu.ics372.GroupProject1.facade;

import edu.ics372.GroupProject1.entities.Member;
import edu.ics372.GroupProject1.entities.Product;
import java.util.Date;

public abstract class DataTransfer {
	private String productId;
	private String productName;
	private double productPrice;
	private int productMinOrderLevel;
	private int productQuantity;
	
	private String memberName;
	private String memberAddress;
	private String memberPhone;
	private double memberFee;
	private String memberId;
	private Date memberJoinDate;

	/**
	 * This sets all fields to "none".
	 */
	public DataTransfer() {
		reset();
	}

	// Getters and Setters for products
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductMinOrderLevel() {
		return productMinOrderLevel;
	}

	public void setProductMinOrderLevel(int minOrderLevel) {
		this.productMinOrderLevel = minOrderLevel;
	}

	public double getProductQuantity() {
		return productQuantity;
	}

	public void setProductFields(Product product) {

		productId = product.getProductID();
		productName = product.getProductName();
		productPrice = product.getProductPrice();
		productMinOrderLevel = product.getProductMinOrderLevel();
		productQuantity = product.getProductQuantity();

	} // end setProdictFields
	
	// Getters and setters for member
	public String getMemberName() {
		return memberName;
	}
	
	public String getMemberAddress() {
		return memberAddress;
	}
	
	public String getMemberPhone() {
		return memberPhone;
	}
	
	public double getMemberFee() {
		return memberFee;
	}
	
	public String getMemberId() {
		return memberId;
	}
	
	public Date getMemberJoinDate() {
		return memberJoinDate;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	
	public void setMemberFee(double memberFee) {
		this.memberFee = memberFee;
	}
	
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	
	public void setMemberJoinDate(Date memberJoinDate) {
		this.memberJoinDate = memberJoinDate;
	}
	
	public void setMemberFields(Member member) {

		memberName = member.getMemberName();
		memberAddress = member.getMemberAddress();
		memberPhone = member.getMemberPhone();
		memberFee = member.getMemberFee();
		memberId = member.getMemberId();

	}
	
	public void reset() {
		productId = "Invalid product ID";
		productName = "No product Name";
		productPrice = 0;
		productMinOrderLevel = 0;
		productQuantity = 0;
	}// end reset

}
