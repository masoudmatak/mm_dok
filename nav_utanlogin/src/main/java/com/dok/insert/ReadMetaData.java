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
package com.dok.insert;

import java.util.List;

import dbutil.dbutil.DBAPI;
import dbutil.dbutil.model.MetaData;
import dbutil.dbutil.model.Doc;

public class ReadMetaData {

	public List<Doc> getMetadata() {
		return DBAPI.getMetadata();
	}

	public List<MetaData> getMetadata2(String user_string) {
		return DBAPI.getDocments(user_string);
	}
	
	public List<Doc> getDocdata() {
		return DBAPI.getDocdata();
	}
	
	public List<Doc> searchDocs(String personnummer, String skadenummer) {
		return DBAPI.searchDocs(personnummer, skadenummer);
	}
}
