package com.anp.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.anp.dao.LibraryDao;
import com.anp.entities.Library;

@SuppressWarnings("serial")
class BookAlreadyExistsException extends Exception {
    public static void BookAlreadyExistsExceptions() {
        System.out.println("Welcome to the library");
    }
}

public class LibraryDaoImpl implements LibraryDao {
		 String jdbcurl = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
		 String username = "root";
	     String password = "Admin123";
	     
	     public void create() {
	    	 String sql = "Create table if not exists Books ("
	    			 +"Book_ID int primary key,"
	    			 +"Book_Name varchar(255),"
	    			 +"Assured_Date date,"
	    			 +"Renewal_Date date,"
	    			 + "Return_Date date)";
	    	 
	    	 try {
	    		 Connection con = DriverManager.getConnection(jdbcurl,username ,password);
	    		 PreparedStatement pts = con.prepareStatement(sql);
	    		 pts.execute();
	    		 System.out.println("Table is created successfully");
	    		 System.out.println();
	    		 
	    	 }catch(Exception e) {
	    		// BookAlreadyExistsException.BookAlreadyExistsExceptions();
	    		 e.printStackTrace();
	    	 }
	    	 
	     }

	     @Override
	     public void addBook(Library library) {
	    	 String insertQuery = "insert into Books(Book_ID,Book_Name,Assured_Date,Renewal_Date,Return_Date) values(?,?,?,?,?)";
	    	 
	    	 try {
	    		 Connection con = DriverManager.getConnection(jdbcurl,username,password);
	    		 PreparedStatement pts = con.prepareStatement(insertQuery);
	    		 pts.setInt(1,library.getBook_ID());
	    		 pts.setString(2,library.getBook_Name());
	    		 pts.setDate(3,java.sql.Date.valueOf(library.getAssured_Date()));
	    		 pts.setDate(4,java.sql.Date.valueOf(library.getRenewal_Date()));
	    		 pts.setDate(5,java.sql.Date.valueOf(library.getReturn_Date()));
	    		 
	    		 pts.executeUpdate();
	    		 System.out.println("Book is inserted successfully");
	    		 
	    	 }catch(Exception e) {
	    		 BookAlreadyExistsException.BookAlreadyExistsExceptions();
	    		//e.printStackTrace();
	    	 }
	     }
	     
	     public void display() {
	    	 String displayQuery = "select * from Books";
	    	 try {
	    			Connection con = DriverManager.getConnection(jdbcurl,username,password);
	    		 PreparedStatement pts = con.prepareStatement(displayQuery);
	    		 ResultSet rs = pts.executeQuery();
	    		 
	    		 System.out.println("Book in the library");
	    		 while (rs.next()) {
	    			 int Book_ID = rs.getInt("Book_ID");
	    			 String Book_Name = rs.getString("Book_Name");
	    			 java.sql.Date Assured_Date = rs.getDate("Assured_Date");
	    			 java.sql.Date Renewal_Date = rs.getDate("Renewal_Date");
	    			 java.sql.Date Return_Date = rs.getDate("Return_Date");
	    			 
	    			 System.out.println("BookID :" + Book_ID);
	    			 System.out.println("BookName :" + Book_Name);
	    			 System.out.println("AssuredDate :" + Assured_Date);
	    			 System.out.println(" Renewal_Date:" + Renewal_Date);
	    			 System.out.println("ReturnDate :" + Return_Date);
	    			 System.out.println();
	    			 
	    		 }
	    		 }catch(Exception e) {
	    			 e.printStackTrace();
	    			 
	    		 }
	     
	     }
	    	
