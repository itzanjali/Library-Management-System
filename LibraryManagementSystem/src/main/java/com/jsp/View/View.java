package com.jsp.View;

import java.util.Scanner;

import com.jsp.Controller.Controller;
import com.jsp.Model.Book;
import com.jsp.Model.Library;

public class View {

	static private Library library = new Library(); // creation of library

	public static Library getLibrary() { // to access the private we use getter and setter method
		return library;
	}

	public static void setLibrary(Library Librarys) {
		View.library = Librarys;
	}

	static Scanner myInput = new Scanner(System.in); // create scanner class because we take input from user
	static Controller controller = new Controller(); // controller consist of business logic so we need the logic in
														// view

	static {
		System.out.println("**** Welcome to Library Management System ****");
		System.out.println("------------------------------------------------");
		System.out.println("Enter name of Library");
		String libraryName = myInput.nextLine();
		library.setLibraryName(libraryName);
		//
		System.out.println("Enter Address of Library");
		library.setLibraryAddress(myInput.nextLine());
		System.out.println("Enter Pincode");
		library.setpincode(myInput.nextInt());
	}

	public static void main(String[] args) {
		do {
			System.out.println("select option to perform");
			System.out.println("1.Add Book\n2.Remove Book\n3.Update Book\n4.Get Book\n0.Exit");
			System.out.println("Enter Digit respective to desired option: ");
			byte userchoice = myInput.nextByte();
			myInput.nextLine();
			switch (userchoice) {
			case 0:
				myInput.close();
				System.out.println("-----E X I T E D-----");
				System.exit(0);
				break;

			case 1:
				// case1 for add the book in the library
				Book book = new Book();
				System.out.println("Enter name of the Book: ");
				book.setBookName(myInput.nextLine());
				System.out.println("Enter the Author Name: ");
				book.setBookAuthor(myInput.nextLine());
				System.out.println("Enter the price of Book: ");
				book.setBookPrice(myInput.nextDouble());
				myInput.nextLine();
				controller.addBook(book);
				break;

			case 2:
				// case2 for remove the book in the library
				System.out.println("Enter books name to be remove: ");
				String bookToremove = myInput.nextLine();
				if (controller.removeBook(bookToremove)) {
					System.out.println("Requested Book has been removed");
				} else {
					System.out.println("Book does not exist cannot be remove");
				}
				break;

			case 3:
				// case 3 for update the books in the library
				System.out.println("Enter book name to Update: ");
				Book bookExist = controller.getBook(myInput.nextLine());

				if (bookExist != null) { // book existed
					Book bookToUpdate = bookExist; // new book();
					System.out.println("What to Update");
					System.out.println("1. Book name\n2.Author name\n3.Book price");
					System.out.println("Enter Digit respective to desired option: ");
					byte updateChoice = myInput.nextByte();
					myInput.nextLine();
					switch (updateChoice) {
					case 1:
						System.out.println("Enter Book name to update: ");
						bookToUpdate.setBookName(myInput.nextLine());
						break;
					case 2:
						System.out.println("Enter Book author to update: ");
						bookToUpdate.setBookAuthor(myInput.nextLine());
						break;
					case 3:
						System.out.println("Enter Book price to Update:");
						double newBookPrice = myInput.nextDouble();
						myInput.nextLine();
						bookToUpdate.setBookPrice(newBookPrice);
						break;
					default:
						System.out.println("-----INVALID SELECTION-----");
						break;
					}

					if (controller.update(bookExist, bookToUpdate)) {
						System.out.println("Updated");
					} else {
						System.out.println("Not Updated");
					}
				} else {
					System.out.println("");
				}
				break;
			case 4:
				System.out.println("Enter book name you are looking for....");
				Book fetchedBook = controller.getBook(myInput.nextLine());
				if (fetchedBook != null) {
					System.out.println("Book is available");
					System.out.println("Details");
					System.out.println(fetchedBook);
				} else {
					System.out.println("Book is not available");
				}
				break;

			default:
				System.out.println("Invalid Selection");
				break;
			}
		} while (true);
	}

}
