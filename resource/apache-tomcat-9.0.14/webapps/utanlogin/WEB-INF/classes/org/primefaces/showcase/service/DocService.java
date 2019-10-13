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

package org.primefaces.showcase.service;

import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dbutil.dbutil.model.Doc;
import com.dok.insert.ReadMetaData;

import dbutil.dbutil.model.MetaData;

@ManagedBean(name = "docService")
@ApplicationScoped
public class DocService {

	private final static String[] colors;

	private final static String[] doktypes;

	private String personnummer;
	private String skadenummer;

	public List<Doc> listan;

	public List<Doc> getListan() {
		return listan;
	}

	public void setListan(List<Doc> listan) {
		this.listan = listan;
	}

	public String getSkadenummer() {
		return skadenummer;
	}

	public void setSkadenummer(String skadenummer) {
		this.skadenummer = skadenummer;
	}

	public String getPersonnummer() {
		return personnummer;
	}

	public void setPersonnummer(String personnummer) {
		this.personnummer = personnummer;
	}

	static {
		colors = new String[10];
		colors[0] = "Black";
		colors[1] = "White";
		colors[2] = "Green";
		colors[3] = "Red";
		colors[4] = "Blue";
		colors[5] = "Orange";
		colors[6] = "Silver";
		colors[7] = "Yellow";
		colors[8] = "Brown";
		colors[9] = "Maroon";

		doktypes = new String[11];
		doktypes[0] = "CLAIM";
		doktypes[1] = "CORRESPODENT";
		doktypes[2] = "FAKTURA";
		doktypes[3] = "FORSAKRING";
		doktypes[4] = "HANDLING";
		doktypes[5] = "INDIVIDUELL";
		doktypes[6] = "KOLLEKTIV";
		doktypes[7] = "POLICY";
		doktypes[8] = "POLISANMALAN";
		doktypes[9] = "SKADEANMALAN";
		doktypes[10] = "SPARANDE";

	}

	public List<Doc> createDocs(int size) {
		ReadMetaData testmetadata = new ReadMetaData();
		listan = testmetadata.getDocdata();
		if (listan != null) {
			System.out.println("size of metadata is: " + listan.size());
		}
		return listan;
	}

	public void searchDocs() {
		// System.out.println("personumret, skadenummer ::: " + personnummer+",
		// "+skadenummer);
		ReadMetaData testmetadata = new ReadMetaData();

		listan = testmetadata.searchDocs(personnummer, skadenummer);
		if (listan.size() > 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("searched Personnummer:    " + personnummer));
		}
		personnummer = null;
		skadenummer = null;
		// System.out.println("size of search is: " + listan.size());
		// return listan;
	}

	public List<String> getColors() {
		return Arrays.asList(colors);
	}

	public List<String> getDoktypes() {
		return Arrays.asList(doktypes);
	}
}
