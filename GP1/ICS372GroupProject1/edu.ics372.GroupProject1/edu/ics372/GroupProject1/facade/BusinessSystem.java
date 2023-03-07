package edu.ics372.GroupProject1.facade;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Iterator;

import edu.ics372.GroupProject1.collections.ProductList;
import edu.ics372.GroupProject1.entities.Member;
import edu.ics372.GroupProject1.entities.Product;
import iterators.ProductIterator;

public class BusinessSystem implements Serializable {
	private static final long serialVersionUID = 1L;
	private ProductList products = ProductList.getInstance();
	private static BusinessSystem business;

	/**
	 * Private for the singleton pattern Creates the catalog and member collection
	 * objects
	 */
	private BusinessSystem() {

	}

	/**
	 * Returns an iterator to Product info. The Iterator returned is a safe one, in
	 * the sense that only copies of the Member fields are assembled into the
	 * objects returned via next().
	 * 
	 * @return an Iterator to Result - only the Product fields are valid.
	 */
	public Iterator<Result> getProducts() {
		return new ProductIterator(products.iterator());
	}

	public static BusinessSystem instance() {
		if (business == null) {
			return business = new BusinessSystem();
		} else {
			return business;
		}
	}// end instance

	/**
	 * Retrieves the business data from disk
	 * 
	 * @return a Business object
	 */
	public static BusinessSystem retrieve() {
		try {
			FileInputStream fileIn = new FileInputStream("BusinessSystem Data");
			ObjectInputStream input = new ObjectInputStream(fileIn);
			business = (BusinessSystem) input.readObject();
			Member.retrieve(input);
			return business;

		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return null;
		}
	}

	/**
	 * Organizes the operations for adding a product
	 * 
	 * @param productName          product name
	 * @param productId            product ID
	 * @param productPrice         current Price of product
	 * @param productMinOrderLevel product minimum reorder level
	 * @return the Product object
	 */
	public Result addProduct(Request request) {
		Result result = new Result();
		Product product = new Product(request.getProductName(), request.getProductId(), request.getProductPrice(),
				request.getProductMinOrderLevel());

		if (products.insertProduct(product)) {
			result.setResultCode(Result.OPERATION_COMPLETED);
			result.setProductFields(product);
			return result;
		} else {
			result.setResultCode(Result.OPERATION_FAILED);
			return result;
		}
	}

}
