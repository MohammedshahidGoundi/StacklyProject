package com.library;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {
	ArrayList<Book> books = new ArrayList<>();

	HashMap<String, ArrayList<IssuedBook>> issuedBooks = new HashMap<>();

	HashMap<String, String> students = new HashMap<>();
	
	public boolean checkBookId(int id) {

	    for (Book b : books) {

	        if (b.getBookId() == id) {
	            return true;
	        }
	    }

	    return false;
	}
	
	// Add Book
	
	public void addBook(Book b) {

	    if (checkBookId(b.getBookId())) {

	        System.out.println("Book ID already exists.");
	        return;
	    }

	    books.add(b);

	    System.out.println("Book Added Successfully.");
	}
	
	// Search Book
	
	public void searchBook(String title) {

	    for (Book b : books) {

	        if (b.getTitle().equalsIgnoreCase(title)) {

	            System.out.println("\nBook Found");
	            System.out.println("Book ID : " + b.getBookId());
	            System.out.println("Title : " + b.getTitle());
	            System.out.println("Author : " + b.getAuthor());

	            if (b.isIssued())
	                System.out.println("Status : Issued");
	            else
	                System.out.println("Status : Available");

	            return;
	        }
	    }

	    System.out.println("Book Not Found.");
	}
	
	// Issue Book
	
	public void issueBook(String usn, String name, String title) {

	    ArrayList<IssuedBook> list;

	    if (issuedBooks.containsKey(usn)) {

	        list = issuedBooks.get(usn);

	        if (list.size() == 3) {

	            System.out.println("Student cannot issue more than 3 books.");
	            return;
	        }

	    } else {

	        list = new ArrayList<>();
	    }

	    for (Book b : books) {

	        if (b.getTitle().equalsIgnoreCase(title)) {

	            if (b.isIssued()) {

	                System.out.println("Book Already Issued.");
	                return;
	            }

	            b.setIssued(true);

	            LocalDate date = LocalDate.now();

	            IssuedBook ib = new IssuedBook(b, date);

	            list.add(ib);

	            issuedBooks.put(usn, list);

	            students.put(usn, name);

	            System.out.println("\nBook Issued Successfully");
	            System.out.println("Student : " + name);
	            System.out.println("USN : " + usn);
	            System.out.println("Book : " + b.getTitle());
	            System.out.println("Issue Date : " + date);

	            return;
	        }
	    }

	    System.out.println("Book Not Found.");
	}
	
	// Return Book
	
	public void returnBook(String usn, String title) {

	    if (!issuedBooks.containsKey(usn)) {

	        System.out.println("No books issued for this USN.");
	        return;
	    }

	    ArrayList<IssuedBook> list = issuedBooks.get(usn);

	    IssuedBook ib = null;

	    for (IssuedBook i : list) {

	        if (i.getBook().getTitle().equalsIgnoreCase(title)) {

	            ib = i;
	            break;
	        }
	    }

	    if (ib == null) {

	        System.out.println("Book not issued by this student.");
	        return;
	    }

	    LocalDate issueDate = ib.getIssueDate();

	    LocalDate returnDate = LocalDate.now();

	    System.out.println("\nIssue Date : " + issueDate);
	    System.out.println("Return Date : " + returnDate);

	    long days = ChronoUnit.DAYS.between(issueDate, returnDate);

	    if (days > 7) {

	        long fine = (days - 7) * 10;

	        System.out.println("Fine : ₹" + fine);

	    } else {

	        System.out.println("No Fine");
	    }

	    ib.getBook().setIssued(false);

	    list.remove(ib);

	    if (list.isEmpty()) {

	        issuedBooks.remove(usn);
	        students.remove(usn);
	    }

	    System.out.println("Book Returned Successfully.");
	}
	
	// Display Issued Books
	
	public void displayIssuedBooks() {

	    if (issuedBooks.isEmpty()) {

	        System.out.println("No books are issued.");
	        return;
	    }

	    System.out.println("\n====== ISSUED BOOKS ======");

	    for (String usn : issuedBooks.keySet()) {

	        System.out.println("USN : " + usn);
	        System.out.println("Student : " + students.get(usn));

	        ArrayList<IssuedBook> list = issuedBooks.get(usn);

	        for (IssuedBook ib : list) {

	            System.out.println("Book ID : " + ib.getBook().getBookId());
	            System.out.println("Title : " + ib.getBook().getTitle());
	            System.out.println("Author : " + ib.getBook().getAuthor());
	            System.out.println("Issue Date : " + ib.getIssueDate());

	            System.out.println("----------------------");
	        }

	        System.out.println("======================");
	    }
	}
}

