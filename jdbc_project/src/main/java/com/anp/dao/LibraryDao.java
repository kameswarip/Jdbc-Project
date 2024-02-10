package com.anp.dao;

import com.anp.entities.Library;

public interface LibraryDao {

	void create();
	void addBook(Library library);
	void display();
	void displaybook(int Book_ID,String Book_Name);
	void update(Library library,int Book_ID,String Book_Name);
	void bookDetails(int Book_ID);
	void deletebook(Library library,int Book_ID);
	
}
