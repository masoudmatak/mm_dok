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
package dbutil.dbutil;

import dbutil.dbutil.model.MetaData;

public class AccessController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private String getDocumentSecurityClasss(int docId) {
		String securityClass = "";
		return securityClass;
	}

	private String getAdgroup(String user_string) {
		//tabel mm_user_adgroup
		String adgroup = "";
		return adgroup;
	}
//
	private String getAutorization(String adgroup) {
		String autorization = "";
		return autorization;
	}

	private MetaData setAutorization(MetaData metadata, String autorization) {

		metadata.setAutorization(autorization);
		return metadata;
	}

	private void getAllAdgroup() {
		
	}
}
