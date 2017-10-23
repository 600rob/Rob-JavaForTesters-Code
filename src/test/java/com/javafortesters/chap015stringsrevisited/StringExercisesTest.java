package com.javafortesters.chap015stringsrevisited;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by robert.hope on 06/07/2017.
 */
public class StringExercisesTest {
    @Test
    public void usingOtherEscapeCharacters(){

        System.out.println("print a single back slash at the end of this string \\");
        System.out.println(" the double quote \"hello\"");
        System.out.println("the single quote \'test");
        System.out.println("insert a tab between this\tand this");
        System.out.println("use a backspace at the end of this string \b");
        System.out.println("print some text on a new line \n this should be the new line");
        System.out.println("what the hell is a carriage return??? \r this");

        System.out.println("Carriage return after each word");
        System.out.println("one\rtwo\rthree\rfour\rfive\r");

        System.out.println("Backspace after each word");
        System.out.println("one\btwo\bthree\bfour\bfive\b");

        System.out.println("print new lines and tabs");
        String firstLine = "|first line\n";
        String secondLine = "|\tsecond line\n";
        String thirdLine = "|\t\tthird line\n";
        String fullLine = firstLine + secondLine + thirdLine;
        System.out.println(fullLine);

    }

    //we can create new strings with no args in order to make a zero length string. And also one with args to make
    // strings with values

    @Test
    public void canConstructStrings(){
/*we can create a new string with no args to create a zero length string as follows*/
        String empty = new String();
        assertThat(empty.length(),is(0));
/* the conventional method os making a new string is to provide some args to greate the string, as follows

 */
        String notEmpty = new String("abc");
        assertThat(notEmpty.length(), is(3));

        /*we can also pass in arguments in the form of objects like char[], byte[], StringBuffer,
        StringBuilder to create a new string. Note StringBuffer is a mutable string
        StringBuilder is a mutable String */

        char [] cArray = {'2','3'};
         assertThat(new String(cArray),is("23"));

        //check the index position of the last character
        assertThat(new String(cArray,1,1),is("3"));
        System.out.println(new String (cArray,1,1));

        // convert string to byte array using get bytes
        byte[] bArray = "hello there".getBytes();
        assertThat(new String(bArray, 3,3), is("lo "));

        System.out.println(new String(bArray,0,3));
        /*The numbers represent the start and end positions
         of the characters that get returned from the string.
        for example we convert the byteArray "hello there" to a string
        its characters are represented kind of like index positions:

        hello there
       01234567891011

    Note the first character starts at zero.
    If we want to access the letters we just use the start position
    and the number of positions that we want to access there after

    Lets say we want to print the first three characters "hel" we would create the new string
    and specify the positions to output in a print statement

    like this
*/
        System.out.println(new String(bArray,0,3));
        //access and print middle characters "o th"
        System.out.println(new String(bArray,4,4));

        byte[] b8Array = new byte[0];
        try {
            b8Array = "hello there".getBytes("UTF8");
            assertThat(new String(b8Array, 3, 3, "UTF8"), is("lo "));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String hello = new String("hello" + " " + "there");
        assertThat(hello, is("hello there"));

    }
/*
Write an @Test method which uses regionMatches to search
 in the String "Hello fella". And match a region of the
 substring "young lady". e.g. search for the "la" portion
 of "young lady" in "Hello fella" */
    @Test
    public void useRegionMatches(){

        String hello ="Hello fella";
       assertThat(hello.regionMatches(9, "young lady", 6,2),
               is(true));

    }
}


