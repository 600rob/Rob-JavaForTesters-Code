package com.javafortesters.chap008selectionsanddecisions.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by robert.hope on 19/12/2016.
 */
public class Cats {

    @Test

    public void catOrCats() {

        int numberofcats = 1;

        assertEquals("1==cat", "cat",
                //if statement as a ternary operator
                (numberofcats == 1) ? "cat" : "cats");

        numberofcats = 0;
        assertEquals("0==cats", "cats",
                //if statement as a ternary operator
                (numberofcats == 0) ? "cats" : "cat");

        numberofcats = 2;
        assertEquals("2==cats", "cats",
                (numberofcats==1)? "cat" : "cats");

    }

    @Test
    public void catOrCatsAsMethod(){

        assertEquals("1==cat", "cat",
                //catMethod uses the if statement as a ternary operator in private method
                catMethod(1));


        assertEquals("0==cats", "cats",
                //catMethod uses the if statement as a ternary operator in a private method
                catMethod(0));

        assertEquals("2==cats", "cats",
                catMethod(2));


    }

    private String catMethod(int numberofcats) {
        return numberofcats == 1 ? "cat" : "cats";
    }



}
