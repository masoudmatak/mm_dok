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
package com.dokapi.autorize;

import java.util.List;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;

import org.xmlpull.v1.XmlPullParserException;

import dbutil.dbutil.DBAPI;
import dbutil.dbutil.model.Doc;
//import io.minio.errors.MinioException;


public class MetadataDao {
	public List<Doc> listMetadata(String personnummer)
			throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException {
		return getFromDB(personnummer);
	}

	private List<Doc> getFromDB(String personnummer) {
		return DBAPI.searchDocs( personnummer, null);
	}

}