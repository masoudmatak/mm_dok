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
package dbutil.dbutil.model;

import java.io.Serializable;
import java.sql.Timestamp;



public class MetaData implements Serializable {

	public MetaData() {
	}

	private int id;
	private String dokid;
	

	private String name;
	private String filename;
	private String document_class;
	private String document_type;
	private Timestamp time_inserted;
	private Timestamp updated_time;
	private String source_systemid;
	private String personnummer;
	private String customerid;
	private String skadenummer;
	private String sourcesystem_name;
	private String policy_number;
	private String handledare_name;
	private String department;
	private String varumarke;
	private String sekundar_varumarke;
	private int gallringstyp_nr;
	private Timestamp gallrings_date;
	private String owner_id;
	private String yta;
	private String autorization;

	public String getAutorization() {
		return autorization;
	}

	public void setAutorization(String autorization) {
		this.autorization = autorization;
	}

	public MetaData(int id, String name, String filename, String document_class, String document_type,
			Timestamp time_inserted, Timestamp updated_time, String source_systemid, String personnummer,
			String customerid, String skadenummer, String sourcesystem_name, String policy_number,
			String handledare_name, String department, String varumarke, String sekundar_varumarke, int gallringstyp_nr,
			Timestamp gallrings_date, String owner_id, String yta) {

		this.id = id;
		this.name = name;
		this.filename = filename;
		this.document_class = document_class;
		this.document_type = document_type;
		this.time_inserted = time_inserted;
		this.updated_time = updated_time;
		this.source_systemid = source_systemid;
		this.personnummer = personnummer;
		this.customerid = customerid;
		this.skadenummer = skadenummer;
		this.sourcesystem_name = sourcesystem_name;
		this.policy_number = policy_number;
		this.handledare_name = handledare_name;
		this.department = department;
		this.varumarke = varumarke;
		this.sekundar_varumarke = sekundar_varumarke;
		this.gallringstyp_nr = gallringstyp_nr;
		this.gallrings_date = gallrings_date;
		this.owner_id = owner_id;
		this.yta = yta;
	}

	public MetaData(int id, String name, String filename, String document_class, String document_type,
			Timestamp time_inserted, String personnummer, String customerid, String skadenummer, String policy_number,
			String varumarke, String yta) {

		this.id = id;
		this.name = name;
		this.filename = filename;
		this.document_class = document_class;
		this.document_type = document_type;
		this.time_inserted = time_inserted;
		this.personnummer = personnummer;
		this.customerid = customerid;
		this.skadenummer = skadenummer;
		this.policy_number = policy_number;
		this.varumarke = varumarke;
		this.yta = yta;
	}

	
	
	
	
	public String getDokid() {
		return dokid;
	}

	public void setDokid(String dokid) {
		this.dokid = dokid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public Timestamp getTime_inserted() {
		return time_inserted;
	}

	public void setTime_inserted(Timestamp time_inserted) {
		this.time_inserted = time_inserted;
	}

	public Timestamp getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(Timestamp updated_time) {
		this.updated_time = updated_time;
	}

	public String getSource_systemid() {
		return source_systemid;
	}

	public void setSource_systemid(String source_systemid) {
		this.source_systemid = source_systemid;
	}

	public String getPersonnummer() {
		return personnummer;
	}

	public void setPersonnummer(String personnummer) {
		this.personnummer = personnummer;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getSkadenummer() {
		return skadenummer;
	}

	public void setSkadenummer(String skadenummer) {
		this.skadenummer = skadenummer;
	}

	public String getSourcesystem_name() {
		return sourcesystem_name;
	}

	public void setSourcesystem_name(String sourcesystem_name) {
		this.sourcesystem_name = sourcesystem_name;
	}

	public String getPolicy_number() {
		return policy_number;
	}

	public void setPolicy_number(String policy_number) {
		this.policy_number = policy_number;
	}

	public String getHandledare_name() {
		return handledare_name;
	}

	public void setHandledare_name(String handledare_name) {
		this.handledare_name = handledare_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public int getGallringstyp_nr() {
		return gallringstyp_nr;
	}

	public void setGallringstyp_nr(int gallringstyp_nr) {
		this.gallringstyp_nr = gallringstyp_nr;
	}

	public Timestamp getGallrings_date() {
		return gallrings_date;
	}

	public void setGallrings_date(Timestamp gallrings_date) {
		this.gallrings_date = gallrings_date;
	}

	public String getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}

	public String getYta() {
		return yta;
	}

	public void setYta(String yta) {
		this.yta = yta;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + (this.dokid != null ? this.dokid.hashCode() : 0);
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
		final MetaData other = (MetaData) obj;
		if ((this.dokid == null) ? (other.dokid != null) : !this.dokid.equals(other.dokid)) {
			return false;
		}
		return true;
	}
	
	
	 
	   

}
