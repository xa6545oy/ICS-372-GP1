package edu.ics372.GroupProject1.collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ics372.GroupProject1.entities.Product;

/**
 * The collection class for Product objects
 * 
 * @author Tai Vu
 */
public class ProductList implements Iterable<Product>, Serializable {

	private static final long serialVersionUID = 1L;
	private List<Product> products = new ArrayList<Product>();
	private static ProductList productList;

	/*
	 * Private for singleton Creates products collection object
	 */
	private ProductList() {

	}

	public static ProductList getInstance() {
		if (productList == null) {
			productList = new ProductList();
		}

		return productList;
	}

	/**
	 * Search for product in product list. Prompts user to enter product ID
	 * 
	 * @param productID
	 * @return product
	 */
	public Product searchProduct(String productID) {
		Iterator<Product> productIterator = products.iterator();
		while (productIterator.hasNext()) {
			Product targetProduct = productIterator.next();
			if (targetProduct.getProductID() == productID) {
				return targetProduct;
			} // end if
		} // end while loop

		return null;
	}// end searchProduct

	/**
	 * Add a new product into the list of products
	 * 
	 * @param product
	 */
	public boolean insertProduct(Product product) {
		products.add(product);
		return true;
	}// end insertProduct

	/**
	 * Add a new product to the list. Check for existing products before adding.
	 * 
	 * @param product
	 */
	public void addProduct(Product product) {
		if (products.contains(product)) {
			System.out.println("Product is already exists.");
		} else {
			products.add(product);
			product.setOrderPlaced(false);
			product.reorder();
		}
	}

	/*
	 * Removes a product from the productList
	 * 
	 * @param productID is the product id
	 * 
	 * @return true if product is removed
	 */
	public boolean removeProduct(String productID) {
		Product product = searchProduct(productID);

		if (product == null)
			return false;
		else
			return products.remove(product);
	}

	/**
	 * get product list
	 * 
	 * @param products
	 */
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public Iterator<Product> iterator() {
		return products.iterator();
	}

}
