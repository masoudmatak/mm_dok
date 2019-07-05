package com.sqlite.hibernate;

import com.sqlite.hibernate.config.HibernateUtil;
import com.sqlite.hibernate.dao.DocDao;
import com.sqlite.hibernate.dao.SiswaDao;
import com.sqlite.hibernate.entity.DocEntity;
import com.sqlite.hibernate.entity.SiswaEntity;

public class MasoudDoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MasoudDoc masoud2 = new MasoudDoc();
		//masoud2.testaLite();
		
		MasoudDoc.insertIntoDB("NNNN-6651HHAFFA-77GDA-GGA12","HHAGAFAAF", "/home/gggga.pdf" , "PENSION", "Q889",
				"196904112819", "SKADE-556171", "1800", "PLIKTSAM", "PENSION",
				"CUS-16661-FF", "TEST", "2023-05-01", "AMANDANIA",2018);
				
	}

	public void testaLite() {
		DocDao dao = HibernateUtil.getDocDao();

		DocEntity s = new DocEntity("GAHHJJA%61FFA4413MMAdd1", "SPARANDE", 2019, "BLUE");
		dao.save(s);
		
		
	
		
		DocEntity svar = dao.findById("ABBAFARDSA6165DRSWA12TD123");
		if (svar != null)
			System.out.println("svaret : " + svar.getDoktype());
		
		
		
		System.exit(0);
	}

	public static void insertIntoDB(String id,String dokName, String fileName, String document_class, String source_systemid,
			String personnummer, String skadenummer, String policy_number, String varumarke, String department,
			String customerid, String yta, String gallringdagar, String sourcesystem_name, int which_year) {
		DocDao dao = HibernateUtil.getDocDao();
		DocEntity s = new DocEntity(id,dokName, fileName, document_class, source_systemid, personnummer, skadenummer,
				policy_number, varumarke, department, customerid, yta, gallringdagar, sourcesystem_name, which_year);
		
		dao.save(s);
		System.exit(0);
	}

}
