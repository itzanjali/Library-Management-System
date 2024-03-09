package com.jsp.Model;

import java.util.List;

public class Library {

	@Override
	public String toString() {
		return "Library [LibraryName=" + LibraryName + ", LibraryAddress=" + LibraryAddress + ", pincode=" + pincode
				+ ", book=" + books + "]";
	}

	private String LibraryName;
	private String LibraryAddress;
	private int pincode;

	private List<Book> books;

	public String getLibraryName() {
		return LibraryName;
	}

	public void setLibraryName(String LibraryName) {
		this.LibraryName = LibraryName;
	}

	public String getLibraryAddress() {
		return LibraryAddress;
	}

	public void setLibraryAddress(String LibraryAddress) {
		this.LibraryAddress = LibraryAddress;
	}

	public int getpincode() {
		return pincode;
	}

	public void setpincode(int pincode) {
		this.pincode = pincode;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {

	}
}
