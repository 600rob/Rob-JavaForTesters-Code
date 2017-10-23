package com.javafortesters.chap009arraysanditeration.examples;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by robert.hope on 10/01/2017.
 */
public class ArrayExamplesTest {

    String[] gymdays = {"monday", "tuesday", "thursday", "friday"};


    @Test
    public void simpleArrayExample() {
        String[] numbers0123 = {"zero", "one", "two", "three"};
        for (String numberText : numbers0123) {
            System.out.print(numberText);
            System.out.println();
        }

        assertEquals("zero", numbers0123[0]);
        assertEquals("three", numbers0123[3]);
    }

    @Test
    public void arrayDeclarations() {
        //declare arrays of a fixed size
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        /* it is possible to use square braces after the name
         declaration like so.....
          */
        int array3[] = new int[10];
        String array4[] = new String[5];


        //assign values to a fixed length array
        array4[0] = new String("rob");
        array4[1] = new String("is");
        array4[2] = new String("learning");
        array4[3] = new String("java");
        array4[4] = new String("for testing");


        //declare an array with actual values
        int[] array5 = {1, 2, 3, 4, 5};

        /* declaring the array like this sets the size of the array in the declarartion*/

        // declare array of zero length
        int[] array6 = {};
        //or
        int[] array7 = new int[0];

        // you can declare and array with the name only, and then initialise it later on in the code like this

        int[] array8;
        //....
        // ....
        array8 = new int[10];
        //or create an anonymous array and allocate it to an existing variable like this
        array8 = new int[]{100, 200, 300};

        // access array items using the [i] notation where i is the array index position you want to access like this

        System.out.println(array5[3]);
//or this
        assertEquals("monday is a gym day", "monday", gymdays[0]);
        assertEquals("friday is a gym day", "friday", gymdays[3]);

        String pr4 = "";
        for (String printa4 : array4) {
            pr4 = (pr4 + " " + printa4);
            /*System.out.println(pr4);*/
            /*DONT PUT YOUR PRINT STATEMENT HERE! IF YOU DO YOU WILL
            GET AN OUTPUT SPANNING MULTIPLE LINES FOR EACH ARRAY INDEX. IF YOU NEED A SINGLE LINE
            OUTPUT MAKE SURE THE PRINT STATEMENT IS OUTSIDE THE CURLY BRACE OF THE FOR LOOP.
            THE SAME GOES FOR ANY ASSERT STATMENTS AND STUFF*/
        }
        // MAKE SURE TO PUT PRINTS AND ASSERTS HERE FOR SINGLE LINE OUTPUT
        System.out.println(pr4);
    }


    @Test
    public void forEachLoop() {
        String days = "";
        int dayindex = 0;
        for (String gymday : gymdays) {
            days = days + "|" + gymday;
            /*if we use the local variable gymday for our print statement we get each day
            printed on a new line. This is because there is no operation to increment the
            value of gymday, only to replace it with the next array value. we can use the day
            index value to add a counter to the output result
             */
            //System.out.println(gymday);
            System.out.println("found " + gymday + " at position " + dayindex);
            dayindex++;
        }

        //System.out.println(days);
        //assertEquals("|monday|tuesday|thursday|friday", days);

    }


    @Test
    public void forLoop() {
        String days = "";
        for (int i = 0; i < 4; i++) {
            days = days + "|" + gymdays[i];
        }
        System.out.println(days);
    }

    @Test
    public void forLoopUsingIndexFixedCondition() {
        String days = "";
        for (int i = 0; i < 4; i++) {
            //using variable i in the output string allows me to have an index count against each string item in the output
            days = days + "|" + i + "-" + gymdays[i];
        }
        System.out.println(days);

    }

