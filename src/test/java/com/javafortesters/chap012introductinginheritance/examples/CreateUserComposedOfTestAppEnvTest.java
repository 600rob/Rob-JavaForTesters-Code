package com.javafortesters.chap012introductinginheritance.examples;


import com.javafortesters.domainentities.interim.composition.exercises.User;
import com.javafortesters.domainentities.interim.composition.exercises.UserStaticComposition;
import com.javafortesters.domainobject.TestAppEnv;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Create user objects which make use of the TestAppEnv getUrl method, without the use of inheritance
 */
public class CreateUserComposedOfTestAppEnvTest {
    /* Approach 1 -Create a TestAppEnv object in the user class

    Ive amended the User constructor to create a TestAppEnv object on instantiation.
    This allows me to call the get url method without extending the class. This approach
    calls the getUrl method Directly from the TestAppEnv object
    */



    @Test
            public void composeUserWithNewTestAppEnvObject() {
        User bob = new User("bob","password1");

        assertEquals(bob.getUrl(), TestAppEnv.getUrl());
        System.out.println(bob.getUsername()+"/"+bob.getPassword());
        System.out.println(bob.getUrl());

    }

/* approach 2 - Use TestAppEnv Statically


            i've imported TestAppEnv it into the User class and created a method
            in the User class which calls the getUrl Method from TestAppEnv. this allows me to call the getUrl
            method when i create a new User object. This calls the getUser url in the User object, which in turn calls the original getUrl
            on TestAppEnv* this is the method i came up with

     */
@Test
    public void composeUserWithStaticTestAppEnvMethod(){
    UserStaticComposition rob = new UserStaticComposition("rob","password");
    assertEquals(rob.getUserUrl(), TestAppEnv.getUrl());
    System.out.println(rob.getUserUrl());
    System.out.println(TestAppEnv.getUrl());
}


}
