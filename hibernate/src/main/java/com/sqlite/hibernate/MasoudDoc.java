package com.sqlite.hibernate;

import com.sqlite.hibernate.config.HibernateUtil;
import com.sqlite.hibernate.dao.DocDao;
import com.sqlite.hibernate.dao.SiswaDao;
import com.sqlite.hibernate.entity.DocEntity;
import com.sqlite.hibernate.entity.SiswaEntity;

public class MasoudDoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 MasoudDoc masoud2=new MasoudDoc();
		 masoud2.testaLite();
	}

	
	 public void testaLite(){
		 DocDao dao = HibernateUtil.getDocDao();
		 
	        DocEntity s = new DocEntity("GADDAFA3141165DRSWA12GHA41", "FAKTURA", 2019,  "BLUE");
	        dao.save(s);
	        DocEntity svar= dao.findById("ABBAFARDSA6165DRSWA12TD123");
	        if(svar !=null)
	       System.out.println("svaret : "+ svar.getDoktype());
	    }

	 
}
