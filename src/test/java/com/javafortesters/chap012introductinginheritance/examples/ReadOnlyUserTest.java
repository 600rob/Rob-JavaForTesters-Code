package com.javafortesters.chap012introductinginheritance.examples;

import com.javafortesters.domainentities.ReadOnlyUser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *create a ReadOnlyUser Object with permission Readonly and the default username and password
 */
public class ReadOnlyUserTest {

    @Test
    public void readOnlyUserHasPermissionReadOnly(){
/*
write code to create a ReadOnlyUser Object. Create the ReadOnlyUser Class, inheriting the User class.
Re implement the get permissions method then run the code from here
 */
        ReadOnlyUser readonly = new ReadOnlyUser();
        assertEquals("username", readonly.getUsername());
        assertEquals("password", readonly.getPassword());
        assertEquals("Readonly", readonly.getPermission());


    }
}
