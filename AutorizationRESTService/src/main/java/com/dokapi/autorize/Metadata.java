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

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Metadata")
public class Metadata {
    private String url;
    private String description;
    private String personnummer;
    private String name ;
    private String filename;
    private String document_class;
    private String source_systemid;
    private String skadenummer;
    private String policy_number;
    private String varumarke;
    private String department;
    private String customerid;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getDocument_class() {
		return document_class;
	}

	public void setDocument_class(String document_class) {
		this.document_class = document_class;
	}

	public String getSource_systemid() {
		return source_systemid;
	}

	public void setSource_systemid(String source_systemid) {
		this.source_systemid = source_systemid;
	}

	public String getSkadenummer() {
		return skadenummer;
	}

	public void setSkadenummer(String skadenummer) {
		this.skadenummer = skadenummer;
	}

	public String getPolicy_number() {
		return policy_number;
	}

	public void setPolicy_number(String policy_number) {
		this.policy_number = policy_number;
	}

	public String getVarumarke() {
		return varumarke;
	}

	public void setVarumarke(String varumarke) {
		this.varumarke = varumarke;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getPersonnummer() {
		return personnummer;
	}

	public void setPersonnummer(String personnummer) {
		this.personnummer = personnummer;
	}

	public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}