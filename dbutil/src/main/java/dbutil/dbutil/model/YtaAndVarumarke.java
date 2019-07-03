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

public class YtaAndVarumarke {

	
	private String yta;
	private String ad_id;
	private String varumarke;
	private String textBeskrivning;
	
	public String getTextBeskrivning() {
		return textBeskrivning;
	}

	public void setTextBeskrivning(String textBeskrivning) {
		this.textBeskrivning = textBeskrivning;
	}

	public String getYta() {
		return yta;
	}

	public void setYta(String yta) {
		this.yta = yta;
	}

	

	public String getAd_id() {
		return ad_id;
	}

	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}

	public String getVarumarke() {
		return varumarke;
	}

	public void setVarumarke(String varumarke) {
		this.varumarke = varumarke;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
