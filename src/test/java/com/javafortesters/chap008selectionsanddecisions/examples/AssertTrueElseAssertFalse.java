package com.javafortesters.chap008selectionsanddecisions.examples;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by robert.hope on 20/12/2016.
 */
public class AssertTrueElseAssertFalse {

    @Test
    public void trueIfTrue() {
        boolean truthy = true;
        if (truthy)
            assertTrue("true", truthy);
//if we are only using one statment we dont need curly braces

        if (truthy) {
            assertTrue("true", truthy);
            assertFalse("false", !truthy);
        }

// more than one statement needs to be blocked out with curly braces. multiple statements
// can go in one block.
    }

    @ Test
    public void assertTrueElseAssertFalse(){
        boolean truthy = false;
        if (truthy)
            assertTrue("true",truthy);
        else
            assertFalse("false", truthy);
    }

    @Test
    public void assertTrueelseAssertFalse(){

        boolean truthy = true;
        if (truthy){
            assertTrue("true", truthy);
            assertFalse("false", !truthy);}
        else
        assertFalse("false", truthy);
    }



}