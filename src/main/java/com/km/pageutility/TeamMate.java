package com.km.pageutility;

public class TeamMate {
    private String email;
    private boolean role;


    public TeamMate(String email, boolean role) {
        this.email = email;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }


}
