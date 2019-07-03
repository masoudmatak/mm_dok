package com.sqlite.hibernate.dao;

import com.sqlite.hibernate.entity.SiswaEntity;

import java.util.List;


public interface SiswaDao {
    public void save(SiswaEntity data);
    public void update(SiswaEntity data);
    public void delete(SiswaEntity data);
    public SiswaEntity findById(String id);
    public List<SiswaEntity> findAll();


}
