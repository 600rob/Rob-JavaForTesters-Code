package com.javafortesters.chap015stringsrevisited;

import com.javafortesters.domainentities.interim.exceptions.custom.InvalidPassword;
import com.javafortesters.domainentities.interim.exceptions.custom.User;
import org.junit.Test;

/**
 * Created by robert.hope on 21/08/2017.
 * Add the regular expression checks to the setPassword
 method on User so that an IllegalPassword exception
 is thrown if the password does not contain a digit,
 or does not contain an upper case letter.

 */
public class RegularExpressionsSetUserPassword {

    //if we want to check the error message just comment out the
    // expected annotation and enter an invalid password
    //if we run an invalid password with the expected annotation it will pass as it is expected

    @Test (expected = InvalidPassword.class)
    public void canNotCreateUserWithInvalidPassword() throws InvalidPassword {

        User rob = new User("robbo", "testing");

    }
//Because we have added some new validation around the password construction
    // we need to change the default constructor so that default user construction passes.
    //i.e make sure the default password contains a digit and an uppercase letter
    @ Test
    public void checkUserDefaultConstructorStillWorks() throws InvalidPassword{
        User auser = new User();
    }
}
