/*
Owner and programmer: Masoud Mohammadi 2019
Copywrite is limited and it is only the owner of the program code
can allow the use of it in a system if legal overcoming occurs. 
All rights are reserved for the owner of the code.
This is part of a system design and implementation of this 
Document Management System is based on a particular application area. 
This implementation is based on observation of the use in certain industries. 
In the case of copyright infringement, the owner is entitled to legal 
action and will require legal action through court.
*/


package org.primefaces.showcase.domain;

import java.io.Serializable;

public class Book implements Serializable {
    
    private String title;
	private String author;
	private String publisher;
	private Integer pages;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public boolean equals(Object obj) {
		if(!(obj instanceof Book))
			return false;
		
		Book book = (Book) obj;
		
		return (book.getTitle() != null && book.getTitle().equals(title)) && (book.getAuthor() != null && book.getAuthor().equals(author));
	}

	public int hashCode() {
		int hash = 1;
		if(title != null)
			hash = hash * 31 + title.hashCode();
		
		if(author != null)
			hash = hash * 29 + author.hashCode();

		return hash;
	}
}
