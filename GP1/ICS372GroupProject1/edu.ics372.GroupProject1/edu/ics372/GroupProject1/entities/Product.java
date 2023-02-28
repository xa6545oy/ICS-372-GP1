package edu.ics372.GroupProject1.entities;

public class Product {
	private String productName;
	private String productID;
	private double productPrice;
	private int productMinOrderLevel;
	private int quantity;

	/**
	 * The Product class constructor initializes productName, productID,
	 * currentPrice, and minReorderLevel. And set first quantity to 0
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
	 * @param quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * set quantity for the product
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Print to the system
	 * 
	 * @param productName, productID, currentPrice, minReorderLevel, quantity
	 */
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productID=" + productID + ", currentPrice=" + productPrice
				+ ", minReorderLevel=" + productMinOrderLevel + ", quantity=" + quantity + "]";
	}

}
