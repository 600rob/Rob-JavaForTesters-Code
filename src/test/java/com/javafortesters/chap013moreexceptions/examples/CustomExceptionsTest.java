package com.javafortesters.chap013moreexceptions.examples;


import com.javafortesters.domainentities.interim.exceptions.custom.InvalidPassword;
import com.javafortesters.domainentities.interim.exceptions.custom.User;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * Write two methods:
 * One which throws an InvalidPassword exception, than handles it with a try catch statement
 * if an invalid password is used in the creation of a user object using the argument constructor.
 *
 * The other method does not handle the exception when a user object is created using the default constructor
 *
 *Note, implement the exception in a new instance of the User class (stored as an abstract class)
 * This helps to keep the code easy to read instead of adding more to the original user class.
 *
 * write each method in this class as a test first then create the abstract classes and the relevant code
 */
public class CustomExceptionsTest {

    @Test
    public void canCreateDefaultUserWithoutHandlingException() {

        User auser = new User();
        assertEquals("username", auser.getUsername());
        assertEquals("password", auser.getPassword());

    }

    @Test
    public void haveToCatcIllegalPasswordForParamConstructor() {
        try {
            User aUser = new User("me", "wrong");
            fail ("An exception should have been thrown");
        } catch (InvalidPassword invalidpassword) {
            assertTrue("The exception was thrown", true);
        }
        /* Note that in the above code I used fail from JUnit
         to cause the @Test method to fail if we did not throw
          an assertion after creating the user. Without the fail
           call, the method would have passed if an exception had
            not been thrown, even though the method had actually
            failed. Be very careful when working with exceptions
            as you need to make sure that you don’t have ‘false positives’
             i.e. an @Test method passing, when it should have failed.
*/
    }
    @Test(expected = InvalidPassword.class)
    public void propogateIllegalPasswordExpected() throws InvalidPassword {
        User aUser = new User("me", "bad");
    }
}
