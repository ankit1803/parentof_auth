package com.parentoff.rest.db.dao;

import com.parentoff.rest.application.model.AppRoleUser;
import com.parentoff.rest.db.MyBatisDAO;
import com.parentoff.rest.permission.model.Permission;

public class PermissionDao extends MyBatisDAO<Permission, String> {

	public PermissionDao(Class<Permission> type) {
		super(type);
	}

}
