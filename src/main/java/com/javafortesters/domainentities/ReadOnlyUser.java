package com.javafortesters.domainentities;

/**
 This class inherits the User class. It allows for A user object to be created which has
 Read only permissions level
 */
public class ReadOnlyUser extends User{
@Override
    public String getPermission(){
        return("Readonly");
    }
}
