package com.javafortesters.chap012introductinginheritance.examples.examples;

import com.javafortesters.domainentities.AdminUser;
import com.javafortesters.domainentities.User;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 * Created by robert.hope on 18/05/2017.
 * In this example, the class either either uses imports on AdminUser or User. It also uses EmptyUser
 * which is located in the same package so it has not been imported. Empty user extends User so we have access
 * to the Methods on the user class
 * All of the above means we don't have to create new methods in this class for the Objects created below
 */
public class InheritanceTest {

    /*because we have extended the user class, this class
    now has the same functionality as our User class. Hence we can run the @test method below
     */

    @Test
    public void emptyUserExampleTest() {

        EmptyUser enu = new EmptyUser();
        assertEquals("username", enu.getUsername());
        assertEquals("password", enu.getPassword());

    }


    @Test
    public void aUserHasNormalPermissions() {
        //write the get permission method here, then create it in the User class
        User aUser = new User();
        assertEquals("Normal", aUser.getPermission());
    }

    /*use inheritance to create users with different permissions
 */


/*now i will create a different type of User. an AdminUser, which extends user
  and has elevated permissions level. will write the code here first then have to create
  An adminUser Class with the relevant methods and inheritance. We will need to re implement
  some of the methods in the AdminUser class in order to create different object values.
  The get methods for username and password don't need to be re implemented as they are inherited

 */

    @Test
/* write a method to check the username, password and elevation level on an AdminUser object
created with the default constructor. Write the method before AdminUser class exists.
Expect for errors. Then go and create
The AdminUser Abstract Class. don forget to Inherit User! */

    public void AdminUserDefaultConstructorIsElevated() {
        AdminUser adminUser = new AdminUser();
        assertEquals("adminuser", adminUser.getUsername());
        assertEquals("password", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());

    }

/* repeat the above method but with the normal constructor
 */

    @Test
    public void AdminUserNormalConstructorIsElevated() {
        AdminUser adminUser = new AdminUser("admin", "password");
        assertEquals("admin", adminUser.getUsername());
        assertEquals("password", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());


    }
}
