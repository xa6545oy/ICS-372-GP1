package edu.ics372.GroupProject1.facade;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

	BusinessSystem business = new BusinessSystem();

	/**
	 * this is the main method that start the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		UserInterface userInterface = new UserInterface();

		try {
			userInterface.run();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}// end main

	public static UserInterface instance() {
		if (userInterface == null) {
			return useInterface = new UserInterface();
		} else {
			return userInterface;
		}
	}// end instance

	private UserInterface() {
		File fileIn = new File("BusinessData");

		if (fileIn.exists() && fileIn.canRead()) {
			if (yesOrNo("Override current data. Save it? ")) {
				retrieve();
			}
		}

		business = BusinessSystem.instance();
	}

	/**
	 * the run method execute the code and ask which function the user want to
	 * invoke
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void run() throws IOException {

		// Create a Scanner object
		Scanner input = new Scanner(System.in);

		System.out.println("Business Processes");

		/*
		 * This is the primary loop. Every time the program returns here, it lists out a
		 * numbered list of possible actions. One action, one use case, one method. The
		 * user will input an integer, and a switch statement will call the
		 * corresponding method.
		 */
		while (true) {
			System.out.println("What would you like to do?");
			System.out.println("0. \tExit");
			System.out.println("1. \tEnroll a member");
			System.out.println("2. \tRemove a member");
			System.out.println("3. \tRetrieve member info");
			System.out.println("4. \tAdd products");
			System.out.println("5. \tCheck out a member's cart");
			System.out.println("6. \tRetrieve product info");
			System.out.println("7. \tProcess shipment");
			System.out.println("8. \tChange price");
			System.out.println("9. \tPrint transactions");
			System.out.println("10. \tList all members");
			System.out.println("11. \tList all products");
			System.out.println("12. \tList all outstanding orders");
			System.out.println("13. \tSave");
			System.out.println("14. \tRetrieve");
			System.out.println("15. \tHelp");

			System.out.print("\nYour selection: ");
			int selection = Integer.parseInt(input.nextLine());

			switch (selection) {
			case 0:
				exit();
				break;
			case 1:
				// enrollMember();
				break;

			case 2:
				// removeMember();
				break;
			case 3:
				// retrieveMemberInfo();
				break;

			case 4:
				// addProduct();
				break;
			case 5:
				// checkoutCart();
				break;

			case 6:
				// retrieveProductInfo();
				break;
			case 7:
				// processShipment();
				break;

			case 8:
				// changePrice();
				break;

			case 9:
				// printTransaction();
				break;

			case 10:
				// listMembers();
				break;
			case 11:
				// listProducts();
				break;

			case 12:
				// listOrders();
				break;
			case 13:
				// save();
				break;

			case 14:
				// retrieve();
				break;
			case 15:
				// help();
				break;

			default:
				break;

			} // end switch

			input.close();
		} // end while loop

	}// end void run

	/**
	 * this is the exit method that exit the program
	 * 
	 */
	public void exit() {
		System.out.println("Closing program");
		System.exit(0);
	}// end void exit

	public void addProducts() {
		do {
			Request.instance().setProductName(getName("Emter product: "));
			Request.instance().setProductId(getToken("Enter ID: "));
			Request.instance().setProductPrice(getToken("Enter price: "));
			Request.instance().setProductMinOrderLevel(getToken("Enter minimun order level: "));

			Result result = business.addProduct(Request.instance());

			if (result.getResultCode() != Result.OPERATION_COMPLETED) {

			}
		} while (yesOrNo("Add more products? "));
	}// end addProduct

}
