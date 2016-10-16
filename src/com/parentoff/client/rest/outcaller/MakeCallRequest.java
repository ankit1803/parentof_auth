package com.parentoff.client.rest.outcaller;

import java.util.Map;

/**
 * Created by ankit on 27/7/15.
 */
public class MakeCallRequest {
    private String uid;
    private String name;
    private String phoneNumber;
    private Map<String, String> context;
    private String languagePref;
    private String priority;
    private String expiryTime;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<String, String> getContext() {
        return context;
    }

    public void setContext(Map<String, String> context) {
        this.context = context;
    }

    public String getLanguagePref() {
        return languagePref;
    }

    public void setLanguagePref(String languagePref) {
        this.languagePref = languagePref;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    @Override
    public String toString() {
        return "MakeCallRequest{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", context=" + context +
                ", languagePref='" + languagePref + '\'' +
                ", priority='" + priority + '\'' +
                ", expiryTime='" + expiryTime + '\'' +
                '}';
    }
}