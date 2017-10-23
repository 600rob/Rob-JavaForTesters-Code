package com.javafortesters.domainentities.interim.exceptions.custom;

/**
 * Created by robert.hope on 29/06/2017.
 * By creating the InvalidPassword Exception we alert people to the validation rules around setting
 * the password on a User.
 *
 * If you look in the user class you can see that the set password method has been amended to throw the
 * Invalid password exception when the password is less than 6 characters.
 * we also pass in the validation string "Password must be > 6 chars"
 *
 * The method on this class, when called returns
 * a String value specified and passed in by the calling code. The messates can be seen in the User
 * constructors that call this method
 */
public class InvalidPassword extends Exception{

    public InvalidPassword(String message){
        super(message);

    }
}
