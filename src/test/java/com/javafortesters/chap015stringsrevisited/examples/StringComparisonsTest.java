package com.javafortesters.chap015stringsrevisited.examples;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by robert.hope on 02/08/2017.
 */
public class StringComparisonsTest {

    @Test
    public void canCompareToString() {
        /* compareTo compares a string you call a method on against a string parameter

        - if the two strings are equal then the compareTo method returns zero
         */

        String hello = "hello";
        assertThat(hello.compareTo("hello"), is(0));
        assertThat(hello.compareTo("hello") < 0, is(false));

        /* if the argument string is smaller than the String then the method returns a negative number as follows.

         */

        assertThat(hello.compareTo("helloo") < 0, is(true));
        System.out.println(hello.compareTo("helloo"));

        /* if the argument string is larger than the String then the method returns a positive number as follows.

         */

        assertThat(hello.compareTo("h") > 0, is(true));
        assertThat(hello.compareTo("Helln") > 0, is(true));
        assertThat(hello.compareTo("HelLo") > 0, is(true));

        /*when using compareTo, the method considers a difference and string length OR an difference
        in the actual character ( including case)

         */

        /*
        compareToIgnoreCase works the same way but it ignores the case of letters
         */

        assertThat(hello.compareToIgnoreCase("hello"), is(0));
        assertThat(hello.compareToIgnoreCase("Hello"), is(0));
        assertThat(hello.compareToIgnoreCase("HeLlo"), is(0));

    }

    /*the contains method returns true if the parameter string is contained with in the string.
    It also returns true if the parameter equals the string
     */
    @Test
    public void canCheckContainsOnAString() {
        String hello = "hello";
        assertThat(hello.contains("hel"), is(true));
        assertThat(hello.contains("rob"), is(false));
    }

    /* contentEquals and equals returns true if the string has the same content as the parameter.
     If it does not, it returns false */

    @Test
    public void checkContentEqualsOnAString (){

        String hello = "hello";
        assertThat(hello.contentEquals("hello"),is(true));

        System.out.println("check the contentEquals method -" + hello.contentEquals("hello"));
        System.out.println("check the contentEquals method  -" + hello.contentEquals("hllo"));

        // the equals method add an additional rule to check the the parameter
        // is a string as well as having equal content

        System.out.println("check the equals method -" + hello.equals("1234"));

             /* contentEqualsIgnoreCase returns true if the string has the same content as the parameter.
     If it does not, it returns false */

        System.out.println("check the equals method whist ignoring case -"
                + hello.equalsIgnoreCase("HeLlO"));
    }

    // endsWith ans startsWith
    //endsWith compares the end of a String to a parameter
//startsWith compares the end of a String to a parameter. both are case sensitive
    @Test
    public void checkendsWithAndStartsWith (){

        String hello = "hello";


        assertThat(hello.startsWith(""),is(true));
        assertThat(hello.startsWith("hel"),is(true));

        assertThat(hello.endsWith("llo"),is(true));
        assertThat(hello.endsWith(""),is(true));
    }

    //isEmpty. This method returns true if the string length is 0 and
    // false if it is >0

    @ Test
    public void checkIsEmpty(){

        String empty = "";

        assertThat(empty.isEmpty(),is(true));
        assertThat(empty.length(),is(0));

        String notEmpty = "  ";
        assertThat(notEmpty.isEmpty(),is(false));
        assertThat(notEmpty.length(),is(2));


    }

    //Region matches. this method allows you specify a region with in a String using indexes.
    @Test
    public void checkRegionMatches() {
   /*
         "Hello fella"
          01234567890
         */
        String hello = "Hello fella";
        assertThat(
                hello.regionMatches(true, 6, "fez", 0, 2),
                is(true));

        /*In the above example we specify the region of the hello string where we want to start our comparison search.
         This is index position 6. IMPORTANT the start position is critical because the code compares EVERYTHING from
         the start point onwards

         we then use a sub string ("fez") as our comparison string. We define a region in this substring
         of start position 0 and length 2. *Note the second integer is LENGTH and NOT index position!!

         So, in summary  what're doing is, looking through our String that we declared as hello.
         We start looking from the 6th index position onwards.
         from index position 6 we are looking for the substring "fe".

         If we find it the method returns true*/

        // case insensitive search.  Search from position 0 for length 2
        assertThat(
                hello.regionMatches(true, 0, "he", 0, 2),
                is(true));

        // case sensitive search
        assertThat(
                hello.regionMatches(false, 0, "hE", 0, 2),
                is(false));

        // you can only specify the boolean condition at the end as follows:

        assertThat(
                hello.regionMatches(0, "hE", 0, 2),
                is(false));

        assertThat(
                hello.regionMatches(0, "He", 0, 2),
                is(true));

    }

    //indexOf and lastIndexOf: both opf these methods return the position of a string
    //the character parameter or String parameter can be found

    //inedxOf returns the FIRST place in a string where the param can be found: i.e:

    @Test

    public void canFindIndexOf(){
 /*
         "Hello fella"
          01234567890
         */

        String hello ="Hello Fella";

        assertThat(hello.indexOf("l"),is(2));


        //lastIndexOf returns the LAST place in a string where the param can be found: i.e:

        assertThat(hello.lastIndexOf("l"),is(9));

        //both methods can be called with an additional param which specifies a start position from where to start
        //searching the string, like this

        assertThat(hello.indexOf("l",3),is(3));
        assertThat(hello.indexOf("l",4), is(8));
        /*this verifies the position of the first instance of character "l"
        that appears AFTER position 3 in the string. * Note, indexOf
        searches from the given position all the way to the end of the string until it finds the first instance
        ot the parameter
         */

        /*lastIndexOf searches from the position given towards the start of the string
        until it finds the last instance of the param*/
        assertThat(hello.lastIndexOf('l',8), is(8));
        assertThat(hello.lastIndexOf("l",7), is(3));


        /*if the indexOf or lastIndexOf method can not find the
        instance of the parameter within the string, the method will
        return a value of -1 as follows*/

        assertThat(hello.indexOf('z'), is(-1));
        assertThat(hello.lastIndexOf("z"), is(-1));

    }




    }