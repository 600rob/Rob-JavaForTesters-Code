package com.javafortesters.chap008selectionsanddecisions.examples;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by robert.hope on 04/01/2017.
 */
public class NestedIfElseHorror {

    @Test

    public void nestedIfElseHorror() {
        horrorOfNestedIfElse(true, true);
        //horrorOfNestedIfElse(true, false);
        //horrorOfNestedIfElse(false, true);
        //horrorOfNestedIfElse(false, false);
    }

    public void horrorOfNestedIfElse(boolean truthy, boolean falsey) {

        if (truthy){
            if(!falsey){
                if (truthy && !falsey){
                    if(falsey || truthy){
                        System.out.println("T|F");
                        assertTrue(truthy);
                        assertFalse(falsey);
                    }
                }
            }
            else{
                System.out.println("T|T");
                assertTrue(truthy);
                assertTrue(falsey);
            }
        }

        else{
            if(!truthy){
                if(falsey){
                    System.out.println("F|T");
                    assertTrue(falsey);
                    assertFalse(truthy);
                }

                else{
                    System.out.println("F|F");
                    assertFalse(falsey);
                    assertFalse(truthy);
                }
            }
        }


    }

}
