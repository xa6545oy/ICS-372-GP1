package edu.ics372.GroupProject1.collections;

import java.util.*;

import edu.ics372.GroupProject1.entities.Member;
import edu.ics372.GroupProject1.entities.Product;

public class Cart {
	private Member member;
	private List<Product> products;
	private Map<Product, Integer> quantities;

	public Cart(Member member) {
		this.member = member;
		products = new ArrayList<>();
		quantities = new HashMap<>();
	}

	/**
	 * method takes a product and a quantity as input and adds them to the cart. If
	 * the product already exists in the cart, the quantity is added to the existing
	 * quantity. Otherwise, a new entry is created in the quantities map.
	 * 
	 * @param product, quantity
	 */
	public void addItem(Product product, int quantity) {
		products.add(product);
		if (quantities.containsKey(product)) {
			int currentQuantity = quantities.get(product);
			quantities.put(product, currentQuantity + quantity);
		} else {
			quantities.put(product, quantity);
		}
	}

	/**
	 * method removes a product from the cart and its corresponding quantity
	 * 
	 * @param product
	 */
	public void removeItem(Product product) {
		products.remove(product);
		quantities.remove(product);
	}

	/**
	 * method calculates the total price of the cart by loop over the items list and
	 * adding up the product of the current price and quantity for each product
	 * 
	 * @return totalPrice
	 */
	public double getTotalPrice() {
		double totalPrice = 0;
		for (Product product : products) {
			int quantity = quantities.get(product);
			double productPrice = product.getProductPrice() * quantity;
			totalPrice += productPrice;
		}

		return totalPrice;
	}

	/**
	 * method check out the items in cart and check if the product needs to reorder
	 * @param productId
	 * @param quantity
	 *
	 */

	public void checkOut(String productId, int quantity){
		Iterator iterator = this.products.iterator();
		while(iterator.hasNext()){
			Product product = (Product)iterator.next();
			double productPrice = quantity*product.getProductPrice();
			if(productId.equals(product.getProductID())) {
				System.out.println(product.getProductName() + ", " + quantity + " "
						+ product.getProductPrice() + " " + productPrice);
			}

			if((product.getProductQuantity() - quantity) <= product.getProductMinOrderLevel() ){
				product.reorder();
				product.setOrderPlaced(true);
				String message = "You have successfully reordered " + product.getProductName();
				System.out.println(message);
			}
			if(product.isOrderPlaced() == true){
				System.out.println("This product is already reordered, no action needed!");
			}
			removeItem(product);
		}
		System.out.println("Total: " + getTotalPrice());
	}




//	public void checkout() {
//		System.out.println("Items in cart: ");
//		for (Product product : products) {
//			int quantity = quantities.get(product);
//			double productPrice = product.getProductPrice() * quantity;
//			System.out.println(
//					product.getProductName() + " " + quantity + product.getProductPrice() + " " + productPrice);
//
//		}
//
//		double totalPrice = getTotalPrice();
//		System.out.println("Total: " + totalPrice);
//
//		for (Product product : quantities.keySet()) {
//			int productQuantity = product.getProductQuantity();
//			int productMinOrderLevel = product.getProductMinOrderLevel();
//			int quantityInCart = quantities.get(product);
//			if (productQuantity + quantityInCart <= productMinOrderLevel && product.isOrderPlaced()) {
//				int orderQuantity = productMinOrderLevel * 2;
//				product.setOrderPlaced(true);
//				System.out.println("Order placed for " + orderQuantity + " units of " + product.getProductName());
//			}
//		}
//
//		member.pay(totalPrice);
//		System.out.println("Member " + member.getMemberName() + "paid " + totalPrice);
//	}
}
