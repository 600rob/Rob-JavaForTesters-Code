package com.javafortesters.chap010introducingcollections.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.HashSet;
import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by robert.hope on 06/04/2017.
 */
public class CreateAndManipulateUserSetTest {

    @Test
     public void createUserSet(){

        Set<User> userSet = new HashSet<>();

        User bobe = new User("user1", "password1");

        //a set does not accept duplicates, it will only accepts a single instance of an object.
        // all other duplicates are ignored

        userSet.add(bobe);
        userSet.add(bobe);
        userSet.add(bobe);
        userSet.add(bobe);

        assertEquals(1, userSet.size());

    }
}