    @Test
    public void copyOfArrayMethods() {

        /*Using the static method copyOf on Array we can create a copy of an array, and optionally resize it.
The copyOf method takes two arguments: Arrays.copyOf( arrayToCopy , length ); This is typically used
to create a copy and increase the size. When we increase the size, the values in the array, which
were not in the original array, are set to the default value for that data type i.e. 0 for integer
and null for String. In our example if we create a copy of gymdays and resize it from 4 to 6 then
the last two indexes will contain null.*/

        String[] gymdaysCopyResize;
        gymdaysCopyResize = Arrays.copyOf(gymdays, 6);

        //gymdaysCopyResize[4] = "saturday";
        //gymdaysCopyResize[5] = "sunday";

        for (String a : gymdaysCopyResize) {
            System.out.println(a);
        }


        //use copyOf to shorten the array length
        gymdaysCopyResize = Arrays.copyOf(gymdaysCopyResize, 3);
        assertEquals(3, gymdaysCopyResize.length);
        assertEquals("monday", gymdaysCopyResize[0]);
        assertEquals("tuesday", gymdaysCopyResize[1]);
        assertEquals("thursday", gymdaysCopyResize[2]);
/*when we shorten the array, i think it just uses the values of the original array, in sequence
for example when i shortened the array to 3 from 6 indexes, it just assigns the first three index values to
the new array positions
 */

    }

    @Test
    public void copyOfRangeMethods() {
        /*use copyOfRange to make a copy of an existing array and specify the range (size). The range is defined by
the start index and the end position count. ie to copy the first two array positions, we specify index position zero as #
 the start and position count 2 as the end value
 */
        String[] gymdaysCopyRange;

        gymdaysCopyRange = Arrays.copyOfRange(gymdays, 0, 2);
        assertEquals(2, gymdaysCopyRange.length);
        assertEquals("monday", gymdaysCopyRange[0]);
        assertEquals("tuesday", gymdaysCopyRange[1]);


            /*use copy of range to increase the size of an existing array by, specifying the start index and end count position
            that is greater than the source array * remember that increasing the array size assigns new indexes
            the default value. ( null for strings, 0 for ints)

             */

        String[] gymdaysCopyRangeBig;

        gymdaysCopyRangeBig = Arrays.copyOfRange(gymdays, 0, 8);
        assertEquals(8, gymdaysCopyRangeBig.length);
        assertEquals("monday", gymdaysCopyRangeBig[0]);
        assertEquals("friday", gymdaysCopyRangeBig[3]);
        assertEquals(null, gymdaysCopyRangeBig[4]);
        assertEquals(null, gymdaysCopyRangeBig[7]);


    }

    @Test
    public void fillArrayMethods() {

        //fill all array indexes with the same value

        int[] minusOne = new int[20];
        // the fill method takes the array name to fill, and the value that you will use to fill each position
        //like this   Arrays.fill(arrayname, value);
        Arrays.fill(minusOne, -1);

        //fill part of an array: Arrays.fill(arrayname, start index, enditemcount, value);

        int[] tenItems = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        //fill items [5] to [9] with value 1
        Arrays.fill(tenItems, 5, 10, 1);

        //check that items [5] and [9] all contain value 1
        assertEquals(1, tenItems[5]);
        assertEquals(1, tenItems[9]);
        //check items [0] and [4] are not affected

        assertEquals(0, tenItems[0]);
        assertEquals(0, tenItems[4]);

    }


    @Test
    public void sortArraysMethod() {
        //use the sort method to arrange an array where the values are mixed up

        int[] outOfOrder = {10, 2, 6, 3, 7, 0, 5, 9, 1, 4};
        Arrays.sort(outOfOrder);

        assertEquals(0, outOfOrder[0]);
        assertEquals(10, outOfOrder[9]);


        for (int a1 : outOfOrder) {
            System.out.println(a1);
        }

    }

    @Test
    public void createATriangle() {
        int[][] triangle = new int[16][];

        for (int row = 0; row < triangle.length; row++) {
            triangle[row] = new int[row + 1];
            {
                for (int i = 0; i < (row + 1); i++) {
                    triangle[row][i] = i;
                    System.out.print(triangle[row][i]);
                }
                System.out.println();
            }


        }
    }
}







