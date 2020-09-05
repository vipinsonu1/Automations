package com.km.util;

public class JwtToken {
    String userName;
    String password;
    String applicationName;
    String applicationId;

    public JwtToken(){

    }


    public JwtToken(String userName,String password,String applicationId,String applicationName){

                   this.userName=userName;
                   this.password=password;
                   this.applicationName=applicationName;
                   this.applicationId=applicationId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
}
