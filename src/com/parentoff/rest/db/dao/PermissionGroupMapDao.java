package com.parentoff.rest.db.dao;

import com.parentoff.rest.db.MyBatisDAO;
import com.parentoff.rest.permission.model.PermissionGroup;
import com.parentoff.rest.permission.model.PermissionGroupMap;

public class PermissionGroupMapDao extends MyBatisDAO<PermissionGroupMap, String> {

	public PermissionGroupMapDao(Class<PermissionGroupMap> type) {
		super(type);
	}

}
