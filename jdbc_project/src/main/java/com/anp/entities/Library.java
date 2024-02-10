package com.anp.entities;

import java.time.LocalDate;

public class Library {

	private int Book_ID;
	private String Book_Name;
	private LocalDate Assured_Date;
	private LocalDate Renewal_Date;
	private LocalDate Return_Date;
	public int getBook_ID() {
		return Book_ID;
	}
	public void setBook_ID(int book_ID) {
		Book_ID = book_ID;
	}
	public String getBook_Name() {
		return Book_Name;
	}
	public void setBook_Name(String book_Name) {
		Book_Name = book_Name;
	}
	public LocalDate getAssured_Date() {
		return Assured_Date;
	}
	public void setAssured_Date(LocalDate assured_Date) {
		Assured_Date = assured_Date;
	}
	public LocalDate getRenewal_Date() {
		return Renewal_Date;
	}
	public void setRenewal_Date(LocalDate renewal_Date) {
		Renewal_Date = renewal_Date;
	}
	public LocalDate getReturn_Date() {
		return Return_Date;
	}
	public void setReturn_Date(LocalDate return_Date) {
		Return_Date = return_Date;
	}
	public Library(int book_ID, String book_Name, LocalDate assured_Date, LocalDate renewal_Date,
			LocalDate return_Date) {
		super();
		Book_ID = book_ID;
		Book_Name = book_Name;
		Assured_Date = assured_Date;
		Renewal_Date = renewal_Date;
		Return_Date = return_Date;
	}
	
}
