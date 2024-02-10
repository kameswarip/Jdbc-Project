package com.anp.main;

import java.time.LocalDate;
import java.util.Scanner;

import com.anp.daoimpl.LibraryDaoImpl;
import com.anp.entities.Library;


public class Main {

	public static void main(String args []) {
		
		LibraryDaoImpl dao = new LibraryDaoImpl();
		Scanner sc = new Scanner(System.in);
		
		dao.create();
		
		int choice;
		do {
			System.out.println("Library Management :");
			
			System.out.println("1.Add Book :");
			System.out.println("2.Display all Book:");
			System.out.println("3.Display Book Details:");
			System.out.println("4.Update Book Details :");
			System.out.println("5.Delete a Book :");
			System.out.println("6.Exit :");
			System.out.println("Enter your choice :");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice ) {
			case 1: 
				addBook(sc,dao);
				break;
				
			case 2 :
				dao.display();
				break;
				
			case 3:
				displaybook(sc,dao);
				break;
				
			case 4:
				UpdateBook(sc,dao);
				break;
				
			case 5:
				deleteBook(sc,dao);
				break;
				
			case 6:
				System.out.println("Exiting..");
				break;
				
			default:
				System.out.println("Invalid choice please try again..");
				break;
				
			}
				
		}while (choice != 6);
		
				sc.close();
	}
				
	public  static void addBook(Scanner sc, LibraryDaoImpl dao) {
		
		System.out.println("Enter BookID :");
		int Book_ID = sc.nextInt();
	//	sc.nextInt();
		
		sc.nextLine();

		System.out.println("Enter BookName :");
		String Book_Name = sc.nextLine();
	//	sc.nextLine();
		
		System.out.println("Enter AssuredDate(YYYY-MM-DD) :");
		String Assured_DateStr = sc.nextLine();
		LocalDate Assured_Date = LocalDate.parse(Assured_DateStr);
		
		System.out.println("Enter RenewalDate(YYYY-MM-DD) :");
		String Renewal_DateStr = sc.nextLine();
		LocalDate Renewal_Date = LocalDate.parse(Renewal_DateStr);
		
		System.out.println("Enter ReturnDate(YYYY-MM-DD :");
		String Return_DateStr = sc.nextLine();
		LocalDate Return_Date = LocalDate.parse(Return_DateStr);
		
		Library book = new Library(Book_ID , Book_Name,Assured_Date,Renewal_Date,Return_Date);
				dao.addBook(book);
		
		
	}
	
		private static void displaybook(Scanner sc, LibraryDaoImpl dao) {
			System.out.print("Enter bookID :");
			int Book_ID = sc.nextInt();
			sc.nextLine ();
			dao.displaybook(Book_ID,null);
			
		}
		
		private static void UpdateBook(Scanner sc,LibraryDaoImpl dao) {
			System.out.print("Enter bookID :");
			int Book_ID = sc.nextInt();
			sc.nextLine ();
			
			System.out.print("Enter new book :");
			String newBookName = sc.nextLine();
			dao.update(new Library( Book_ID,newBookName,null,null,null),Book_ID,newBookName);
			
		}
		
		private static void deleteBook(Scanner sc,LibraryDaoImpl dao) {
			System.out.print("Enter bookID :");
			int Book_ID = sc.nextInt();
			sc.nextLine ();
			dao.deletebook(new Library( Book_ID,null,null,null,null),Book_ID);
			
		}		
	
}
