package edu.ics372.GroupProject1.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.ics372.GroupProject1.collections.ProductList;

public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	private Calendar date;
	private int ID;
	private Member member;
	private ProductList products;

	public Transaction(int ID, Member member, ProductList products) {
		this.ID = ID;
		this.member = member;
		this.products = products;
		date = new GregorianCalendar();
	}

	public int getID() {
		return ID;
	}

	public Member getMember() {
		return member;
	}

	public ProductList getProducts() {
		return products;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * Checks whether this transaction is on the given date
	 * 
	 * @param date The date for which transactions are being sought
	 * @return true iff the dates match
	 */
	public boolean onDate(Calendar date) {
		return ((date.get(Calendar.YEAR) == this.date.get(Calendar.YEAR))
				&& (date.get(Calendar.MONTH) == this.date.get(Calendar.MONTH))
				&& (date.get(Calendar.DATE) == this.date.get(Calendar.DATE)));
	}

	/**
	 * Returns the date as a String
	 * 
	 * @return date with month, date, and year
	 */
	public String getDate() {
		return date.get(Calendar.MONTH) + "/" + date.get(Calendar.DATE) + "/" + date.get(Calendar.YEAR);
	}

}
