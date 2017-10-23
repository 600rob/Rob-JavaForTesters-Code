package com.javafortesters.chap013moreexceptions;

import com.javafortesters.domainentities.interim.exceptions.custom.InvalidPassword;
import com.javafortesters.domainentities.interim.exceptions.custom.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;



/**
 * Created by robert.hope on 30/06/2017.
 */

/*To check the InvalidPassword exception is thrown in the constructor, use the "expected" parameter to check
 for the thrown exception. We do this because we are expecting the test to fail which is a pass!!
 Since the exception is a checked exception I have to add the throws keyword in
 the method declaration:

 */
public class CheckedExceptionThrowingUserTest {
    @Test (expected = InvalidPassword.class)
    public void constructUserWithException() throws InvalidPassword {
        User aUser = new User("username", "p");
    }
/* To check that the default constructor does not throw an exception,
 all I do is create the User and assert that the default password was created.
 */
    @Test
    public void createDefaultUserWithNoThrowsInvalidPasswordException() {
        User aUser = new User();
        assertEquals("password",aUser.getPassword());
    }

    //to check the error message we try and catch the exception, then check the error message
    @Test
    public void createUserWithInvalidPasswordExceptionMessages(){
        User aUser;

        try {
            aUser = new User("username", "paz");
            fail("An Invalid Password Exception should have been thrown");
        } catch (InvalidPassword e) {
            assertTrue(e.getMessage().startsWith("Password must be > 6 chars"));
            System.out.println(e.getMessage());
        }
        /* in the above we add the fail statement. this is added because the exception is supposed to
            get thrown and the fail statement should never get executed. If the fail statement does get executed
            it means the exception was not thrown. Hence we need to force an @test failure to make this clear.
            If we don't have the fail statement and the exception does not get thrown,
            the method would pass, but for the incorrect reasons.
            you can check this by experimenting
            with the password length and commenting out the fails statement

             */
    }

    /*Ensure the setPasswordMethod throws the exception.
    To do this, I create the User with the default constructor
    since I know that will not throw the exception. Then wrap
    the setPassword with a try catch. And I repeat the text
    assertion in the catch block. Note that I also add the
    fail statement. This exercise is a good example of why the
    fail statement is important. Without the fail statement my
    @Test method could pass in the event that a valid password gets set
     which would cause the exception NOT to be thrown.
     In summary the fail statement forces a fail, alerting
     us to the fact that the exception was not triggered
*/
    @Test
    public void setPasswordWithInvalidPasswordExceptionMessages(){
        User aUser = new User();

        try {
            aUser.setPassword("tiny");
            fail("An Invalid Password Exception should have been thrown");

        } catch (InvalidPassword e) {
            assertTrue(e.getMessage().startsWith("Password must be > 6 chars"));
        }
    }

}
