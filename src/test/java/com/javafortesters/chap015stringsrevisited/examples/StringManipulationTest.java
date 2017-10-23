package com.javafortesters.chap015stringsrevisited.examples;

import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by robert.hope on 22/08/2017.
 * Examples of how we can manipulate sdtings in different ways.
 */
public class StringManipulationTest {
    /* the following methods allow is to take a String, and replace elements of
    it with other characters
    -.replace : replaces all matching sub strings with a  new substring
    -.replaceAll - replace all sub strings that match a regex with new substring
    - . replaceFirst - replace the first substring matching the regex with a new subs string
    */

    @Test

    public void canUseReplace(){

        String hello  = "Hello fella fella fella";

        assertThat(hello.replace("fella","World"),
                is("Hello World World World"));

        assertThat(hello.replaceFirst("fella","World"),
                is("Hello World fella fella"));

        assertThat(hello.replaceAll("fella", "World"),
                is ("Hello World World World"));

        // replace numbers with a String
        //Not, we use a regex in out "First instance of" to say the first of any digit 0-9


assertThat("1,2,3".replaceFirst("[0-9]", "digit"),
        is("digit,2,3") );

        assertThat("1,2,3".replaceAll("[0-9]","digit"),
                is("digit,digit,digit"));
    }

    @Test
    public void canUseUpperandLowerCase(){

        //convert Strings to upper or lowecase

        String text = "In The Lower 3rd";

        assertThat(text.toUpperCase(),
                is ("IN THE LOWER 3RD"));

        assertThat(text.toLowerCase(),
                is("in the lower 3rd"));

    }

    @ Test

    public void canRemoveWhiteSpace() {
        /* we can use the trim method to remove white space
        from the start or the end of a string
         */
        String padded = "    trim me    ";
        assertThat(padded.length(), is(15));

        String trimmed = padded.trim();

        assertThat(trimmed.length(), is(7));
        assertThat(trimmed, is("trim me"));

    }
        @Test
        public void canCreateASubstring(){

            /*String has two forms of substring as follows:

substring( int beginIndex) - from an index to the end of the String substring
( int beginIndex, int endIndex) between a start index and an end index
*/
            String digits = "0123456789";
//this returns the characters from ( and including thr 5th) up to the end of the string
 assertThat(digits.substring(5),
                    is("56789"));

//this returns the characters from ( and including thr 5th) up to but NOT including the end index (6)
            assertThat(digits.substring(5,6),
                    is("5"));

        }

        @Test
    public void canUseStringFormat(){

            /*we can use string formatting to avoid the need to concatenate strings all the time.
            instead of having to concatenate strings like this:
           */

            int value = 4;
            String output = "The value " + value + " was used";
            assertThat(output,is("The value 4 was used"));

            // we can use the format method to format the string like this:

            String template = "the value %d was used";
            String formatted = String.format(template,value);

            assertThat(formatted,is("the value 4 was used"));
            System.out.println(formatted);

            /*
            A ‘format’ string is a String with embedded
conversion placeholders for the arguments supplied to String.format . e.g.

%d - means convert the argument to a decimal integer Common placeholders are :
%d - a decimal
%s - a String
             */

            String use = "%s %s ran %d %s";

            assertThat(
                    String.format(use,"Usain", "Bolt", 9,"seconds"),
                    is("Usain Bolt ran 9 seconds"));
            System.out.println(String.format(use,"Usain", "Bolt", 9,"seconds"));

            //the args passed in in the format statement can be specified which
            // place holder we want to use them in using the  %<index>$ notation
            // i.e %2$ would mean the 2nd arg

            String txt = "%4$s %3$d ran %2$s %1$s";

            assertThat(
                    String.format(txt, "fast", "very", 9, "number"),
                    is("number 9 ran very fast"));

            //doing this allows us to re use args in multiple places like so:

            String txt2 = "%2$s %2$s %1$s %4$s %3$d";
            System.out.println (String.format(txt2, "fast", "very", 9, "number"));

            assertThat(
                    String.format(txt2, "fast", "very", 9, "number"),
                    is("very very fast number 9"));

        }

        @Test
    public void canSplitAString(){

            /*the split method allows us to convert a String into an array where each array element is a
            part of the String, delimited by the split argument
             */

            // define a string like this

            String csv = "1,2,3,4,5,6,7,8,9,10";
            //now convert it to an array like this:

            String[] results = csv.split(",");

            //we have now created a 10 element array
            System.out.println(results[0]);
            System.out.println(results[10]);
            assertThat(results.length,is(10));



        }





    }



