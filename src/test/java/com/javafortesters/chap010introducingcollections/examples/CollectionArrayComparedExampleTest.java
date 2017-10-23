package com.javafortesters.chap010introducingcollections.examples;

import org.junit.Test;
import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by robert.hope on 10/02/2017.
 */
public class CollectionArrayComparedExampleTest {

    String[] someDays = {"Tuesday", "Thursday", "wednesday",
            "Monday", "Saturday", "Sunday", "Friday"};

    List<String> days = Arrays.asList(someDays);


    @Test
    public void simpleCollectionExample() {

        //create a normal String array and convert it to a list
        String[] numbers0123Array = {"zero", "one", "two", "three"};
        //convert it to a list using Arrays.aslist method. Note when converting the string to a list
        // the list takes a new name
        List<String> numbers0123 = Arrays.asList(numbers0123Array);

        for (String numberText : numbers0123) {
            System.out.println(numberText);

            assertEquals("zero", numbers0123.get(0));
        }
    }

    @Test
    public void simpleDynamicCollection() {
        // create a list from scratch. note, the list size is not defined so we can build the list as we go.
        //* lists are not defined by size so we can add as many elements as required.
        List<String> numbers0123 = new ArrayList<>();

        //add string values to the list. * note, the string values are added in the order
        //that i declare them. Also the list re-sizes each time i declare a new item so we dont need to
        // specify a size when we declare the list

        numbers0123.add("Zero");
        numbers0123.add("one");
        numbers0123.add("two");
        numbers0123.add("three");
// check and assert the values in some positions of the list

        for (String numberText : numbers0123) {
            System.out.println(numberText);
        }


        assertEquals("three", numbers0123.get(3));


    }

}












