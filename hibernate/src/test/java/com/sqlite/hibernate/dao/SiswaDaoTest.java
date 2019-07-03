package com.sqlite.hibernate.dao;

import com.sqlite.hibernate.config.HibernateUtil;
import com.sqlite.hibernate.dao.SiswaDao;
import com.sqlite.hibernate.entity.SiswaEntity;
import org.junit.Test;


public class SiswaDaoTest {

    SiswaDao dao = HibernateUtil.getSiswaDao();

    @Test
    public void saveTest(){
        SiswaEntity s = new SiswaEntity("S001", "suhardi", 80, 3, "erna");
        dao.save(s);
    }


}
