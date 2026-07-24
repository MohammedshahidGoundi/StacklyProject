package com.library;
import java.time.LocalDate;

public class IssuedBook {

	private Book book;
	private LocalDate issueDate;

	public IssuedBook(Book book, LocalDate issueDate) {

		this.book = book;
		this.issueDate = issueDate;
	}

	public Book getBook() {
		return book;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

}
