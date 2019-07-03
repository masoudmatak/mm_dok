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
package com.controll.access;



public class AccessMgmt {

	
	private String doc_yta;
	private String dok_type;
	private String userId;
	
	
	public void getDocYta() {
		
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDoc_yta() {
		return doc_yta;
	}

	public void setDoc_yta(String doc_yta) {
		this.doc_yta = doc_yta;
	}

	public String getDok_type() {
		return dok_type;
	}

	public void setDok_type(String dok_type) {
		this.dok_type = dok_type;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println("access");
	}

	
	
}
