package com.example.img.url.model;

/**
 * @description:
 * @author: 凝血
 **/
public class Session {
    private String sessionID;
    private String userName;

    public Session() {
    }

    public Session(String sessionID, String userName) {
        this.sessionID = sessionID;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

}
