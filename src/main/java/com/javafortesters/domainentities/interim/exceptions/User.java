package com.javafortesters.domainentities.interim.exceptions;


public class User {

    private String username;
    private String password;

    /*private means that ONLY methods within this class and NOT those that import it
    can access these fields*/

    public User() {
        this("username", "password");
    }


    public User(String username, String password) {
        this.username = username;
        setPassword(password);
    }

    //this set password method is called in the 2nd constructor at ln 19.
    // it sets the password and puts a check on the length. If the length does not meet the conditions
    // throw an error gets thrown
    public void setPassword(String password) {
        if (password.length() < 7) {
            throw new IllegalArgumentException("password length must be more than 6 chars");
        }

        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}





