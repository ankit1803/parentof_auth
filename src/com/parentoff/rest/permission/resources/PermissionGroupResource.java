package com.parentoff.rest.permission.resources;

import com.parentoff.rest.common.GenericResponse;
import com.parentoff.rest.db.ParentDAO;
import com.parentoff.rest.db.dao.PermissionGroupDao;
import com.parentoff.rest.permission.model.PermissionGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/perm_group")
public class PermissionGroupResource {

	public static ParentDAO<PermissionGroup, String> dao = new PermissionGroupDao(
			PermissionGroup.class);
	public static Logger LOGGER = LoggerFactory
			.getLogger(PermissionGroupResource.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PermissionGroup> getAllPermissionsGroups() {
		LOGGER.info("Entering getAllPermissionsGroups..");
		List<PermissionGroup> permissionGroups = null;
		try {
			permissionGroups = dao.getAll();
			LOGGER.info("Exiting getAllGroups.." + permissionGroups);
		} catch (Exception e) {
			LOGGER.error("Exception occured in getAllGroups ", e);
		}

		return permissionGroups;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public GenericResponse addPermissionGroup(PermissionGroup permissionGroup) {
		LOGGER.info("adding addPermissionGroup");
		GenericResponse genericResponse = new GenericResponse();
		try {
			LOGGER.info(permissionGroup.toString());
			dao.insert(permissionGroup);
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
	@Path("{perm_grp_name}")
	@Produces(MediaType.APPLICATION_JSON)
	public GenericResponse deletePermissionGroup(@PathParam("perm_grp_name") String perm_grp_name) {
		LOGGER.info("deleting group name");
		GenericResponse genericResponse = new GenericResponse();
		try {
			LOGGER.info("deleting " + perm_grp_name);
			dao.delete(perm_grp_name);
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
