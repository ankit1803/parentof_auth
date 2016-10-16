package com.parentoff.rest.db.dao;

import com.parentoff.rest.db.MyBatisDAO;
import com.parentoff.rest.user.model.Group;
import com.parentoff.rest.user.model.User;

public class GroupDao extends MyBatisDAO<Group, String> {

	public GroupDao(Class<Group> type) {
		super(type);
	}

}
