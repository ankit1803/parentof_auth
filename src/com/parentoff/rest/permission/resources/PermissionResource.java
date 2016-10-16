package com.parentoff.rest.permission.resources;

import com.parentoff.rest.common.GenericResponse;
import com.parentoff.rest.db.ParentDAO;
import com.parentoff.rest.db.dao.PermissionDao;
import com.parentoff.rest.permission.model.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/permission")
public class PermissionResource {

	public static ParentDAO<Permission, String> dao = new PermissionDao(
			Permission.class);
	public static Logger LOGGER = LoggerFactory
			.getLogger(PermissionResource.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Permission> getAllPermissions() {
		LOGGER.info("Entering getAllPermissions..");
		List<Permission> permissions = null;
		try {
			permissions = dao.getAll();
			LOGGER.info("Exiting getAllPermissions.." + permissions);
		} catch (Exception e) {
			LOGGER.error("Exception occured in getAllPermissions ", e);
		}

		return permissions;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public GenericResponse addPermission(Permission permission) {
		LOGGER.info("adding new Permission");
		GenericResponse genericResponse = new GenericResponse();
		try {
			LOGGER.info(permission.toString());
			dao.insert(permission);
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
	@Path("{perm_name}")
	@Produces(MediaType.APPLICATION_JSON)
	public GenericResponse deletePermission(@PathParam("perm_name") String perm_name) {
		LOGGER.info("deleting perm_name");
		GenericResponse genericResponse = new GenericResponse();
		try {
			LOGGER.info("deleting " + perm_name);
			dao.delete(perm_name);
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
