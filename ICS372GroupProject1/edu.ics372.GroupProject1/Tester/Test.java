package Tester;

import edu.ics372.GroupProject1.entities.Member;
import edu.ics372.GroupProject1.entities.Product;
import edu.ics372.GroupProject1.facade.BusinessSystem;
import edu.ics372.GroupProject1.facade.Request;
import edu.ics372.GroupProject1.facade.Result;

public class Test {
	private BusinessSystem business;
	private String[] names = { "Gavin", "Leah", "Madelyn", "Chad", "Veronica" };
	private String[] addresses = { "address1", "address2", "address3", "address4", "address5" };
	private String[] phones = { "505-646-3186", " 430-988-5491", "251-841-1216", "508-505-1270", "505-646-1807" };
	private Member[] members = new Member[5];

	private String[] productNames = { "Soapy", "WeCare", "Kitchen Magic", "SofaSoGood" };
	private double[] productPrices = { 50, 100, 150, 200 };
	private int[] productMinOrderLevels = { 5, 6, 7, 8 };
	private Product[] products = new Product[4];

	/**
	 * Tests Member creation.
	 */
	public void testAddMember() {
		for (int count = 0; count < members.length; count++) {

			Request.instance().setMemberName(names[count]);
			Request.instance().setMemberAddress(addresses[count]);
			Request.instance().setMemberPhone(phones[count]);
			Result result = BusinessSystem.instance().addMember(Request.instance());
			assert result.getResultCode() == Result.OPERATION_COMPLETED;
			assert result.getMemberName().equals(names[count]);
			assert result.getMemberPhone().equals(phones[count]);
		}
	}

	/**
	 * Tests Product creation.
	 */
	public void testAddProduct() {
		for (int count = 0; count < products.length; count++) {
			Request.instance().setProductName(productNames[count]);
			Request.instance().setProductPrice(productPrices[count]);
			Request.instance().setProductMinOrderLevel(productMinOrderLevels[count]);
			Result result = BusinessSystem.instance().addProduct(Request.instance());
			assert result.getResultCode() == Result.OPERATION_COMPLETED;
			assert result.getProductName().equals(productNames[count]);
		}
	}

	public void testSearchMember() {
		Request.instance().setMemberId("M1");
		assert BusinessSystem.instance().searchMember(Request.instance()).getMemberId().equals("M1");
		Request.instance().setMemberId("M3");
		assert BusinessSystem.instance().searchMember(Request.instance()) == null;
	}

	public void testAll() {
		testAddMember();
		testAddProduct();
		testSearchMember();
	}

	public static void main(String[] args) {
		new Test().testAll();
	}

}
