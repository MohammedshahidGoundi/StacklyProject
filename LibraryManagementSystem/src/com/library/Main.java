package com.library;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				Scanner sc = new Scanner(System.in);

				Library library = new Library();

				while (true) {

					System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
					System.out.println("1. Add Book");
					System.out.println("2. Search Book");
					System.out.println("3. Issue Book");
					System.out.println("4. Return Book");
					System.out.println("5. Display Issued Books");
					System.out.println("6. Exit");

					System.out.print("Enter your choice : ");
					int ch = sc.nextInt();
					sc.nextLine();

					switch (ch) {

					case 1:

						System.out.print("Enter Book ID : ");
						int id = sc.nextInt();
						sc.nextLine();

						System.out.print("Enter Book Title : ");
						String title = sc.nextLine();

						System.out.print("Enter Author Name : ");
						String author = sc.nextLine();

						Book b = new Book(id, title, author);

						library.addBook(b);

						break;

					case 2:

						System.out.print("Enter Book Title : ");
						String search = sc.nextLine();

						library.searchBook(search);

						break;

					case 3:

						System.out.print("Enter Student USN : ");
						String usn = sc.nextLine();

						System.out.print("Enter Student Name : ");
						String name = sc.nextLine();

						System.out.print("Enter Book Title : ");
						String issueBook = sc.nextLine();

						library.issueBook(usn, name, issueBook);

						break;

					case 4:

						System.out.print("Enter Student USN : ");
						String returnUsn = sc.nextLine();

						System.out.print("Enter Book Title : ");
						String returnBook = sc.nextLine();

						library.returnBook(returnUsn, returnBook);

						break;

					case 5:

						library.displayIssuedBooks();

						break;

					case 6:

						System.out.println("Thank You!");
						sc.close();
						System.exit(0);

					default:

						System.out.println("Invalid Choice.");
					}
				}
			}
 }
