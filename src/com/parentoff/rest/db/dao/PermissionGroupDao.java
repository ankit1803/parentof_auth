package com.parentoff.rest.db.dao;

import com.parentoff.rest.db.MyBatisDAO;
import com.parentoff.rest.permission.model.Permission;
import com.parentoff.rest.permission.model.PermissionGroup;

public class PermissionGroupDao extends MyBatisDAO<PermissionGroup, String> {

	public PermissionGroupDao(Class<PermissionGroup> type) {
		super(type);
	}

}
