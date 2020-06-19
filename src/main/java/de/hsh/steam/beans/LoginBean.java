/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsh.steam.beans;

import de.hsh.steam.application.Steamservices;
import de.hsh.steam.application.User;
import de.hsh.steam.persistence.SerializedSeriesRepository;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Kai
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String userName;
    private String userPassword;
    private boolean loggedIn;
    private String loggedName;

    public String getLoggedName() {
        return loggedName;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
    
    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    public String getName()
    {
        if(loggedIn)
        {
            return loggedName;
        }
        else
        {
            return "Anmelden";
        }
    }
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    public void Login()
    {
        if(Steamservices.singleton().login(userName, userPassword))
        {
            loggedIn = true;
            loggedName = userName;
        }
    }
    
    public void Signin()
    {
        if(Steamservices.singleton().newUser(userName, userPassword))
        {
            Steamservices.singleton().login(userName, userPassword);
        }
    }
}
