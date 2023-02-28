package edu.ics372.GroupProject1.facade;

import java.io.Serializable;

import edu.ics372.GroupProject1.collections.ProductList;

public class BusinessSystem implements Serializable {
	private static final long serialVersionUID = 1L;
	private ProductList products = ProductList.getInstance();
	private static BusinessSystem business;

	private BusinessSystem() {

	}

	public static BusinessSystem instance() {
		if (business == null) {
			return business = new BusinessSystem();
		} else {
			return business;
		}
	}// end instance

}
