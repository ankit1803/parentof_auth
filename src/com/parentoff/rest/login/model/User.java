package com.parentoff.rest.login.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;

/**
 * Created by ankit on 10/5/16.
 */
public class User {

    public static Logger LOGGER = LoggerFactory
            .getLogger(User.class);

    String username;
    String password;
    private Timestamp lastModified;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        LOGGER.info("username " + user.username);
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        LOGGER.info("password " + user.password);
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
