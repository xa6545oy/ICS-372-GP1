package edu.ics372.GroupProject1.facade;

import java.util.Calendar;

public class Request extends DataTransfer {
	private static Request request;
	private Calendar date;

	private Request() {

	}

	/**
	 * Returns the only instance of the class.
	 * 
	 * @return the only instance
	 */
	public static Request instance() {
		if (request == null) {
			request = new Request();
		}
		return request;
	}

	public Calendar getDate() {
		return date;
	}// end getDate

	public void setDate(Calendar date) {
		this.date = date;
	}
}
