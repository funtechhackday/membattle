package com.membattle;

/**
 * Created by Севастьян on 15.10.2017.
 */

public class RegistrationUser {
    private String username, password;

    public RegistrationUser(String s, String s1) {
        username = s;
        password = s1;
    }

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
}
