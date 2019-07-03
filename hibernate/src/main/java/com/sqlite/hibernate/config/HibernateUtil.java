package com.sqlite.hibernate.config;

import com.sqlite.hibernate.dao.SiswaDao;
import com.sqlite.hibernate.dao.SiswaDaoImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Agus Suhardi on 4/16/2017.
 */
public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;

    private static final SiswaDao SISWA_DAO;


    static {
        try {
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

            SISWA_DAO = new SiswaDaoImpl(SESSION_FACTORY);


        } catch (Throwable e) {
            System.out.println("Hibernate util error " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }


    public static SiswaDao getSiswaDao() {
        return SISWA_DAO;
    }
}
