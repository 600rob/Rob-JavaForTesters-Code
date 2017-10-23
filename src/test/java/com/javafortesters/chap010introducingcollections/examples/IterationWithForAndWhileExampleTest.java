package com.javafortesters.chap010introducingcollections.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by robert.hope on 03/03/2017.
 */
public class IterationWithForAndWhileExampleTest {

    String[] someDays = {"Tuesday", "Thursday", "wednesday",
            "Monday", "Saturday", "Sunday", "Friday"};

    List<String> days = Arrays.asList(someDays);



    //comparison of different loop types


    // Comparing loop types
    // The following 4 methods use different loop constructs in order to determine the position of monday in the list "someDays
    // Note i defined the list "days" at class level so we can use it anywhere in this class


    @Test
    //for each loop- iterates over each item in the list, then break when we find monday
    public void forEachLoop() {

        int forCount = 0;
        for (String day : days) {
            if (day.equals("Monday")) {
                break;
            }
            forCount++;
        }
        assertEquals("monday is at position 3", 3, forCount);
    }


    @Test
    //for loop- iterate over the size of the list, then break when we find Monday
    public void forLoop() {
        int loopCount;
        for (loopCount = 0; loopCount < days.size(); loopCount++) {
            if (days.get(loopCount).equals("Monday")) {
                break;
            }
        }
        assertEquals("monday is position 3", 3, loopCount);
    }

    @Test
    // In the while loop, use check for monday the loop exit condition. This means the loop
    //only executes while we have not found monday
    public void whileLoop() {
        int count = 0;
        while (!days.get(count).equals("Monday")) {
            count++;
        }
        assertEquals("monday is position 3", "Monday", days.get(count));
    }

    @Test
/* with the do while loop we set the index count at -1, outside the valid boundary of the list because
         it gets incremented in the body of the loop and we want it to check each item from the first position in the list
         i.e position 0 ( tuesday) If we set the index at 0, the check would still work BUT, it would increment the index to 1
         thus causing the code to skip the check at position 0. As with the while loop, the loop body only gets executed
         while we have not found "Monday"
          */
    public void doWhileLoop() {
        int doCount = -1;
        do {
            doCount++;
            System.out.println(doCount);
        } while (!days.get(doCount).equals("Monday"));
        assertEquals("monday is position 3", "Monday",days.get(doCount));


    }

    @Test
    public void checkPositiions(){
        System.out.println(days.get(3));
    }



}
