package edu.ics372.GroupProject1.facade;

import edu.ics372.GroupProject1.entities.Product;

public abstract class DataTransfer {
	private String productId;
	private String productName;
	private double productPrice;
	private int productMinOrderLevel;

	/**
	 * This sets all fields to "none".
	 */
	public DataTransfer() {
		reset();
	}

	// Getters and Setters
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

	public void setProductFields(Product product) {

		productId = product.getProductID();
		productName = product.getProductName();
		productPrice = product.getProductPrice();
		productMinOrderLevel = product.getProductMinOrderLevel();

	}// end setProdictFields

	public void reset() {
		productId = "Invalid product ID";
		productName = "No product Name";
		productPrice = 0;
		productMinOrderLevel = 0;
	}// end reset

}
