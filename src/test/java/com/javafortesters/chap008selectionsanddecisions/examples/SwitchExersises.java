package com.javafortesters.chap008selectionsanddecisions.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by robert.hope on 05/01/2017.
 */
public class SwitchExersises {


    @Test

    public void callReturnCountry() {

        assertEquals("country is united kingdom", "United Kingdom", returnCountry("uK"));
        assertEquals("country is united states", "United States", returnCountry("usA"));
        assertEquals("country is united states", "United States", returnCountry("us"));
        assertEquals("country is france", "France", returnCountry("fR"));
        assertEquals("country is sweden", "Sweden", returnCountry("se"));

        assertEquals("country is Rest of world", "Rest of world", returnCountry("Es"));
        assertEquals("country is Rest of world", "Rest of world", returnCountry("pl"));

    }


    private String returnCountry(String region) {
        String country;

        switch (region.toUpperCase()) {
            case "UK":
                country = "United Kingdom";
                System.out.println(country);
                break;

            case "US":
            case "USA":
                country = "United States";
                System.out.println(country);
                break;

            case "FR":
                country = "France";
                System.out.println(country);
                break;

            case "SE":
                country = "Sweden";
                System.out.println(country);
                break;

            default:
                country = "Rest of world";
                System.out.println(country);
                break;
        }
        return country;
    }

    @Test

    public void callReturnNumbersOneToFour() {
        assertEquals("result is One", "One", returnNumbersOneToFour(1));
        assertEquals("result is One", "Two", returnNumbersOneToFour(2));
        assertEquals("result is One", "Three", returnNumbersOneToFour(3));
        assertEquals("result is One", "Four", returnNumbersOneToFour(4));
        assertEquals("resuly is too big", "too big", returnNumbersOneToFour(5));
       assertEquals("result is too small", "too big", returnNumbersOneToFour(Integer.MAX_VALUE));
        assertEquals("result is too small", "too small", returnNumbersOneToFour(-1));
        assertEquals("result is too small", "too small", returnNumbersOneToFour(0));
        assertEquals("result is too small", "too small", returnNumbersOneToFour(Integer.MIN_VALUE));
    }

    private String returnNumbersOneToFour(int a) {

        String result ="";

        switch (a) {
            case 1:
                result = "One";
                System.out.println(result);
                break;

            case 2:
                result = "Two";
                System.out.println(result);
                break;
            case 3:
                result = "Three";
                System.out.println(result);
                break;
            case 4:
                result = "Four";
                System.out.println(result);
                break;

            default:
                if (a < 1) {
                    result = "too small";
                    System.out.println(result);
                }
                if (a > 4) {
                    result = "too big";
                    System.out.println(result);
                }
                break;
        }
        return result;
    }

    @Test

    public void integerSwitch() {
        assertEquals("result is One", "One", integerString(1));
        assertEquals("result is One", "Two", integerString(2));
        assertEquals("result is One", "Three", integerString(3));
        assertEquals("result is One", "Four", integerString(4));
        assertEquals("resuly is too big", "too big", integerString(5));
        assertEquals("result is too small", "too big", integerString(Integer.MAX_VALUE));
        assertEquals("result is too small", "too small", integerString(-1));
        assertEquals("result is too small", "too small", integerString(0));
        assertEquals("result is too small", "too small", integerString(Integer.MIN_VALUE));
    }

    private String integerString(int a) {

        String result ="";

        switch (a) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";

            default:
                if (a < 1) {
                    return "too small";
                }

                if (a > 4) {
                    return "too big";
                }
                return "";
        }
    }
}













