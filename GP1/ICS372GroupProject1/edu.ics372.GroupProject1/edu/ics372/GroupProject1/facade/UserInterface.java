package edu.ics372.GroupProject1.facade;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.StringTokenizer;

import edu.ics372.GroupProject1.entities.Product;

public class UserInterface {

	private static BusinessSystem business;
	private static UserInterface userInterface;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	private static final int EXIT = 0;
	private static final int ENROLL_MEMBER = 1;
	private static final int REMOVE_MEMBER = 2;
	private static final int RETRIEVE_MEMBER_INFO = 3;
	private static final int ADD_PRODUCTS = 4;
	private static final int CHECK_MEMBER_CART = 5;
	private static final int RETRIEVE_PRODUCT_INFO = 6;
	private static final int PROCESS_SHIPMENT = 7;
	private static final int CHANGE_PRICE = 8;
	private static final int PRINT_TRANSACTION = 9;
	private static final int LIST_ALL_MEMBERS = 10;
	private static final int LIST_ALL_PRODUCTS = 11;
	private static final int LIST_OUTSTANDING_ORDER = 12;
	private static final int SAVE = 13;
	private static final int RETRIEVE_FILE = 14;
	private static final int HELP = 15;

	/**
	 * Singleton pattern
	 * 
	 * @return the singleton object
	 */
	private UserInterface() {
		if (yesOrNo("Look for saved data and  use it?")) {
			retrieve();
		} else {
			business = BusinessSystem.instance();
		}
	}

	/**
	 * Supports the singleton pattern
	 * 
	 * @return the singleton object
	 */
	public static UserInterface instance() {
		if (userInterface == null) {
			return userInterface = new UserInterface();
		} else {
			return userInterface;
		}
	}

	/**
	 * this is the main method that start the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UserInterface.instance().run();
	}// end main

	/**
	 * this is the exit method that exit the program
	 * 
	 */
	public void exit() {
		System.out.println("Closing program");
		System.exit(0);
	}// end void exit

	public void load() throws IOException, ClassNotFoundException {
		FileInputStream fileOut = new FileInputStream("businessData");
		ObjectInputStream fileIn = new ObjectInputStream(fileOut);

		business = (BusinessSystem) fileIn.readObject();

		fileIn.close();
	}// end load()

	/**
	 * Queries for a yes or no and returns true for yes and false for no
	 * 
	 * @param prompt The string to be prepended to the yes/no prompt
	 * @return true for yes and false for no
	 * 
	 */
	private boolean yesOrNo(String prompt) {
		String more = getToken(prompt + " (Y|y)[es] or anything else for no");
		if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
			return false;
		}
		return true;
	}

	/**
	 * Gets a token after prompting
	 * 
	 * @param prompt - whatever the user wants as prompt
	 * @return - the token from the keyboard
	 * 
	 */
	public String getToken(String prompt) {
		do {
			try {
				System.out.println(prompt);
				String line = reader.readLine();
				StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");
				if (tokenizer.hasMoreTokens()) {
					return tokenizer.nextToken();
				}
			} catch (IOException ioe) {
				System.exit(0);
			}
		} while (true);
	}

	/**
	 * Method to be called for retrieving saved data. Uses the appropriate Library
	 * method for retrieval.
	 * 
	 */
	private void retrieve() {
		try {
			if (business == null) {
				business = BusinessSystem.retrieve();
				if (business != null) {
					System.out.println(" The library has been successfully retrieved from the file LibraryData \n");
				} else {
					System.out.println("File doesnt exist; creating new library");
					business = BusinessSystem.instance();
				}
			}
		} catch (Exception cnfe) {
			cnfe.printStackTrace();
		}
	}

	/**
	 * Orchestrates the whole process. Calls the appropriate method for the
	 * different functionalities.
	 * 
	 */
	public void run() {
		int command;
		help();
		while ((command = getCommand()) != EXIT) {
			switch (command) {
			case ENROLL_MEMBER:
				// addMember();
				break;
			case REMOVE_MEMBER:
				// removeMember();
				break;
			case RETRIEVE_MEMBER_INFO:
				// retrieveMemberInfo();
				break;
			case ADD_PRODUCTS:
				// addProduct();
				break;
			case CHECK_MEMBER_CART:

				break;
			case RETRIEVE_PRODUCT_INFO:

				break;
			case PROCESS_SHIPMENT:

				break;
			case CHANGE_PRICE:

				break;
			case PRINT_TRANSACTION:

				break;
			case LIST_ALL_MEMBERS:

				break;
			case LIST_ALL_PRODUCTS:

				break;
			case LIST_OUTSTANDING_ORDER:

				break;
			case SAVE:
				// save();
				break;
			case RETRIEVE_FILE:

				break;
			case HELP:
				help();
				break;
			}
		}
	}

	public void help() {
		System.out.println("What would you like to do?");
		System.out.println("0.\tExit - Quit the program");
		System.out.println("1.\tEnroll a member");
		System.out.println("2.\tRemove a member");
		System.out.println("3.\tRetrieve member info");
		System.out.println("4.\tAdd products");
		System.out.println("5.\tCheck out a member’ cart");
		System.out.println("6.\tRetrieve product info");
		System.out.println("7.\tProcess shipment");
		System.out.println("8.\tChange price");
		System.out.println("9.\tPrint transactions");
		System.out.println("10.\tList all members");
		System.out.println("11.\tList all products");
		System.out.println("12.\tList all outstanding orders");
		System.out.println("13.\tSaves all data to disk.");
		System.out.println("14.\tRetrieves a given file and use it");
		System.out.println("15.\tHelp menu");
	}

	/**
	 * print all the members
	 */
	public void listMembers() {
		System.out.println("Getting ready to print all Members information");
		business.listMembers();
	}

	/**
	 * print all the products
	 */
	public void listProducts() {
		System.out.println("Getting ready to print all Products information");
		business.listProducts();
	}

	public void addProducts(String productName, String productID, double productPrice, int productMinOrderLevel) {
		for (Product product : products) {
			if (product.getProductName().equals(productName)) {
				System.out.println("Already exists product name: " + productName);
				return;
			}
		} // end for loop

		Product product = new Product(productName, productID, productPrice, productMinOrderLevel);
		products.add(product);

		int orderQuantity = productMinOrderLevel * 2;
		System.out.println("Ordering " + orderQuantity + " of " + productName);

		// TODO

	}// end addProduct

}
