package com.javafortesters.chap010introducingcollections.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by robert.hope on 03/05/2017.
 */
public class CreateAndManipulateUserMapTest {

    @Test

    public void createAndManipulateUserMap(){

        Map<String,User> map = new HashMap<>();

        User bobcat = new User("user1", "password1");
        User holly = new User("user2", "password2");


        // get the  String username from user. use this as the String key
        map.put(bobcat.getUsername(), holly);
        map.put(bobcat.getUsername(), bobcat);
        assertEquals(1,map.size());


    }

}
