package com.sqlite.hibernate.dao;

import com.sqlite.hibernate.config.HibernateUtil;
import com.sqlite.hibernate.entity.SiswaEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agus Suhardi on 4/16/2017.
 */
public class TestCOba {

    SiswaDao dao = HibernateUtil.getSiswaDao();

    @Test
    public  void coba(){
        List<SiswaEntity> list = dao.findAll();


        List<String> listData = new ArrayList<>();


        for (int i = 0; i < list.size(); i++) {

                listData.add(0, list.get(i).getNis());
                listData.add(1, list.get(i).getNama());
                listData.add(2, String.valueOf(list.get(i).getNilai()));
                listData.add(3, String.valueOf(list.get(i).getKelas()));
                listData.add(4, list.get(i).getGuru());
        }

        System.out.println(listData.get(0));
        System.out.println(listData.get(1));
    }
}
