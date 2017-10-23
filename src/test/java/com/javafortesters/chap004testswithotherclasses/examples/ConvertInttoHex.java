package com.javafortesters.chap004testswithotherclasses.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by robert.hope on 25/11/2016.
 */
public class ConvertInttoHex {

    @Test

    public void convertIntToHex(){
        assertEquals("int 11 is hex" , "b", Integer.toHexString(11));
        assertEquals(" int 10 is hex a", "a", Integer.toHexString(10));
        assertEquals("int 3 is hex 3", "3",Integer.toHexString(3));
        assertEquals("int 21 is hex 15", "15", Integer.toHexString(21));
    }

    @Test
    public void verifyMaxAndMinJavaIntegerValues(){

        int minValue = -2147483648;
        int maxValue = 2147483647;

        assertEquals ("max Integer value is 2147483647", maxValue,Integer.MAX_VALUE );
        assertEquals ("min Integer value is -2147483648", minValue,Integer.MIN_VALUE );
    }

    @Test
    public void doesFourEqualsFour(){

        Integer firstFour = new Integer(4);
        Integer secondFour = new Integer(4);

        assertEquals (firstFour,secondFour);
        //assertTrue (firstFour==secondFour);
        /*when we use the assert equals method, Junit uses the method on the objects
         to compare their values. in the case of assert equals, each object has the
         same value.
         in the case of assert true using the equality operator, Junit is looking at each object and
         seeing if they are equal to each other...not their values but the actual objects
         although each object has the same value, they are NOT the same object. (they are two
         different instances of the class Integer*/
    }




}
