package com.javafortesters.chap010introducingcollections.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by robert.hope on 03/04/2017.
 */
public class CreateAndManupulateUserListTest {

    @Test
    public void createAndManipulateListOfUsers(){

        List<User> userList = new ArrayList<>();

        User user1 = new User("user1","password1");
        User user2 = new User("user2","password2");

        userList.add(user1);
        userList.add(user2);


        assertEquals(0,userList.indexOf(user1));
        assertEquals(1,userList.indexOf(user2));

        userList.remove(0);

        assertEquals(1,userList.size());
        assertEquals(0,userList.indexOf(user2));

    }


}
