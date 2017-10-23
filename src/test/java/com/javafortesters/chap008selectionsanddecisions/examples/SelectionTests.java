package com.javafortesters.chap008selectionsanddecisions.examples;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * ArrayExamplesTest from chap008 - dont save exercises here!
 */
public class SelectionTests {

    @Test
    public void moreTernary() {

        String url = "www.bobhope.com";


        url = url.startsWith("http") ? url : addHttp(url);
        assertTrue("url starts with http", url.startsWith("http"));
        assertEquals("bobhope.com uses http", "http://www.bobhope.com",
                url);
        System.out.println(url);
    }
/*(url) the we see in the method 'addhttp' is a local variable so it can take any name.
It uses the value declared in line 13 and passed in from the calling method in line 15. naming the local variable
 url can be confusing if you (i) dont understand the concept that it is a local variable

 */

    private String addHttp(String url) {
        return "http://" + url;

    }


    @Test
    public void ifAddHttp() {
        String url = "www.seleniumsimplified.com";
        if (!url.startsWith("http")) {
            url = addHttp(url);
            assertTrue("url starts with http", url.startsWith("http"));
            assertEquals("site.com uses http", "http://www.seleniumsimplified.com",
                    url);
        }
    }

    @Test
    public void ifElseAddhttp() {
        String url = "www.seleniumsimplified.com";
        if (url.startsWith("http://"))
            //don't do anything except to print the url since it contains http://
            System.out.println(url);


        else url = addHttp(url);
        assertTrue(
                url.startsWith("http://"));
        assertEquals("http://www.seleniumsimplified.com",
                url);
        System.out.println("modified url is" + " " + url);


    }

    @Test
    public void ifElsenestedAddHttp() {
        String url = "seleniumsimplified.com";
        if (url.startsWith("http://")) {
            //do nothing as the url is fine
        } else {
            if (!url.startsWith("www")) {
                url = "www." + url;
                System.out.println(url);
            }
            url = addHttp(url);
            System.out.println(url);
        }
        assertTrue(url.startsWith("http://"));
        assertEquals("http://www.seleniumsimplified.com", url);


    }

    @Test
    public void switchExample(){

        assertEquals("M", likelyGenderIs("SIR"));
        assertEquals("M", likelyGenderIs("mr"));
        assertEquals("M", likelyGenderIs("master"));
        assertEquals("F", likelyGenderIs("miss"));
        assertEquals("F", likelyGenderIs("mrs"));
        assertEquals("F", likelyGenderIs("ms"));
        assertEquals("F", likelyGenderIs("lady"));
        assertEquals("F", likelyGenderIs("madam"));
    }

    public String likelyGenderIs(String title){
        String likelyGender;

        switch(title.toLowerCase()){
            case "sir":
                likelyGender = "M";
                break;
            case "mr":
                likelyGender = "M";
                break;
            case "master":
                likelyGender = "M";
                break;
            default:
                likelyGender = "F";
                break;
        }
        return likelyGender;
    }
/*the above case statement can be re-written like this, **if we want to run this,
* make sure to change the calling method*/

public String likleyGenderIsRefactored (String title){
        String likelyGender;

     switch (title.toLowerCase()){
         case "sir":
         case "mr":
         case "master":
         likelyGender = "M";
                     break;
         default:
             likelyGender = "F";
             break;
     }
     return likelyGender;


    }



}