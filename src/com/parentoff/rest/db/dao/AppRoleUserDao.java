package com.parentoff.rest.db.dao;

import com.parentoff.rest.application.model.AppRoleUser;
import com.parentoff.rest.application.model.Application;
import com.parentoff.rest.db.MyBatisDAO;

public class AppRoleUserDao extends MyBatisDAO<AppRoleUser, String> {

	public AppRoleUserDao(Class<AppRoleUser> type) {
		super(type);
	}

}
