package com.parentoff.rest.login.resource;

import com.parentoff.rest.db.ParentDAO;
import com.parentoff.rest.db.dao.UserDao;
import com.parentoff.rest.logger.FileTracker;
import com.parentoff.rest.login.model.LoginResponse;
import com.parentoff.rest.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;

/**
 * Created by ankit on 10/5/16.
 */
@Path("/login")
public class LoginResource {
    public static ParentDAO<User, String> userDao = new UserDao(User.class);
    public static Logger LOGGER = LoggerFactory
            .getLogger(LoginResource.class);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public LoginResponse validateLogin(User user) {
        LoginResponse response = new LoginResponse();
        HashMap<String, Object> map = new HashMap<String, Object>();

        try{
            LOGGER.info("login user request " + user);
            map.put("uiUser", user);

            User dbuser = userDao.get(user.getUsername());
            map.put("dbUser", dbuser);

            LOGGER.info("db user " + dbuser);
            if(user.equals(dbuser)){
                response.setResponseDesc("success");
            }else {
                response.setResponseDesc("fail");
            }
            LOGGER.info("auth response " + response);

        }catch (Exception e){
            response.setResponseDesc("fail");
            map.put("error", e.getMessage());
        }finally {
            map.put("response", response);
            FileTracker fileTracker = new FileTracker("STARHEALTH_LOGIN");
            fileTracker.createMap(map);
            fileTracker.writeInfile();
        }

        return response;
    }

}
