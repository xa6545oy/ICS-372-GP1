package edu.ics372.GroupProject1.entities;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String address;
	private String phone;
	private String id;
	private double fee;
	private Date dateJoined;
	private static final String MEMBER_STRING = "M";
	private static int idCounter;

	/*
	 * Creates a single member
	 * 
	 * @param name is the name of the member
	 * 
	 * @param address is the address of the member
	 * 
	 * @param phone is the phone of the member
	 * 
	 * @param fee is the fee the member paid
	 */
	public Member(String name, String address, String phone, double fee) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.fee = fee;

		dateJoined = new Date();
		id = MEMBER_STRING + ++idCounter;
	}

	/*
	 * Getter for name
	 * 
	 * @return member name
	 */
	public String getMemberName() {
		return name;
	}

	/*
	 * Getter for address
	 * 
	 * @return member address
	 */
	public String getMemberAddress() {
		return address;
	}

	/*
	 * Getter for phone
	 * 
	 * @return member phone number
	 */
	public String getMemberPhone() {
		return phone;
	}

	/*
	 * Getter for fee
	 * 
	 * @return fee
	 */
	public double getMemberFee() {
		return fee;
	}

	/*
	 * Getter for id
	 * 
	 * @return member id
	 */
	public String getMemberId() {
		return id;
	}

	/*
	 * Getter for dateJoined
	 * 
	 * @return dateJoined
	 */
	public Date getMemberJoinDate() {
		return dateJoined;
	}

	/*
	 * Setter for name
	 * 
	 * @param newName member's new name
	 */
	public void setMemberName(String newName) {
		name = newName;
	}

	/*
	 * Setter for address
	 * 
	 * @param newAddress member's new address
	 */
	public void setMemberAddress(String newAddress) {
		address = newAddress;
	}

	/*
	 * Setter for phone
	 * 
	 * @param newName member's new name
	 */
	public void setMemberPhone(String newPhone) {
		phone = newPhone;
	}

	/*
	 * Setter for fee
	 * 
	 * @param newFee member's new fee
	 */
	public void setMemberFee(double newFee) {
		fee = newFee;
	}

	public static void retrieve(ObjectInputStream input) throws IOException, ClassNotFoundException {
		idCounter = (int) input.readObject();
	}

	public static void save(ObjectOutputStream output) throws IOException {
		output.writeObject(idCounter);
	}

	/**
	 * Print to the system
	 * 
	 * @param id, name, address, phone, fee, dateJoined
	 */
	@Override
	public String toString() {
		return "Member [id=" + id + ", + name=" + name + ", address=" + address + ", phone=" + phone + " + , fee=" + fee
				+ ", dateJoined=" + dateJoined + "]";
	}

}