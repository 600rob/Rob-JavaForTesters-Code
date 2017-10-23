package com.javafortesters.chap009arraysanditeration.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by robert.hope on 30/01/2017.
 */
public class MultiDimensionArrayExamples {


    @Test
    public void createMutliDimensionalArrays() {

        /*2d array.
                We can specify a 2d array with rows and columns using the following declaration:
                */

        int[][] multi = new int[4][4];

        //initialise the array in one statement:
        multi = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};


        /*This declares an array of 4 rows, each column having 4 columns. Which would look like the following:
in effect this is an array consisting of 4 1d arrays
{1,2,3,4}	    array1 [0]
{5,6,7,8}	    array2 [1]
{9,10,11,12}	array3 [2]
{13,14,15,16}	array4 [3]
        */

        // (md = multi dimension array)
        // check the size of the md array ( there are 4 one dimensional arrays)
         assertEquals(4, multi.length);
        //print the size of one of the 1d arrays. ( in this case the one at row position 1)
        System.out.println(multi[1].length);
        //check the size of one of the individual arrays
        assertEquals(4, multi[0].length);

        //access a specific value
        System.out.println(multi[0][3]);

        //check and assert some of the values

        assertEquals(1, multi[0][0]);
        assertEquals(7, multi[1][2]);
        assertEquals(12, multi[2][3]);
        assertEquals(14, multi[3][1]);

        //call the print method and pass in this array as the param

        print2DIntArray(multi);

    }


    @Test
    public void createA3dArray() {
        /*3d array, if we want to create a collection of md arrays
         we can do it with the following notation
          */
        int[][][] multi3d = new int[3][4][5];

        /*This creates three md arrays. each md array is
        made up of 4 separate 1 dimension arrays, each  1 dimension array holds 5 values.
         If we visualise it, it would look like this

          array[0]              array[1]              array[2]
          {0,0,0,0,0}          {0,0,0,0,0}            {0,0,0,0,0}
          {0,0,0,0,0}          {0,0,0,0,0}            {0,0,0,0,0}
          {0,0,0,0,0}          {0,0,0,0,0}            {0,0,0,0,0}
          {0,0,0,0,0}          {0,0,0,0,0}            {0,0,0,0,0}

          */
        //check the number of md arrays
        assertEquals(3, multi3d.length);
        //check the length of of each md array (the number of rows in each)
        assertEquals(4, multi3d[0].length);
        assertEquals(4, multi3d[1].length);
        assertEquals(4, multi3d[2].length);
        //check the length of some single dim arrays
        assertEquals(5, multi3d[0][1].length);
        assertEquals(5, multi3d[0][2].length);
        assertEquals(5, multi3d[1][3].length);


    }

    @Test
    public void createdARaggedArray() {


        /* Ragged Arrays
        Now we know that understand a MD array is and array of arrays we can use this to
create a collection of arrays which have different lengths.
This is called a ragged array
         */

        //create a ragged 2d array

        int[][] ragged2d = {
                {1, 2, 3, 4},
                {5, 6},
                {7, 8, 9},
                {}
        };
//each 1d array has a different length
        //check the lengths of ead 1 d array
        assertEquals(4, ragged2d[0].length);
        assertEquals(2, ragged2d[1].length);
        assertEquals(3, ragged2d[2].length);
        assertEquals(0, ragged2d[3].length);

        // we can define a ragged array dynamically leaving the ragged dimensions blank
        //when we create it like this:

        int[][] ragged2dee = new int[10][];
        /* this gives us an MD array with 10 undefined 1d arrays. We can define
        the length of each array when we initialise them like this
         */

        ragged2dee[0] = new int[10];
        ragged2dee[1] = new int[3];
        //anything that we don't initialise gets the default value of null for an int
        assertEquals(10, ragged2dee[0].length);
        assertEquals(3, ragged2dee[1].length);
// //call the print method and pass in this array as the param

        print2DIntArray(ragged2d);


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

    @Test
    public void createTriangleArray() {

        int[][] triangle = new int[16][];
        for (int row = 0; row < triangle.length; row++) {
            triangle[row] = new int[row + 1];
            for (int i = 0; i < row +1; i++) {
                triangle[row][i] = i;

            }


        }
        print2DIntArray(triangle);

    }
}
