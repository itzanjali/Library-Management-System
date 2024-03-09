package com.jsp.Controller;

import java.util.ArrayList;
import java.util.List;

import com.jsp.Model.Book;
import com.jsp.Model.Library;
import com.jsp.View.View;

public class Controller {

	private Library library = View.getLibrary(); // to access library from view

	public void addBook(Book book) {
		List<Book> books = library.getBooks();
		if (book != null) { // list of don't exist
			books = new ArrayList<>();
		}
		books.add(book);
		library.setBooks(books);
	}

	public boolean removeBook(String bookToremove) {
		Book book = getBook(bookToremove);
		if (book != null) {
			List<Book> books = library.getBooks();
			boolean remove = books.remove(books);
			library.setBooks(books);
			return true;
		}
		return false;
	}

	public boolean update(Book bookExist, Book bookToUpdate) {
		List<Book> books = library.getBooks();
		for (Book book : books) {
			if (book.getBookName().equalsIgnoreCase(bookExist.getBookName())) {
				books.remove(bookExist);
				books.add(bookToUpdate);
				library.setBooks(books);
				return true;
			}
		}
		return false;
	}

	public Book getBook(String bookName) {
		List<Book> books = library.getBooks();
		if (books != null) { // list of book exist
			for (Book book : books) { // linear search
				if (book.getBookName().equalsIgnoreCase(bookName)) {
					return book;
				}
			}
		}
		return null;
	}

}
