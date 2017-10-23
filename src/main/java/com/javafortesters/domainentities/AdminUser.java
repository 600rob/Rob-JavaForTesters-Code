package com.javafortesters.domainentities;



/**
 In this class we want to make use of the constructors and the get permissions methods
 BUT we will re write them specifically to return different values for this class so we can create AdminUser
 objects with different values
 */
public class AdminUser extends User {

    // re implement the default constructor for admin user objects

    public AdminUser() {
        this("adminuser","password");
    }

// re implement the normal constructor for admin user objects
    public AdminUser (String username, String password) {
        super (username,password);
    }


    //re implement getPermission so it returns a different value
    @Override
    public String getPermission(){
        return "Elevated";
    }

}
