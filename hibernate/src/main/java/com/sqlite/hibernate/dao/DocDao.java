package com.sqlite.hibernate.dao;

import com.sqlite.hibernate.entity.DocEntity;

import java.util.List;

public interface DocDao {
	public void save(DocEntity data);

	public void update(DocEntity data);

	public void delete(DocEntity data);

	public DocEntity findById(String id);

	public List<DocEntity> findAll();

	
}
