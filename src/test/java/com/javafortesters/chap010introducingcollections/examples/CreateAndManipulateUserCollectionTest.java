package com.javafortesters.chap010introducingcollections.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by robert.hope on 09/03/2017.
 */
public class CreateAndManipulateUserCollectionTest {

    @Test
    public void createAndManipulateUsers() {

        //create a collection of type User
        Collection<User> userCollection = new ArrayList<>();
        assertEquals(0, userCollection.size());
        assertTrue(userCollection.isEmpty());

        setUpUserCollection(userCollection);
        assertEquals(2, userCollection.size());
        assertFalse(userCollection.isEmpty());



        //create second user collection

        Collection<User> userCollection2 = new ArrayList<>();
        assertEquals(0, userCollection2.size());
        assertTrue(userCollection2.isEmpty());

        setUpSecondUserCollection(userCollection2);
        assertEquals(2, userCollection.size());
        assertFalse(userCollection.isEmpty());

        // add all elements from first collection to second and check it

        userCollection.addAll(userCollection2);
        assertTrue(userCollection.containsAll(userCollection2));

        //remove all elements from the second collection
        userCollection2.removeAll(userCollection2);
        assertTrue(userCollection2.isEmpty());

        //clear the first collection and check it

        userCollection.clear();
        assertEquals(0,userCollection.size());
        assertTrue(userCollection.isEmpty());






    }

    //put the creation of each collection into a separate method.

    public void setUpUserCollection(Collection collection1) {


        for (int i =0 ; i < 2; i++) {
            int userIndex = i+1;
            collection1.add(new User("user" + userIndex, "password" + userIndex));
        }
        assertEquals("collection setup is correct size",
                2, collection1.size());

    }

    //put the creation of the second collection into a separate method.

    public void setUpSecondUserCollection(Collection collection1) {


        for (int i =2 ; i < 4; i++) {
            int userIndex = i+1;
            collection1.add(new User("user" + userIndex, "password" + userIndex));
        }
        assertEquals("collection setup is correct size",
                2, collection1.size());

    }

}