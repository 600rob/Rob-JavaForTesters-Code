package com.javafortesters.chap012introductinginheritance.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 chapter 12 approach 3. this uses the EnvironmentUser Class and its inherited class methods
 along with its static use of the TestsAppEnv class. Note, i don't need to import the
 EnvironmentUser class here because it lives in the same package
 */
public class EnvironmentUserTest{

    @Test
    public void createEnvironmentUser(){
        EnvironmentUser robenv = new EnvironmentUser();

        assertEquals("username", robenv.getUsername());
        assertEquals("password",robenv.getPassword());
        assertEquals("http://192.123.0.3:67", robenv.getEnvUserUrl());

        System.out.println(robenv.getEnvUserUrl());
    }



}
