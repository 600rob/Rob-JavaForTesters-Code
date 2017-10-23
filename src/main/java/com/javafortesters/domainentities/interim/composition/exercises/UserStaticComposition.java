package com.javafortesters.domainentities.interim.composition.exercises;

import com.javafortesters.domainobject.TestAppEnv;

/**
 * A user which implements getUrl through composition.
 *  Use testAppEnv statically chap 12 approach 2
 This class allows me to use the get url method from TestAppENV on a user object without
 extending the TestAppENV class. This is an example of composition. If you look through the class,
 you'll see that ive Done an import on the TestAppEnv class and use it to call the
 get url method below in a non static manner
 */


public class UserStaticComposition {

    private String username;
    private String password;


    public UserStaticComposition() {
        this("username", "password");
    }


    public UserStaticComposition(String username, String password) {
        this.username = username;
        this.password = password;
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


    public String getUserUrl() {
        return (TestAppEnv.getUrl());
    }
}
