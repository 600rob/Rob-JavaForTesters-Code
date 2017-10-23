package com.javafortesters.domainentities.interim.inheritance;

import com.javafortesters.domainobject.TestAppEnv;

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
        //this.password = password;
        setPassword(password);
        this.testAppEnv = new TestAppEnv();


    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    /*Create a TestAppEnv within the user object - Chap 12 Approach 1

    This method sees me create a new TestAppEnv object within my user object
    in the constructor.
    So when i create a new user object, i can call the get url method
    on the TestAppEnv object that also gets created*/

    public String getUrl() {return this.testAppEnv.getUrl();}


    // this is the standard password set method. It has no restrictions on password length
    /*public void setPassword(String password) {
     //   this.password = password;
    }
    */


    //this set password method is called in the 2nd constructor at ln 22.
    // it sets the password and puts a check on the length. If the length does not meet the conditions
    // throw an error gets thrown
    public void setPassword(String password) {
        if (password.length() < 7) {
            throw new IllegalArgumentException("password length must be more than 6 chars");
        }

        this.password = password;
    }
/* Use testAppEnv statically chap 12 approach 2
this method allows me to use the get url method from TestAppENV on a user object without
extending the TestAppENV class. This is an example of composition. If you look at this class,
you'll see that ive Done an import on the TestAppEnv class and called the
get url method below in a non static manner
 */
    public String getUserUrl() {
      return("This user is using the following url "
              + TestAppEnv.getUrl());
    }
//return the permission level for a User in a String with value "Normal"
    public String getPermission() {
        return"Normal";
    }
}