package com.javafortesters.chap007basicsofjavarevisited.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by robert.hope on 14/12/2016.
 */
public class StringsExampleTest {

    @Test
        public void stringsConcatenated(){
            assertEquals("123456", "12" + "34" + "56");
        }

        @Test
        public void someStringMethods(){
            String aString = "abcdef";

            assertEquals(6, aString.length());
            int result = aString.compareToIgnoreCase("ABCDEF");
            assertTrue(aString.compareToIgnoreCase("ABCDEF")==0);
            assertTrue(aString.contains("bcde"));
            assertTrue(aString.startsWith("abc"));
            System.out.println(result);

            // string indexing starts at 0
            assertEquals('c', aString.charAt(2));
            assertEquals("ef", aString.substring(4));
        }
    }

