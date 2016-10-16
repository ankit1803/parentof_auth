package com.parentoff.rest.db.dao;

import com.parentoff.rest.application.model.Application;
import com.parentoff.rest.db.MyBatisDAO;

public class ApplicationDao extends MyBatisDAO<Application, String> {

	public ApplicationDao(Class<Application> type) {
		super(type);
	}

}
