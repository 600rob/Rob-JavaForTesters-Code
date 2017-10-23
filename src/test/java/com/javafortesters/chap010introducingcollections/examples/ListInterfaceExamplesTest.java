package com.javafortesters.chap010introducingcollections.examples;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by robert.hope on 10/03/2017.
 */
public class ListInterfaceExamplesTest {

    @Test
    public void getAnElementAtAnIndex(){

        List<String>  days = new ArrayList<>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        // the above format assigns the elements in the order that they are added.

        //With a list we can access the elements of the list by position. this cant be done with a collection

        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday",days.get(1));
       assertEquals("Wednesday", days.get(2));

    }

    @Test
    public void removeElementAtIndex(){
        List<String>  days = new ArrayList<>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        // the above format assigns the elements in the order that they are added.

        //remove an element by its index position. Note, when we remove an element, the list will auto
        // resize. i.e if we remove element 1, the list re-sizes and element 2 moves to position 1

        days.remove(1);

        //Access the elements of the list by position. this cant be done with a collection.
        // * don forget, the list has re-sized!

        assertEquals(2, days.size());
        assertFalse(days.contains("Tuesday"));
        assertEquals("Monday", days.get(0));
        assertEquals("Wednesday",days.get(1));

    }

    @Test
    public void addElementsAtSpecificIndex(){

        /*With a Collection we can add elements, but they are just in the collection,
they could be anywhere, we don’t care.
With an array, we have to resize the array if we want to add new elements.
With a List we can add elements at specific points in the List.
In this example, I start with a partial list of days.

         */

List<String> days = new ArrayList<>();

        // create a partial list of days
        days.add("Tuesday");
        days.add("Thursday");
        days.add("Saturday");

        // at the moment the days added are at positions 0,1,2
        // we can add some more days and assign them a position like this

        days.add(0,"Monday");
        days.add(2,"Wednesday");
        days.add(4,"Friday");
        days.add(6,"Sunday");


        assertEquals(7, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
        assertEquals("Thursday", days.get(3));
        assertEquals("Friday", days.get(4));
        assertEquals("Saturday", days.get(5));
        assertEquals("Sunday", days.get(6));
        // when we add elements in the middle or at the start like we have done above, the action
        // does not overwrite existing elements, it just moves their position and resizes the list.

    }

    @Test
    public void cannotAddElementsOutOfBounds(){

        // when adding to the end of the list we can only add immediately to the end of the list and not beyond
        //the size it would change to. ie if we have a 3 position list (0,1,2) we can add something at position 3 but
        //not position 4 or beyond

        List<String> days = new ArrayList<>();

        days.add("Tuesday");
        days.add("Thursday");
        days.add("Saturday");

        /*
        this would throw an out of bounds exception

        days.add(4,"anyday");
        assertEquals(4, days.size());

         */

        //we have to add directly to the end of the list like this

        days.add(3,"anyday");
        assertEquals(4, days.size());
    }

    @Test
    public void addAllElementsAtspecificPosition(){

        //create a list with two days that get put in position 0 and 1
        List<String> days = new ArrayList<>();
        days.add("monday");
        days.add("friday");

        // we can create another list and add all contents a position in the first list
        List<String> missingDays = new ArrayList<>();

        missingDays.add("tuesday");
        missingDays.add("wednesday");
        missingDays.add("thursday");

        days.addAll(1,missingDays);

        // so we just added the elements from missingDays into days at index 1
        //we can verify the new positions using various asserts

        assertEquals(5,days.size());
        assertEquals("monday", days.get(0));
        assertEquals("tuesday", days.get(1));
        assertEquals("wednesday", days.get(2));
        assertEquals("thursday", days.get(3));
        assertEquals("friday", days.get(4));

        // note, we can also use this method at the start or the end of a list as shown in the two methods below

    }

    @Test
    public void canAddAllElementsInACollectionAtStartIndex(){

        List<String> days = new ArrayList<>();
        List<String> missingDays = new ArrayList<>();

        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");

        missingDays.add("Monday");
        missingDays.add("Tuesday");

        days.addAll(0, missingDays);

        assertEquals(5, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
        assertEquals("Thursday", days.get(3));
        assertEquals("Friday", days.get(4));
    }

    @Test
    public void canAddAllElementsInACollectionAtEndIndex(){

        List<String> days = new ArrayList<>();
        List<String> missingDays = new ArrayList<>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");

        missingDays.add("Thursday");
        missingDays.add("Friday");

        // using addAll without a specified index adds to the end of the list by default.
        //using addAll(days.size() uses the size value as the index position. In the case of
        //days list, the size is 3.
        //Hence the below add action is equivalent to days.addAll(missingDays);
        days.addAll(days.size(), missingDays);

        assertEquals(5, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
        assertEquals("Thursday", days.get(3));
        assertEquals("Friday", days.get(4));
    }

    @Test
    public void findTheIndexOfAnElement(){

        /*
        When we have a List and we don’t know the index of the element
in the list then we can use the indexOf method to tell us where
in the List the element can be found.
         */
        List<String> days = new ArrayList<>();

        days.add("Tuesday");
        days.add("Thursday");
        days.add("Saturday");

        // using the indexOf method will tell us the index position of an element.
        // for example, we want to know the position of Thursday

        System.out.println(days.indexOf("Thursday"));
        assertEquals(2, days.indexOf("Saturday"));

        // If indexOf is used on a list with duplicates, it will return the
        // index value of the first instance of the duplicate. i.e if we
        // had monday at index 0 and index 2, the method would return index 0

    }

    @Test
    public void lastIndexOfTheLastIndexOfAnElement(){

        /* A list can contain duplicate elemants like this:

         */

        List<String > days = new ArrayList<>();

        days.add("monday");
        days.add("tuesday");
        days.add("wednesday");
        days.add("thursday");
        days.add("monday");

        /* we can see that monday is duplicated twice. In this instance
        if we want to find the position of the last instance of monday we can use the lastIndexoOf
        method to tell us the position like this */

        System.out.println(days.lastIndexOf("monday"));

        //or in an assert like this

        assertEquals(4,days.lastIndexOf("monday"));

        // note, if the list has no duplicates then it works the same way as the indexOf method


    }



    @Test
    public void setTheElementAtAnIndex(){
        /*the set method allows us to set and overwrite the contents at a particular
        index position in a list like this:*/

        List<String> days = new ArrayList<>();

        days.add("monday");
        days.add("thursday");
        days.add("wednesday");

        // use set to change thursday to tuesday

        days.set(1,"tuesday");

                assertEquals("index 1 is tuesday", "tuesday", days.get(1) );
        //overwriting does not change the size or order of the list
    }

    @Test
    public void sublistToCreateAPortiaonOfAList(){
        /* it we have and existing list and want to create a new list
        from it with only some of the items from the parent list use the sublist method. Like this:
         */

        List<String> days = new ArrayList<>();

        days.add("monday");
        days.add("tuesday");
        days.add("wednesday");
        days.add("thursday");
        days.add("friday");
        days.add("saturday");
        days.add("sunday");

        // so we want to make a new list from the above list containing only monday-friday.
        // this is how to do it:

        List<String> workdays = new ArrayList<>(days.subList(0,5));

        assertEquals(5, workdays.size());
        assertEquals("monday", workdays.get(0));
        assertEquals("friday", workdays.get(4));



    }

}
