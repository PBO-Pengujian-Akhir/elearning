/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Dosen;

/**
 *
 * @author fauza
 */
public class UserSession {
    private String userId;
    private String userName;

    private static UserSession instance;

    private UserSession() {
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public void clearSession() {
        userId = null;
    }

    public boolean isUserLoggedIn() {
        return userId != null && userName != null;
    }


}
