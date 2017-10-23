package com.javafortesters.chap015stringsrevisited;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by robert.hope on 23/08/2017.
        *
        */
public class StringBuilderExercisesTest {
/*
Write an @ test method which validates that a StringBuilder
        auto resizes when you append more characters then the current capacity
 */
    @Test
    public void canValidateStringBuilderResize(){
        //Set the initial capacity to 10
        StringBuilder builder = new StringBuilder(6);
        //verify the capacity
        assertThat(builder.capacity(),is(6));

        builder.append("hello geezer");

        //verify capacity increase

        assertThat(builder.capacity() >6, is(true));
         //confirm the new capacity
        System.out.println(" new capacity is " + " " + builder.capacity());

    }

    /*
    insert a string into an empty String builder. Do the same in the middle and at the end
     */

    @Test
    public void canInsertIntoStringBuilder(){

        StringBuilder builder = new StringBuilder();
        //insert at start
        builder.insert(0,"123");
        assertThat(builder.length(),is(3));
        System.out.println(builder.length());
//insert at end
builder.insert(3,"789");
        assertThat(builder.length(),is(6));
        System.out.println(builder.length());
//insert at middle
        builder.insert(3,"456");
        assertThat(builder.length(), is(9));
        assertThat(builder.toString(),is("123456789"));
    }


}
