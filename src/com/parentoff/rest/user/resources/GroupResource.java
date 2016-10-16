package com.parentoff.rest.user.resources;

import com.parentoff.rest.common.GenericResponse;
import com.parentoff.rest.db.ParentDAO;
import com.parentoff.rest.db.dao.GroupDao;
import com.parentoff.rest.db.dao.UserDao;
import com.parentoff.rest.user.model.Group;
import com.parentoff.rest.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/group")
public class GroupResource {

	public static ParentDAO<Group, String> dao = new GroupDao(
			Group.class);
	public static Logger LOGGER = LoggerFactory
			.getLogger(GroupResource.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Group> getAllGroups() {
		LOGGER.info("Entering getAllGroups..");
		List<Group> groups = null;
		try {
			groups = dao.getAll();
			LOGGER.info("Exiting getAllGroups.." + groups);
		} catch (Exception e) {
			LOGGER.error("Exception occured in getAllGroups ", e);
		}

		return groups;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public GenericResponse addGroup(Group group) {
		LOGGER.info("adding new group");
		GenericResponse genericResponse = new GenericResponse();
		try {
			LOGGER.info(group.toString());
			dao.insert(group);
			genericResponse.setResponseCode(200);
			genericResponse.setResponseDesc("success");

		}catch (Exception e){
			e.printStackTrace();
			genericResponse.setResponseCode(-1);
			genericResponse.setResponseDesc(e.getMessage());
		}

		return genericResponse;
	}

	@DELETE
	@Path("{group_name}")
	@Produces(MediaType.APPLICATION_JSON)
	public GenericResponse deleteGroup(@PathParam("group_name") String group_name) {
		LOGGER.info("deleting group name");
		GenericResponse genericResponse = new GenericResponse();
		try {
			LOGGER.info("deleting " + group_name);
			dao.delete(group_name);
			genericResponse.setResponseCode(200);
			genericResponse.setResponseDesc("success");

		}catch (Exception e){
			e.printStackTrace();
			genericResponse.setResponseCode(-1);
			genericResponse.setResponseDesc(e.getMessage());
		}

		return genericResponse;
	}

}
