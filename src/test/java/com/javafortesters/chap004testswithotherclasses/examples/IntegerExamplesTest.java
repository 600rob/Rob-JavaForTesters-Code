package com.javafortesters.chap004testswithotherclasses.examples;

        import org.junit.Test;

        import static org.junit.Assert.assertEquals;

/**
 * Created by robert.hope on 25/11/2016.
 */
public class IntegerExamplesTest {

    @Test
    public void integerExploration(){


        Integer four = new Integer (4);
        Integer five = new Integer ("5");
        Integer six = 6;
        /*line 18 is an example of autoboxing which automatically converts from a primitive type
        into the associated class
        */


        assertEquals("intValue four returns int 4", 4,four.intValue());
        assertEquals("intValue five returns int 5",5, five.intValue());
        assertEquals("autoboxing assignment for 6", 6, six.intValue());


    }
}
