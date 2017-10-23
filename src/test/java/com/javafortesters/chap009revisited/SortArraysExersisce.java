package com.javafortesters.chap009revisited;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by robert.hope on 10/02/2017.
 */
public class SortArraysExersisce {

    @Test
    public void sortArraysMethod(){

        String [] workdays = { "monday", "tuesday", "wednesday", "thursday","friday"};

        Arrays.sort(workdays);

        for(String a  : workdays){
            System.out.println(a);
        }
        assertEquals("friday",workdays[0]);
        assertEquals("monday",workdays[1]);
        assertEquals("thursday",workdays[2]);
        assertEquals("tuesday",workdays[3]);
        assertEquals("wednesday",workdays[4]);

    }

    @Test
    public void createATrinagle () {

        int[][] tri = new int[15][];
        for (int a = 0; a < tri.length; a++) {
            tri[a] = new int[a + 1];

            for (int b = 0; b < a + 1; b++) {
                tri[a][b] = b;

            }

        }
        print2DIntArray(tri);
    }






    public void print2DIntArray(int[][] multi) {
        for (int[] outer : multi) {
            if (outer == null) {
                System.out.print(" null");
            } else {
                for (int inner : outer) {
                    System.out.print(inner + ",");
                }
            }
            System.out.println("");
        }

    }
}
