package com.dok.insert;

import java.util.List;

import dbutil.dbutil.DBAPI;
import dbutil.dbutil.model.MetaData;
import dbutil.dbutil.model.Doc;

public class ReadMetaData {

	public List<MetaData> getMetadata() {
		return DBAPI.getMetadata();
	}

	public List<MetaData> getMetadata2(String user_string) {
		return DBAPI.getDocments(user_string);
	}
	
	public List<Doc> getDocdata() {
		return DBAPI.getDocdata();
	}
}
