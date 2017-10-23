package com.javafortesters.chap0016random.examples;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by robert.hope on 04/09/2017.
 */
public class MathRandomTest {

    @Test
    public void canUseRandomMethodOnMath() {

        double rnd = Math.random();

        System.out.println(
                String.format(
                        "generated %f as random number", rnd));

        assertThat(rnd < 1.0d, is(true));
        assertThat(rnd >= 0.0d, is(true));

        //note, writing d at the end of the number is a way of writing a double literal


    }

}