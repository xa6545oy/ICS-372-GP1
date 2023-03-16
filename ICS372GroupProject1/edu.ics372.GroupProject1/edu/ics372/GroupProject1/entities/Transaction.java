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

	/**
	 * The Product class constructor initializes productName, productID,
	 * currentPrice, and minReorderLevel. And set first quantity to 0
	 * 
	 * @param ID       is the ID of the transaction
	 * 
	 * @param member   is the member of the transaction
	 * 
	 * @param products is the list of product that member has in transaction
	 * 
	 * @param date     is the date of transaction
	 */
	public Transaction(int ID, Member member, ProductList products) {
		this.ID = ID;
		this.member = member;
		this.products = products;
		date = new GregorianCalendar();
	}

	/**
	 * get transaction ID
	 * 
	 * @return ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * get member information
	 * 
	 * @return member
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * get product list the member has in transaction
	 * 
	 * @return products
	 */
	public ProductList getProducts() {
		return products;
	}

	/**
	 * set transaction date
	 * 
	 * @param date
	 */
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
