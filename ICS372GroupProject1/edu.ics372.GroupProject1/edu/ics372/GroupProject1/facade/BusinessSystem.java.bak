package edu.ics372.GroupProject1.facade;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

import edu.ics372.GroupProject1.collections.Cart;
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

	/**
	 * Returns an iterator to Member info. The Iterator returned is a safe one, in
	 * the sense that only copies of the Member fields are assembled into the
	 * objects returned via next().
	 * 
	 * @return an Iterator to Result - only the Member fields are valid.
	 */
	public Iterator<Result> getMembers() {
		return new MemberIterator(members.iterator());
	}

	/**
	 * Singleton pattern
	 * 
	 * @return the singleton object
	 */
	public static BusinessSystem instance() {
		if (business == null) {
			return business = new BusinessSystem();
		} else {
			return business;
		}
	} // end instance

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
	} // end of retrieve

	/**
	 * Searches for a given member
	 * 
	 * @param memberId id of the member
	 * @return true iff the member is in the member list collection
	 */
	public Result searchMember(Request request) {
		Result result = new Result();
		Member member = members.search(request.getMemberId());
		if (member == null) {
			result.setResultCode(Result.MEMBER_NOT_FOUND);
		} else {
			result.setResultCode(Result.OPERATION_COMPLETED);
			result.setMemberFields(member);
		}
		return result;
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
	} // end of addProduct

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
	} // end save

	/*
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
	} // end getProductByName

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
	} // end getProductInfoByName

	/**
	 * Given a product id, the system search for the product and change the price of
	 * the product
	 *
	 * @return the product with its changed (new) price
	 */
	public Result changeProductPrice(Request request) {
		Result result = new Result();
		Product product = products.searchProduct(request.getProductId());
		if (product == null) {
			result.setResultCode(Result.PRODUCT_NOT_FOUND);
			return result;
		}
		result.setProductFields(product);
		result.setProductPrice(request.getProductPrice());
		result.setResultCode(Result.OPERATION_COMPLETED);
		return result;
	} // end changeProductPrice

	/**
	 * Organizes the operations for adding a member
	 * 
	 * @param memberName    member name
	 * @param memberAddress member address
	 * @param memberPhone   member phone
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
	} // end of addMember

	/*
	 * Removes a specific member from the memberlist
	 * 
	 * @param memberId is the id of a member
	 * 
	 * @return the code of the outcome
	 */
	public Result removeMember(Request request) {
		Result result = new Result();
		Member member = members.search(request.getMemberId());

		if (member == null) {
			result.setResultCode(Result.MEMBER_NOT_FOUND);
			return result;
		}

		if (members.removeMember(request.getMemberId())) {
			result.setResultCode(Result.OPERATION_COMPLETED);
			return result;
		}

		result.setResultCode(Result.OPERATION_FAILED);
		return result;
	} // end of removeMember

	/*
	 * Iterates through the members collection and adds all members with the name
	 * into the memberWithName collection and returns it
	 * 
	 * @param Request request is used to get the name of the member with the
	 * information we want
	 * 
	 * @return is a collection of all or one member's information
	 */
	public Iterator<Result> retrieveMemberWithName(Request request) {
		LinkedList<Result> memberWithName = new LinkedList<Result>();

		for (Member member : members) {
			if (member.getMemberName().equals(request.getMemberName())) {
				Result result = new Result();
				result.setMemberFields(member);
				memberWithName.add(result);
			}
		}

		Iterator<Result> iteratorOfName = memberWithName.iterator();

		return iteratorOfName;
	} // end of retrieveMemberWithName

	/*
	 * Iterates through the product collection and adds all product with the name
	 * into the productWithname collection and returns it
	 * 
	 * @param Request request is used to get the name of the product with the
	 * information we want
	 * 
	 * @return is a collection of all or one product information
	 */
	public Iterator<Result> retrieveProductWithName(Request request) {
		LinkedList<Result> productWithname = new LinkedList<Result>();

		for (Product product : products) {
			if (product.getProductName().equals(request.getProductName())) {
				Result result = new Result();
				result.setProductFields(product);
				productWithname.add(result);
			}
		}

		Iterator<Result> iteratorOfName = productWithname.iterator();

		return iteratorOfName;
	} // end of retrieveProductWithName

	/**
	 * checking if member can be checked out
	 * 
	 * @param member
	 */
	public void checkout(Member member) {
		Cart cart = new Cart(member);
		if (cart != null) {
			cart.checkOut("", 0);
		} else
			System.out.println("Member does not have anything in cart.");
	}

}
