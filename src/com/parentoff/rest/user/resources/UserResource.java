package com.parentoff.rest.user.resources;

import com.parentoff.rest.common.GenericResponse;
import com.parentoff.rest.db.ParentDAO;
import com.parentoff.rest.db.dao.UserDao;
import com.parentoff.rest.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
public class UserResource {

	public static ParentDAO<User, String> dao = new UserDao(
			User.class);
	public static Logger LOGGER = LoggerFactory
			.getLogger(UserResource.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		LOGGER.info("Entering getAllUsers..");
		List<User> users = null;
		try {
			users = dao.getAll();
			LOGGER.info("Exiting getAllUsers.." + users);
		} catch (Exception e) {
			LOGGER.error("Exception occured in getAllUsers ", e);
		}

		return users;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public GenericResponse addUser(User user) {
		LOGGER.info("adding new user");
		GenericResponse genericResponse = new GenericResponse();
		try {
			LOGGER.info(user.toString());
			dao.insert(user);
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
	@Path("{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public GenericResponse deleteUser(@PathParam("username") String username) {
		LOGGER.info("adding new user");
		GenericResponse genericResponse = new GenericResponse();
		try {
			LOGGER.info("deleting " + username);
			dao.delete(username);
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
