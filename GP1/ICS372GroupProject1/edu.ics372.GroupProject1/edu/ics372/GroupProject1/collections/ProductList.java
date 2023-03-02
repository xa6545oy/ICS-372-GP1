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
