package edu.ics372.GroupProject1.entities;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private String productName;
	private String productID;
	private double productPrice;
	private int productMinOrderLevel;
	private int productQuantity;

	/**
	 * The Product class constructor initializes productName, productID,
	 * currentPrice, and minReorderLevel. And set first quantity to 0
	 * 
	 * @param productName          is the name of the product
	 * 
	 * @param productID            is the ID of the product
	 * 
	 * @param productPrice         is the current price of the product
	 * 
	 * @param productMinOrderLevel is the minimum reorder level for the product.
	 */
	public Product(String productName, String productID, double productPrice, int productMinOrderLevel) {
		this.productName = productName;
		this.productID = productID;
		this.productPrice = productPrice;
		this.productMinOrderLevel = productMinOrderLevel;
	}// end public Product

	// Getters and Setters

	/**
	 * get product name
	 * 
	 * @param productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * set product name
	 * 
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * get product ID
	 * 
	 * @param productID
	 */
	public String getProductID() {
		return productID;
	}

	/**
	 * set product ID
	 * 
	 * @param productID
	 */
	public void setProductID(String productID) {
		this.productID = productID;
	}

	/**
	 * get current price for the product
	 * 
	 * @param currentPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * set current price for the product
	 * 
	 * @param currentPrice
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * get minimum reorder level for the product
	 * 
	 * @param minReorderLevel
	 */
	public int getProductMinOrderLevel() {
		return productMinOrderLevel;
	}

	/**
	 * set minimum reorder level for the product
	 * 
	 * @param minReorderLevel
	 */
	public void setProductMinOrderLevel(int productMinOrderLevel) {
		this.productMinOrderLevel = productMinOrderLevel;
	}

	/**
	 * get quantity for the product
	 * 
	 * @param productQuantity
	 */
	public int getProductQuantity() {
		return productQuantity;
	}

	/**
	 * set quantity for the product
	 * 
	 * @param productQuantity
	 */
	public void setProductQuantity(int quantity) {
		this.productQuantity = quantity;
	}

	/**
	 * Generate an reorder twice as productMinOrderLevel
	 * 
	 * @param quantity
	 */
	public void reorder() {
		int reorderQuantity = productMinOrderLevel * 2;
		System.out.println("Ordering " + reorderQuantity + " units of " + productName);
	}

	/**
	 * Print to the system
	 * 
	 * @param productName, productID, currentPrice, minReorderLevel, quantity
	 */
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productID=" + productID + ", currentPrice=" + productPrice
				+ ", minReorderLevel=" + productMinOrderLevel + ", quantity=" + productQuantity + "]";
	}

}
