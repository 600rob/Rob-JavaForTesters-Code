package com.javafortesters.chap012introductinginheritance.examples;

        import com.javafortesters.domainentities.User;
        import com.javafortesters.domainobject.TestAppEnv;

/**
 * chapter 12 approach 3
 * Create user objects which make use of the TestAppEnv getUrl method, without the use of inheritance
 * - Here ive created a new class which extends the User class.
 this means that every time we create a new object of this class we can make direct use
 of the methods on the User class.
 Ive also imported TestAppEnv and created a getUrl method on this class. This allows
 us to call the get url method on all Environment user Objects
 */
 /*

  */
public class EnvironmentUser extends User {

    public String getEnvUserUrl(){
        return TestAppEnv.getUrl();
    }



}
