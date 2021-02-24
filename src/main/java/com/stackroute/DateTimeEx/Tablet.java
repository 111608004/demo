package com.stackroute.DateTimeEx;

import java.time.LocalDate;

public class Tablet {
	
	String tabletName;
	String manufacturer;
	LocalDate mfgDate, expDate;
	
	
	public static void main(String[] args) {

	}


	public Tablet(String tabletName, String manufacturer, LocalDate mfgDate, LocalDate expdate) {
		super();
		this.tabletName = tabletName;
		this.manufacturer = manufacturer;
		this.mfgDate = mfgDate;
		this.expDate = expdate;
	}


	public LocalDate getExpdate() {
		return expDate;
	}


	@Override
	public String toString() {
		return "Tablet [tabletName=" + tabletName + ", manufacturer=" + manufacturer + ", mfgDate=" + mfgDate
				+ ", expDate=" + expDate + "]";
	}


	public String getTabletName() {
		return tabletName;
	}


	public void setTabletName(String tabletName) {
		this.tabletName = tabletName;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public LocalDate getMfgDate() {
		return mfgDate;
	}


	public void setMfgDate(LocalDate mfgDate) {
		this.mfgDate = mfgDate;
	}


	public void setExpdate(LocalDate expdate) {
		this.expDate = expdate;
	}

	
}
