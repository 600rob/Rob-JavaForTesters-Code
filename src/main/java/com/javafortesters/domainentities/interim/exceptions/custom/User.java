package com.javafortesters.domainentities.interim.exceptions.custom;



/**
 * This class handles an invalid password exception in a user object if the object is created
 * using the default constructor. Note we don't need to import the InvalidPassword class
 * as it lives in the same package
 */
public class User {


    private String username;
    private String password;

    private  String mustIncludeADigit = ".*[0123456789]+.*";
    private String AtoZ = ".*[A-Z]+.*";

    public User(){
        this("username", "Password1" ,false);
    }
    /*because we are calling a constructor from another constructor then the first statement
    in the constructor uses "this" That means we can not wrap the try
    catch block into the default constructor because it calls another constructor. So what we do is  use
    "false" in the default constructor so that we get it to call the private  which
    can use the try catch block constructor below */

    private User(String username, String password, boolean b) {
        // only call this because we don't want to throw the exception
        this.username = username;
        try{
            setPassword(password);
        }catch(InvalidPassword e){
            throw new IllegalArgumentException(
                    "Default password incorrect ", e);
        }
    }
    //this ensures that anyone using the no arg constructor does not experience an InvalidPassword
    // exception for a hard coded password

    public User(String username, String password) throws InvalidPassword{
        this.username = username;
        setPassword(password);
    }
/* make set password throw InvalidPassword message if the password is <7 characters
Note the message that we pass into the InvalidPassword exception to describe the error
 */

    public void setPassword(String password) throws InvalidPassword {


        if(password.length()<7){
            throw new InvalidPassword("Password must be > 6 chars");
        }

        if(!password.matches(mustIncludeADigit)){
            throw new InvalidPassword("password must include a digit!");
        }

        if (!password.matches(AtoZ)){
            throw new InvalidPassword("password must contain an uppercase letter!");
        }

        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}