	     public void displaybook(int Book_ID,String Book_Name) {
	    	 String displayQuery = "select * from Books WHERE Book_ID = ?";
	    	 try (
	    		 Connection con = DriverManager.getConnection(jdbcurl,username,password);
	    		 PreparedStatement pts = con.prepareStatement(displayQuery)){
	    		 pts.setInt(1,Book_ID);
	    		 ResultSet rs = pts.executeQuery();
	    		 
	    		 if (rs.next()) {
	    			 int Book_ID1 = rs.getInt("Book_ID");
	    			 String Book_Name1 = rs.getString("Book_Name");
	    			 java.sql.Date Assured_Date = rs.getDate("Assured_Date");
	    			 java.sql.Date Renewal_Date = rs.getDate("Renewal_Date");
	    			 java.sql.Date Return_Date = rs.getDate("Return_Date");
	    			 
	    			 System.out.println("BookID :" + Book_ID1);
	    			 System.out.println("BookName :" + Book_Name1);
	    			 System.out.println("AssuredDate :" + Assured_Date);
	    			 System.out.println(" Renewal_Date:" + Renewal_Date);
	    			 System.out.println("ReturnDate :" + Return_Date);
	    			 System.out.println();
	    			 
	    		 
	    		 }else  {
	    			System.out.println("Book not found ..") ;
	    		 }
	    	 }
	    	 catch(Exception e) {
	    		 e.printStackTrace();
	    	 }
	     }
	     @Override
	     public void update(Library library,int Book_ID,String Book_Name) {
	    	String updateQuery = "update Books SET Book_Name = ? Where Book_ID = ?";
	    	
	    	try(Connection con = DriverManager.getConnection(jdbcurl,username,password);
	    			PreparedStatement pts = con.prepareStatement(updateQuery)){
	    		
	    		pts.setString(1,Book_Name);
	    		pts.setInt(2,Book_ID);
	    		
	    		pts.executeUpdate();
	    		
	    		System.out.println("Book is updated successfully");
	    	}catch(SQLException e) {
	    		
	    		System.out.println("Failed to update the book details :" + e.getMessage());
	    		e.printStackTrace();
	    	}
	     }
	     
	    	 
	     public void displaybook(int Book_ID ) {
	    	  // public void bookDetails(int Book_ID ) {

	    	 String selectQuery = "select * from Books WHERE Book_ID = ?";
	    	 try (
	    		 Connection con = DriverManager.getConnection(jdbcurl,username,password);
	    		 PreparedStatement pts = con.prepareStatement(selectQuery)){
	    		 pts.setInt(1,Book_ID);
	    		 ResultSet rs = pts.executeQuery();
	    		 
	    		 if (rs.next()) {
	    			 int Book_ID1 = rs.getInt("Book_ID");
	    			 String Book_Name = rs.getString("Book_Name");
	    			 java.sql.Date Assured_Date = rs.getDate("Assured_Date");
	    			 java.sql.Date Renewal_Date = rs.getDate("Renewal_Date");
	    			 java.sql.Date Return_Date = rs.getDate("Return_Date");
	    			 
	    			 System.out.println("BookID :" + Book_ID1);
	    			 System.out.println("BookName :" + Book_Name);
	    			 System.out.println("AssuredDate :" + Assured_Date);
	    			 System.out.println(" Renewal_Date:" + Renewal_Date);
	    			 System.out.println("ReturnDate :" + Return_Date);
	    			 System.out.println();
	    			 
	    		 
	    		 }else  {
	    			System.out.println("Book not found ..") ;
	    		 }
	    	 }
	    	 catch(Exception e) {
	    		 e.printStackTrace();
	    	 }
	     }
	     @Override
	     public  void deletebook(Library library,int Book_ID) {
	    	 String deleteQuery = "Delete from Books WHERE Book_ID = ?";
	    	 try (
		    		 Connection con = DriverManager.getConnection(jdbcurl,username,password);
		    		 PreparedStatement pts = con.prepareStatement(deleteQuery)){
		    		 pts.setInt(1,Book_ID);
		    		 
		    		 int rowsDeleted = pts.executeUpdate();
		    		 if(rowsDeleted > 0) {
		    			 System.out.println("Book deleted successfully");
		    		 }
		    		 else {
		    			 System.out.println("Failed to delete the book may not exits. ");
		    		 }
		    		 }catch(SQLException e) {
		    			 e.printStackTrace();
		    		 }
	     }

		@Override
		public void bookDetails(int Book_ID) {
			
		}
	    	 
	     }

