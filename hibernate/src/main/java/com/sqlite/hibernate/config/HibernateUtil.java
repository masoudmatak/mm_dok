package com.sqlite.hibernate.config;

import com.sqlite.hibernate.dao.DocDao;
import com.sqlite.hibernate.dao.DocDaoImpl;
import com.sqlite.hibernate.dao.SiswaDao;
import com.sqlite.hibernate.dao.SiswaDaoImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static  SessionFactory SESSION_FACTORY;

    private static final SiswaDao SISWA_DAO;
    private static  DocDao DOC_DAO;

    static {
        try {
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

            SISWA_DAO = new SiswaDaoImpl(SESSION_FACTORY);
            DOC_DAO = new DocDaoImpl(SESSION_FACTORY);


        } catch (Throwable e) {
            System.out.println("Hibernate util error " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }


    public static SiswaDao getSiswaDao() {
        return SISWA_DAO;
    }
    
    public static DocDao getDocDao() {
    	 
    	return DOC_DAO;
    }
    
}
