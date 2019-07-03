package com.sqlite.hibernate;

import com.sqlite.hibernate.config.HibernateUtil;
import com.sqlite.hibernate.dao.SiswaDao;
import com.sqlite.hibernate.entity.SiswaEntity;

public class Masoud {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Masoud masoud=new Masoud();
		 masoud.testaLite();
	}

	
	 public void testaLite(){
		 SiswaDao dao = HibernateUtil.getSiswaDao();
	        SiswaEntity s = new SiswaEntity("S011", "Gabriella hansson", 34, 19, "SWE");
	        dao.save(s);
	        SiswaEntity svar= dao.findById("S010");
	        if(svar !=null)
	       System.out.println("svaret : "+ svar.getNama());
	    }

	 
}
