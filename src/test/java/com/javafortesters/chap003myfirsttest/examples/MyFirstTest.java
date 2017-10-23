package com.javafortesters.chap003myfirsttest.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyFirstTest {
@Test
    public void canAddTwoPlusTwo(){
int answer = 2+2;
    assertEquals("2+2=2", 4, answer);

    }

    @Test
    public void canSubtractTwofromEight(){
        int answer = 8-2;
        assertEquals("8-2=6",6, answer);

    }


}



