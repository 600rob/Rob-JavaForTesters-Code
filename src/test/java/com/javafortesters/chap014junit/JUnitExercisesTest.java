package com.javafortesters.chap014junit;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.core.Is.is;
//import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

/**
 * Created by robert.hope on 05/07/2017.
 */
public class JUnitExercisesTest {

    @Test
    public void junitHasAssertions(){

        assertEquals(6,3+3);
        assertFalse("false is false",false);
        assertFalse(false);
        assertTrue("true is true",true);
        assertTrue(true);

        int [] x = {1,2,3,4,5,6};
        int [] y = {6,5,4,3,2,1};
        Arrays.sort(y);
        assertArrayEquals("array x equals array y",x,y);

        assertNotNull("an empty string is not null","");
        assertNotNull("");


        assertNotSame("an empty string is not null", null,"");
        assertNotSame(null,"");

        assertNull("only null is null", null);
        assertNull(null);

        assertSame("two strings are the same","abcd","abcd");
        assertSame("testing","testing");

    }

    /*
    we can use the assertThat method, in conjunction with matcher's from hamcrest to make
    code more readable. this gives us a more readable output when a test fails in the following format:
    *Note we always use assertThat, the matcher is specified in the method call, for example assertThat(3, is(3));
java.lang.AssertionError:
Expected: is <7>
     but: was <6>
Expected :is <7>
Actual   :<6>

Make this method fail in order to see the fail message

     */




    @Test
    public void assertThatWithHamcrestMatchersWithReason(){
        assertThat("3+3=6",3+3,is(6));
    }
    //rewrite the junit has assers methods, using hamcrest matchers
    @Test
    public void assertThatWithHamcrestMatchers(){
        assertThat(3+3, is(6));

        /* we can also add a reason in the form of a string to make it even more clear like this:

     */


        assertThat(3+3,is(6));
        assertThat(false, equalTo(false));
        assertThat(true, equalTo(true));

        int [] x = {1,2,3,4,5,6};
        int [] y = {6,5,4,3,2,1};
        Arrays.sort(y);
        assertThat("array x equals array y",x,equalTo(y));

        // as shown below you can string together matcher's to make a literate statement

        assertThat("an empty string is not null","",is(not(nullValue())));
        assertThat("", is(not(nullValue())));
        assertThat("", is(notNullValue()));


        assertThat("only null is null", null, is(nullValue()));
        assertThat(null, is(nullValue()));

    }

    @Test
    public void useThelistedHamcrestMatchers(){

        assertThat(true,is(true));
        assertThat(3, is(equalTo(3)));
        assertThat(true, is(not(equalTo(false))));
        assertThat(3, is(not(4)));
        assertThat("this is a test", containsString("a test"));
        assertThat("robert", endsWith("ert"));
        assertThat("robert", startsWith("rob"));

    }
}
