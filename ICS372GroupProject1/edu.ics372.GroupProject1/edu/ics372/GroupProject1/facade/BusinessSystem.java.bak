package edu.ics372.GroupProject1.facade;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;

import edu.ics372.GroupProject1.collections.MemberList;
import edu.ics372.GroupProject1.collections.ProductList;
import edu.ics372.GroupProject1.entities.Member;
import edu.ics372.GroupProject1.entities.Product;
import edu.ics372.GroupProject1.iterators.MemberIterator;
import edu.ics372.GroupProject1.iterators.ProductIterator;

public class BusinessSystem implements Serializable {
	private static final long serialVersionUID = 1L;
	private ProductList products = ProductList.getInstance();
	private MemberList members = MemberList.getInstance();
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
	
	public Iterator<Result> getMembers() {
		return new MemberIterator(members.iterator());
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
	 * @param productPrice         current Price of product
	 * @param productMinOrderLevel product minimum reorder level
	 * @return the Product object
	 */
	public Result addProduct(Request request) {
		Result result = new Result();
		Product product = new Product(request.getProductName(), request.getProductPrice(),
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

	/**
	 * Save data to system
	 * 
	 * @return true if data is successfully saved
	 */
	public boolean save() {
		try {
			FileOutputStream fileIn = new FileOutputStream("businessData");
			ObjectOutputStream output = new ObjectOutputStream(fileIn);
			output.writeObject(business);
			Member.save(output);
			fileIn.close();
			return true;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		}
	}// end save

	/**
	 * Given a product name, the system return the product
	 * 
	 * @return product
	 */
	public Product getProductByName(String productName) {
		for (Product product : products) {
			if (product.getProductName().equals(productName)) {
				return product;
			}
		}
		return null;
	}// end getProductByName

	/**
	 * Given a product name, the system return the product name, id, price, min
	 * order level, quantity. if not found, notify user.
	 * 
	 * @return product
	 */
	public String getProductInfoByName(String productName) {
		Product product = getProductByName(productName);
		if (product != null) {
			return "Product Name: " + product.getProductName() + "Product ID: " + product.getProductID() + ", Price: "
					+ product.getProductPrice() + ", Minimun order level: " + product.getProductMinOrderLevel()
					+ ", Stock quantity: " + product.getProductQuantity();
		} else {
			return "Product not found!!";
		}
	}// end getProductInfoByName
	
	/**
	 * Organizes the operations for adding a member
	 * 
	 * @param memberName member name
	 * @param memberAddress member address
	 * @param memberPhone member phone
	 * @return the Member object
	 */
	public Result addMember(Request request) {
		Result result = new Result();
		Member member = new Member(request.getMemberName(), request.getMemberAddress(), request.getMemberPhone(),
				request.getMemberFee());

		if (members.insertMember(member)) {
			result.setResultCode(Result.OPERATION_COMPLETED);
			result.setMemberFields(member);
			return result;
		} else {
			result.setResultCode(Result.OPERATION_FAILED);
			return result;
		}
	}

}
