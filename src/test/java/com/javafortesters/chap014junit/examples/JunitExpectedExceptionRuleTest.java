package com.javafortesters.chap014junit.examples;

import com.javafortesters.domainentities.interim.exceptions.custom.InvalidPassword;
import com.javafortesters.domainentities.interim.exceptions.custom.User;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by robert.hope on 05/07/2017.
 */
public class JunitExpectedExceptionRuleTest {
    /*the ExpectedException rule allows us to be specific about an exception and only count it as a psss in
    certain scenarios like:
    -a particular class of exception is thrown
    -an exception of a particular message
    an exception has a particular cause
    -any combination of the above

    The following would have the same effect as only annotating with the parameter "expected"
    this just gives us a bit more control
    */

    @Rule
    public ExpectedException expected =
            ExpectedException.none();

    /*we've added the @ Rule as a field in this class and instantiated it as an ExpectedException
    object with the static none method on ExpectedException
    */
    @Test
    public void invalidPasswordThrown()
            throws InvalidPassword {
        expected.expect(InvalidPassword.class);
        User user = new User("username", "<6");
    }

    /*
    In the @ test method we call the expect method from ExpectedException class,
     on the ExpectedException object "expected".
     We then configure it to expect an InvalidPassword.class
     */

    /* we can make this check more specific by specifying
     a substring of the expected message. By doing this the method
     will not pass if an InvalidPassword Exception gets thrown but it will
     with a different message
      */
// Note, we dont need to reuse the @Rule object as we already instantiated it in the class
    @Test
    public void invalidPasswordThrownBecauseOfLength()
            throws InvalidPassword {
        expected.expect(InvalidPassword.class);
        expected.expectMessage("> 6 chars");
        User user = new User("username", "<6");

    }

    //The substring can also be written with a hamcrest matcher like this

    @Test
    public void invalidPasswordThrownBecauseOfLengthWithMatcher()
            throws InvalidPassword {
        //expected.expect(InvalidPassword.class);
        expected.expectMessage(containsString("> 6 chars"));
        User user = new User("username", "<6");

    }
}
