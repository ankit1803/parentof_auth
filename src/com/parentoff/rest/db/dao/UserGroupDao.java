package com.parentoff.rest.db.dao;

import com.parentoff.rest.db.MyBatisDAO;
import com.parentoff.rest.user.model.Group;
import com.parentoff.rest.user.model.UserGroup;

public class UserGroupDao extends MyBatisDAO<UserGroup, String> {

	public UserGroupDao(Class<UserGroup> type) {
		super(type);
	}

}
