package com.javafortesters.chap010introducingcollections.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by robert.hope on 17/02/2017.
 */
public class UseForInsteadOfWhile {
    @Test
    public void forloop() {
        String[] days = {"Tuesday", " Thursday", "Wednesday",
                "Monday", "Saturday", " Sunday", "Friday"};
        //convert array to list
        List<String> daysOfWeek = Arrays.asList(days);
        int whileCount = 0;
        while (!daysOfWeek.get(whileCount).equals("Monday")) {
            whileCount++;
        }
        assertEquals("Monday is position 3","Monday",daysOfWeek.get(whileCount));
        System.out.println(daysOfWeek.get(whileCount));

        //we can re write the above code with a for loop as shown in the below code block
        //note how ive used the while condition in the for loop
        /*int forCount;
        for (forCount = 0; !daysOfWeek.get(forCount).equals("Monday");
             forCount++) {
            assertEquals("Monday is position 3","Monday",daysOfWeek.get(forCount));

        }*/
    }
}