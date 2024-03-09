package com.jsp.Model;

public class Book {

	private String BookName;
	private String BookAuthor;
	private double BookPrice;
	
	@Override
	public String toString() {
		return "Book [BookName=" + BookName + ", \nBookAuthor=" + BookAuthor + ", \nBookPrice=" + BookPrice + "]";
	}
	
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String BookName) {
		this.BookName =BookName;
	}
	public String getBookAuthor() {
		return BookAuthor;
	}
	public void setBookAuthor(String BookAuthor) {
		this.BookAuthor=BookAuthor;
	}
	public double getBookPrice() {
		return BookPrice;
	}
	public void setBookPrice(double price) {
		this.BookPrice=BookPrice;
	}
	
	
	

}
