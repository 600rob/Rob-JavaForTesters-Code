package com.javafortesters.chap009arraysanditeration.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


/**
 * Created by robert.hope on 11/01/2017.
 */
public class UserArrayTest {



    @Test

    public void userArray() {
        User[] userGroup = new User[3];

        userGroup[0] = new User("test", "password");
        userGroup[1] = new User("rob", "testing");
        userGroup[2] = new User("andrew", "12345");


        System.out.println(userGroup[1].getUsername());
        assertEquals("user2 username is rob", "rob", userGroup[1].getUsername());


        for (User uzer : userGroup) {
            System.out.println(uzer.getUsername());
        }


    }

    @Test
    public void filluserGroupWith100Users() {

        //create a user array with 100 spaces
        User[] userGroup = new User[100];


//create a loop that is less than the size of the array. * using
// .length covers the situation of the array size changing

        for (int userIndex = 0; userIndex<userGroup.length; userIndex++) {
            //for each array position in the loop, assign the next userIndex value to
            // userID
            int userId = userIndex + 1;
            System.out.println(userId);

            //System.out.println(userIndex);

            userGroup[userIndex] = new User("user" + userId, "password" + userId);
            //check for names and passwords
            //System.out.println(userGroup[userIndex].getUsername() + "|"
                    //+ userGroup[userIndex].getPassword());


            //assert each user
            assertEquals("user" + userId + "|" + "password" + userId,
                    userGroup[userIndex].getUsername() + "|"
                            + userGroup[userIndex].getPassword());




        }

        }

        @Test
    public void sortWorkdays(){

            String [] workdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

            Arrays.sort(workdays);

            assertEquals("Friday",workdays[0]);
            assertEquals("Wednesday",workdays[4]);

            for (String a : workdays){
            System.out.println(a);}
        }


    @Test
    public void sortWeekdaysMixedCase (){

        String [] weekDaysMixed = {"monday", "Tuesday", "Wednesday", "thursday", "Friday"};

        Arrays.sort(weekDaysMixed);
        for(String a : weekDaysMixed){
            System.out.println(a);
            assertEquals( weekDaysMixed[ 0], "Friday");
            assertEquals( weekDaysMixed [ 1], "Tuesday");
            assertEquals( weekDaysMixed[ 2], "Wednesday");
            assertEquals(weekDaysMixed [ 3], "monday");
            assertEquals( weekDaysMixed[ 4], "thursday");

        }
    }
    }






