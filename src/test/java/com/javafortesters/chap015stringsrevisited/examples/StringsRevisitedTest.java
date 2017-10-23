package com.javafortesters.chap015stringsrevisited.examples;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by robert.hope on 06/07/2017.
 */
public class StringsRevisitedTest {
    @Test
    public void aStringLiteralIsAnObject() {
        assertThat("hello".length(), is(5));
    }


    @Test
    public void canOutputStringsToTheConsole() {
        int i = 4;
        System.out.println("Print an int to the console " + i);
    }

    @Test
    public void canUseEscapeSequencesInAString() {
        System.out.println("Bob said \"hello\" to his cat's friend");
        System.out.println("This is a single backslash \\");
    }


    @Test
    public void canConcatenateStringsInDifferentWays() {

        //the concat method allows us to concatenate other strings but NOT other non string objects
        // if we need to concatenate mixed objects like strings and int's just use th "+" symbol
        String thisIs = "This is ";
        String s1 = thisIs.concat("String1");
        assertThat(s1, is("This is String1"));

        String ps1 = "This is " + "String2";
        assertThat(ps1, is("This is String2"));
        String ps2 = "This is " + 4;
        assertThat(ps2, is("This is 4"));

    }

    @Test
    public void canConvertToStrings() {

        /*Converting to a String with toString:
        Most classes override the toString method to provide a way of creating a String
 representation of the object. This provides a useful way
 of converting to a String, and this is the method called
 when you concatenate a String with a different type using +.

For primitive types, the associated object version is used
 e.g. for int the Integer.toString is used.
        */

        String intConcatConvert = "" + 1;
        assertThat(intConcatConvert, is("1"));

        String integerIntConvert = Integer.toString(2);
        assertThat(integerIntConvert, is("2"));

        // the string class has the valueOf method which takes objects and primitives and converts them to a String


        String integerStringConvert = String.valueOf(3);
        assertThat(integerStringConvert, is("3"));

    }

    // converting from a string:
    /*many objects have the valueOf method which can convert the value of the String to an associated object.

     */
    @Test
    public void canConvertFromString(){
        assertThat(Integer.valueOf("2"),is(2));

        //The string object also has a toCharArray, allowing us to convert to a character array

        char [] cArray = {'2','3'};
        assertThat("23".toCharArray(),is(cArray));
    }

    /* can also convert a string to a byte array using getBytes Method

    Converting to bytes from strings can be problematic
if we want to move our code between different machines
 as they may have a different default character set or
 character encoding. When we convert between byte and
 String we may need to control the encoding.
If we use an incorrect encoding then an UnsupportedEncodingException will be thrown:
     */

    @Test
    public void canConvertBytesUTF8() throws UnsupportedEncodingException {
        byte[] b8Array = "hello there".getBytes("UTF8");
    }
}
