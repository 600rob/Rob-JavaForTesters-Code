package com.javafortesters.domainentities.interim.composition.exercises;

import com.javafortesters.domainobject.TestAppEnv;


/**
 * Create a TestAppEnv within the user object - Chap 12 Approach 1- A user which implements getUrl through composition
 * when i create a new user object, the constructor creates a new TestAppEnv object called testAppEnv
 * This allows me to call the get url method from within this class*/

public class User {

    private String username;
    private String password;
    private TestAppEnv testAppEnv;
    /*private means that ONLY methods within this class and NOT those that import it
    can access these fields*/


    public User() {
        this("username", "password");
    }


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        //create a new TestAppEnv object within my user object in the constructor so i can
        //call the get url method later
        this.testAppEnv = new TestAppEnv();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // this is the standard password set method. It has no restrictions on password length
    public void setPassword(String password) {
        this.password = password;
    }



    public String getUrl() {
        return this.testAppEnv.getUrl();
    }

}






