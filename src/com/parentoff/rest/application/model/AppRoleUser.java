package com.parentoff.rest.application.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ankit on 10/5/16.
 */
public class AppRoleUser {

    public static Logger LOGGER = LoggerFactory
            .getLogger(AppRoleUser.class);

    int app_id;
    String user_name;
    String perm_name;
    String perm_grp_name;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}


