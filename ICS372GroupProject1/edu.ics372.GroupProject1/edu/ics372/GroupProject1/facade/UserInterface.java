package edu.ics372.GroupProject1.facade;

import edu.ics372.GroupProject1.collections.ProductList;
import edu.ics372.GroupProject1.entities.Product;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.StringTokenizer;

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
	private static final double MEMBERSHIP_FEE = 50;

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
	} // end of UserInterface constructor

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
	} // end of instance

	/**
	 * this is the main method that start the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UserInterface.instance().run();
	} // end main

	/**
	 * this is the exit method that exit the program
	 * 
	 */
	public void exit() {
		System.out.println("Closing program");
		System.exit(0);
	} // end void exit

	public void load() throws IOException, ClassNotFoundException {
		FileInputStream fileOut = new FileInputStream("businessData");
		ObjectInputStream fileIn = new ObjectInputStream(fileOut);

		business = (BusinessSystem) fileIn.readObject();

		fileIn.close();
	} // end load()

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
	} // end of yesOrNo

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
	} // end of getToken

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
				addMember();
				break;
			case REMOVE_MEMBER:
				removeMember();
				break;
			case RETRIEVE_MEMBER_INFO:
				// retrieveMemberInfo();
				break;
			case ADD_PRODUCTS:
				addProduct();
				break;
			case CHECK_MEMBER_CART:

				break;
			case RETRIEVE_PRODUCT_INFO:
				retrieveProductByName();
				break;
			case PROCESS_SHIPMENT:

				break;
			case CHANGE_PRICE:

				break;
			case PRINT_TRANSACTION:
				printTransaction();
				break;
			case LIST_ALL_MEMBERS:
				listMembers();
				break;
			case LIST_ALL_PRODUCTS:
				listProducts();
				break;
			case LIST_OUTSTANDING_ORDER:

				break;
			case SAVE:
				save();
				break;
			case RETRIEVE_FILE:
				retrieve();
				break;
			case HELP:
				help();
				break;
			case EXIT:
				exit();
				break;
			default:
				break;
			} // end of switch case
		} // end of while loop

		exit();
	} // end of run

	/**
	 * Prompts for a command from the keyboard
	 * 
	 * @return a valid command
	 * 
	 */
	public int getCommand() {
		while (true) {
			try {
				int inputValue = Integer.parseInt(getToken("Enter command or 15 for help: "));
				if (inputValue >= EXIT && inputValue <= HELP) {
					return inputValue;
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Enter a number: ");
			}
		} // end while loop
	} // end of getCommand

	/**
	 * Gets a name after prompting
	 * 
	 * @param prompt - whatever the user wants as prompt
	 * @return - the token from the keyboard
	 * 
	 */
	public String getInput(String prompt) {
		do {
			try {
				System.out.println(prompt);
				String line = reader.readLine();
				return line;
			} catch (IOException ioe) {
				System.exit(0);
			}
		} while (true);

	} // end of getInput

	/**
	 * Method display help menu; descriptions for each cases.
	 */
	public void help() {
		System.out.println("What would you like to do?");
		System.out.println("0.\tExit - Quit the program");
		System.out.println("1.\tEnroll a member");
		System.out.println("2.\tRemove a member");
		System.out.println("3.\tRetrieve member info");
		System.out.println("4.\tAdd products");
		System.out.println("5.\tCheck out a member’ cart");
		System.out.println(
				"6.\tRetrieve product info: Given a product name, the system displays the product’s id, price, and stock in hand.");
		System.out.println("7.\tProcess shipment");
		System.out.println("8.\tChange price");
		System.out.println("9.\tPrint transactions");
		System.out.println("10.\tList all members. List name, id, and address of each member.");
		System.out.println(
				"11.\tList all products. List product name, id, current price, and a minimum reorder level for the product.");
		System.out.println(
				"12.\tList all outstanding orders. List for each order that has not been fulfilled, the product name, id, and amount ordered.");
		System.out.println("13.\tSave: Saves all data to disk.");
		System.out.println(
				"14.\tRetrieve: Retrieves a given file and use it. Only applicable before any other command is issued.");
		System.out.println("15.\tHelp menu");
	} // end of help

	/**
	 * Method to be called for adding a product. It prompts user to enter certain
	 * product information and then add to the system data.
	 */
	public void addProduct() {
		Request.instance().setProductName(getInput("Enter product name: "));

		double productPrice = Double.parseDouble(getInput("Enter product price: "));
		Request.instance().setProductPrice(productPrice);

		String productMinOrderLevelInString = getInput("Enter product minimum order level: ");
		int productMinOrderLevel = Integer.parseInt(productMinOrderLevelInString);
		Request.instance().setProductMinOrderLevel(productMinOrderLevel);

		Result result = business.addProduct(Request.instance());
		if (result.getResultCode() != Result.OPERATION_COMPLETED) {
			System.out.println("Could not add product!");
		} else {
			System.out.println(result.getProductName() + "'s id is " + result.getProductId());
		}

	} // end addProduct

	/**
	 * Display all products information
	 */
	public void listProducts() {
		Iterator<Result> iterator = business.getProducts();
		System.out.println("Getting ready to print all Products information");
		System.out
				.println("List of all products (product name, id, pricing, and minimum reorder level for the product)");
		while (iterator.hasNext()) {
			Result result = iterator.next();
			System.out.println(result.getProductName() + " " + result.getProductId() + " " + result.getProductPrice()
					+ " " + result.getProductMinOrderLevel());
		} // end while loop
	}// end getProducts

	/*
	 * Method to create a member and requests information about the member as well
	 * as a fee that is to be paid to become a member
	 */
	public void addMember() {
		Request.instance().setMemberName(getInput("Enter member name: "));
		Request.instance().setMemberAddress(getInput("Enter member address: "));
		Request.instance().setMemberPhone(getInput("Enter member phone number: "));
		double amountPaid = Double.parseDouble(getInput("Please pay the membership fee of 50: "));
		while (amountPaid != MEMBERSHIP_FEE) {
			if (amountPaid == 0)
				return;
			amountPaid = Double.parseDouble(getInput(
					"Membership fee is 50. Amount paid is not enough! Please re-enter the correct amount or enter 0 to exit."));
		} // end while loop

		Request.instance().setMemberFee(amountPaid);

		Result result = business.addMember(Request.instance());
		if (result.getResultCode() != Result.OPERATION_COMPLETED)
			System.out.println("Could not add member");
		else
			System.out.println(result.getMemberName() + "'s id is " + result.getMemberId());
	} // end addMember

	/*
	 * Method to be called for listing all members
	 */
	public void listMembers() {
		Iterator<Result> iterator = business.getMembers();
		System.out.println("List of all members(id, name, address)");
		while (iterator.hasNext()) {
			Result result = iterator.next();
			System.out.println(result.getMemberId() + " " + result.getMemberName() + " " + result.getMemberAddress());
		} // end while loop
	} // end listMembers

	/*
	 * Method to be called for removing members. Prompts user to enter the member id
	 * to be removed
	 */
	public void removeMember() {
		do {
			Request.instance().setMemberId(getInput("Enter member id: "));
			Result result = business.removeMember(Request.instance());
			switch (result.getResultCode()) {
			case Result.MEMBER_NOT_FOUND:
				System.out.println("Member id " + Request.instance().getMemberId() + " does not exist in the system.");
				break;
			case Result.OPERATION_COMPLETED:
				System.out.println("Member was successfully removed.");
			default:
				System.out.println("There are no more members.");
			} // end of switch

			if (!yesOrNo("Remove more members?"))
				break;
		} while (true);
	} // end of removeMember

	/*
	 * Method to be called when retrieving a certain member's information using
	 * their name as reference. If there are more than 1 member with the same name
	 * it'll display all members with the name's information
	 */
	public void retrieveMemberInfo() {
		Request.instance().setMemberName(getInput("Enter the member's name: "));
		Iterator<Result> memberWithName = business.retrieveMemberWithName(Request.instance());

		System.out.println("Information on " + Request.instance().getMemberName() + " (address, fee paid, id): ");

		while (memberWithName.hasNext()) {
			Result result = memberWithName.next();
			System.out.println(result.getMemberAddress() + " " + result.getMemberFee() + " " + result.getMemberId());
		} // end of while loop

	} // end of retrieveMemberInfo

	/**
	 * Saving the Business object
	 */
	private void save() {
		if (business.save()) {
			System.out.println("Sucessfully save Business data!!");
		} else {
			System.out.println("Error while saving Business data to system!");
		}
	}

	/**
	 * Method to be called for retrieving saved data. Uses the appropriate Library
	 * method for retrieval.
	 */
	private void retrieve() {
		try {
			if (business == null) {
				business = BusinessSystem.retrieve();
				if (business != null) {
					System.out.println("Sucessfuly load Business data!!");
				} else {
					System.out.println("Error while loading Business data! Create a new data? ");
					business = BusinessSystem.instance();
				}
			}
		} catch (Exception cnfe) {
			cnfe.printStackTrace();
		}
	} // end of retrieve

	/*
	 * Method to be called for retrieving all product by its name. Prompts user to
	 * enter product name
	 * 
	 * @param productName
	 * 
	 * @return product information
	 */
	public void retrieveProductByName() {
		String productName = getInput("Enter product name: ");
		try {
			String info = business.getProductInfoByName(productName);
			System.out.println(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // end retrieveProductByName

	public void printTransaction() {
		String memberID = getInput("Enter member ID: ");
		String startDate = getInput("Enter start date (mm/dd/yyyy): ");
		String endDate = getInput("Enter end date (mm/dd/yyyy): ");

		try {
			business.printTransactions(memberId, startDateString, endDateString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end printTransaction()

	public void processShipment(String productId, int deliveredQuantity){
		for(Product product: ProductList.getInstance()){
			int currentQuantity = product.getProductQuantity();
			if(productId.equals(product.getProductID())){
				currentQuantity += deliveredQuantity;
				product.toString();
			}


		}
	}

}