package com.sqlite.hibernate.entity;

import java.io.Serializable;

/*
Owner and programmer: Masoud Mohammadi 2019
Copyright is limited and it is only the owner of the program code
can allow the use of it in a system if legal overcoming occurs. 
All rights are reserved for the owner of the code.
This is part of a system design and implementation of this 
Document Management System is based on a particular application area. 
This implementation is based on observation of the use in certain industries. 
In the case of copyright infringement, the owner is entitled to legal 
action and will require legal action through court.
*/


//import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "doc")
public class DocEntity  implements Serializable{ 
	 @Id
	private String id;
	private String doktype;
	private int year;
	private String color;
	private int docsize;
	private boolean sold;
	private String personnummer;
	private String skadenummer;
	private String customerid;
	private String varumarke;
	private String sekundar_varumarke;
	private String bucket_name;
	private String document_class;
	private String source_systemid;
	private String filename;
	
	private Date time_inserted;
	private String generated_filename;
	/*	public Timestamp gallrings_date;
	
	*/

	
	public DocEntity() {
	}

	public DocEntity(String id, String doktype, int year, String color) {
		this.id = id;
		this.doktype = doktype;
		this.year = year;
		this.color = color;
	}

	public DocEntity(String id, String doktype, int year, String color, int docsize, boolean sold) {
		this.id = id;
		this.doktype = doktype;
		this.year = year;
		this.color = color;
		this.docsize = docsize;
		this.sold = sold;
	}
	
	
	public DocEntity(String id,String dokName, String filename, String document_class, String source_systemid,
			String personnummer, String skadenummer, String policy_number, String varumarke, String department,
			String customerid, String yta, String gallringdagar, String sourcesystem_name, int year) {
		this.id = id;
		this.doktype = document_class;
		this.year = year;
		this.color = "Black";
		this.personnummer = personnummer;
		this.skadenummer = skadenummer;
		this.customerid = customerid;
		this.varumarke = varumarke;
		this.bucket_name = document_class;
		this.document_class = document_class;
		this.source_systemid = source_systemid;
		this.filename = filename;
		
		this.generated_filename = dokName;
		
		
	}
	



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getGenerated_filename() {
		return generated_filename;
	}

	public void setGenerated_filename(String generated_filename) {
		this.generated_filename = generated_filename;
	}

	

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getVarumarke() {
		return varumarke;
	}

	public void setVarumarke(String varumarke) {
		this.varumarke = varumarke;
	}

	public String getSekundar_varumarke() {
		return sekundar_varumarke;
	}

	public void setSekundar_varumarke(String sekundar_varumarke) {
		this.sekundar_varumarke = sekundar_varumarke;
	}

	public String getBucket_name() {
		return bucket_name;
	}

	public void setBucket_name(String bucket_name) {
		this.bucket_name = bucket_name;
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
	
	public Date getTime_inserted() {
		return time_inserted;
	}

	public void setTime_inserted(Date time_inserted) {
		this.time_inserted = time_inserted;
	}
	
/*
	public Timestamp getGallrings_date() {
		return gallrings_date;
	}

	public void setGallrings_date(Timestamp gallrings_date) {
		this.gallrings_date = gallrings_date;
	}

	*/

	public String getSkadenummer() {
		return skadenummer;
	}

	public void setSkadenummer(String skadenummer) {
		this.skadenummer = skadenummer;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getDoktype() {
		return doktype;
	}

	public void setDoktype(String doktype) {
		this.doktype = doktype;
	}

	public String getPersonnummer() {
		return personnummer;
	}

	public void setPersonnummer(String personnummer) {
		this.personnummer = personnummer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDocsize() {
		return docsize;
	}

	public void setDocsize(int docsize) {
		this.docsize = docsize;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final DocEntity other = (DocEntity) obj;
		if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
			return false;
		}
		return true;
	}
	
	
	
}
