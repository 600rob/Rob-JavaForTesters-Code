package com.javafortesters.chap015stringsrevisited.examples;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by robert.hope on 18/08/2017.
 */
public class RegexMatchesTest {
    /*a regular expression, or a regex is a string where some of the
    characters have a special meaning. i.e wild cards etc.
    we can use the matches method, in combination with a regex to do things like
    check.... does this regex match this string?

     */

    @Test
    public void checkMatchesFunction(){

        /* here we can write a regex and use it to match against a String in order tyo see if that String
        contains any digits. see below line of code
         */
        String mustIncludeAdigit = ".*[0123456789]+.*";

        /* this regex declaration can be broken down as follows:

        . means match any single character
        * means match zero or more of the preceding element
        [] matches any single character in the square brackets
        + means match 1 or more of the preceding element


using the above against our regex,
it basically means the following

.* - match 0 or more characters
[0123456789] + - until we find 1 or more of the following characters “0123456789”
.* - which can be followed by 0 or more characters

*/

        // we can now call the matches method on the string variable

//if any of the regex matches the string it returns true
        assertThat("123456".matches(mustIncludeAdigit),is(true));
        assertThat("1nvalid".matches(mustIncludeAdigit),is(true));

        //if the regex does not match the string, the method returns false
        assertThat("invalid".matches(mustIncludeAdigit),is(false));
        assertThat("Invalid".matches(mustIncludeAdigit),is(false));

    }
}
