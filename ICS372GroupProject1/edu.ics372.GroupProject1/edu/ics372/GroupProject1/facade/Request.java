package edu.ics372.GroupProject1.facade;

import java.util.Calendar;

public class Request extends DataTransfer {
	private static Request request;
	private Calendar startDate, endDate;

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

	public Calendar getStartDate() {
		return startDate;
	}// end getDate

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getDate() {
		return endDate;
	}// end getDate

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
}
