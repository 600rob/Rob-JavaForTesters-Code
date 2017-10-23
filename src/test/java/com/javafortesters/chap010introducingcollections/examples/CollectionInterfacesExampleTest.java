package com.javafortesters.chap010introducingcollections.examples;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by robert.hope on 03/03/2017.
 */
public class CollectionInterfacesExampleTest {

    @Test
    public void instantiatingACollection() {
        Collection workdays;
        workdays = new ArrayList();
/*
In the above code we have a usable variable called workdays.
But a collection can contain any object, and since we didn’t
specify what the collection will contain it defaults to object.
This will become an annoyance later when we try and iterate through the
 collection and have to cast the elements from object to String.
 As a recommendation, when you work with a collection, and the objects to be
 stored in the collection are all of the same type then declare the
 collection as a collection of type e.g.

 */

        Collection<String> weekendDays = new <String>ArrayList();

        Collection<String> daysOfWeek = new ArrayList<String>();
        // Note, how we can write <colletiontype> before or after the implementation class
        // we can also use the following syntax:

        Collection<String> days = new ArrayList<>();
        // in this syntax, the compiler will use the generic value from the variable declaration
        //which is a string

        //Adding elements to a collection. do this in a separate method called setUpWorkDays
        setUpWorkDays(workdays);


        //we can use the addAll method to add the elements from one collection into another
        // again, do this in a separate method called addAllWorkdaystoDaysOfWeek
        addAllWorkdaystoDaysOfWeek(workdays, daysOfWeek);
        //again we will use a separate method to fill weekend days with elements
        setUpWeekendDays(weekendDays);

        /*now we have set up our three collections we can use collection methods to add and remove them from
        each other*/

        //lets add the weekend days into daysOfWeek

        daysOfWeek.addAll(weekendDays);
        //check the size and contents of days of week
        assertEquals(7, daysOfWeek.size());
        assertTrue(daysOfWeek.containsAll(weekendDays));

        assertEquals(daysOfWeek.size(),
                workdays.size() + weekendDays.size());
    }


    public void addAllWorkdaystoDaysOfWeek(Collection workdays, Collection daysOfWeek) {
        //first check that the target collection is empty
        assertEquals(0, daysOfWeek.size());
        // add element from workdays into days of week
        daysOfWeek.addAll(workdays);
        // the size method can be used to count the number of elements in the collection. here we are asserting that
        // the size of one collection is the same as the other
        assertEquals(workdays.size(), daysOfWeek.size());
        System.out.println(daysOfWeek);

        //we can do something similar using containsAll to check that one list contains all the same elements as another
        assertTrue(daysOfWeek.containsAll(workdays));

        //NOTE: the list that we call the containsAll method on (i.e daysOfWeek) can contain more elements than the list we
        //compare it against. As long as all of the elements are there then the assert will return true

    }

    public void setUpWorkDays(Collection workdays) {
        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");

        assertEquals(5, workdays.size());
        /*Note. when we add elements to a collection they dont get added to the collection a specific position....
        they are just in the collection but their position is not defined. In order be able to define/determine the element position
        we have to use the list interface as it behaves more like an array.


         */

    }

    private void setUpWeekendDays(Collection weekendDays) {
        weekendDays.add("Saturday");
        weekendDays.add("Sunday");

    }

    @Test
    public void canAddAndRemoveFromCollection() {

        Collection<String> weekEndDays = new ArrayList<>();

        weekEndDays.add("Sundday");
        weekEndDays.add("Funday");
        assertTrue("weekendDays contains bug Funday",
                weekEndDays.contains("Funday"));
        //oops, spot the deliberate mistake...we added Funday instead of Sunday. Use the remove method to fix it

        weekEndDays.remove("Funday");
        assertFalse(weekEndDays.contains("Funday"));
        //Add the correct day and check it
        weekEndDays.add("Sunday");
        assertEquals(2, weekEndDays.size());
        assertTrue(weekEndDays.contains("Sunday"));

    }

    @Test

    public void iterateOverCollection() {
        //lets set up a few collections that we will use to implement the iterable interface
        //then create some loops

        //NOTE how we do not declare a collection type for workDays this is an object collection
        Collection workDays = new ArrayList();
        //NOTE how we DO declare a collection type for wthe following two collections
        //these are is an String collections
        Collection<String> daysOfWeek = new ArrayList<>();
        Collection<String> weekEndDays = new ArrayList<>();

        setUpWorkDays(workDays);
        setUpWeekendDays(weekEndDays);

        //add all work days and weekdays into daysOfWeek
        daysOfWeek.addAll(workDays);
        daysOfWeek.addAll(weekEndDays);
        // now that we've added all the days into days of week, lets iterate over them,
        // to collect and print all 7 days using an for each loop. we can do this easily with a collection
        //that has been delcared with a type. ie a String collection

        for (String allDays : daysOfWeek) {
            System.out.println(allDays);
        }

    /*Now if we want to iterate over an undeclared collection, it is not so straight forward.
    we have to do something called casting. We have to declare our collector as an object
     In this case the collector is called anyday. we cant print an object, so we have to cast it to a string
     using the (String) notation*/

        for (Object anyday : workDays) {
            String outputDay = (String) anyday;
            System.out.println(outputDay);
        }

    }


    @Test

    public void clearCanEmptyACollection() {
        Collection<String> daysOfWeek = new ArrayList<String>();

        Collection<String> workdays = new <String>ArrayList();
        Collection<String> weekendDays = new <String>ArrayList();

        setUpWorkDays(workdays);
        setUpWeekendDays(weekendDays);

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);
        assertEquals(7, daysOfWeek.size());

        // clear the entire contents of the collection
        daysOfWeek.clear();
        // Check its empty using a few methods
        assertEquals(0, daysOfWeek.size());
        assertTrue(daysOfWeek.isEmpty());
    }

    @Test
    public void canClearContentsOfOnecollectionfromAnother() {

        Collection<String> workDays = new ArrayList<>();
        Collection<String> daysOfWeek = new ArrayList<>();
        Collection<String> weekendDays = new ArrayList<>();

        setUpWeekendDays(weekendDays);
        setUpWorkDays(workDays);

        daysOfWeek.addAll(weekendDays);
        daysOfWeek.addAll(workDays);
        assertEquals(7, daysOfWeek.size());
        // at this point, daysOfWeek contains the elements from weekDays and WeekEndDays.
        // lets remove one of those collections

        daysOfWeek.removeAll(weekendDays);
        assertEquals(5, daysOfWeek.size());
        assertTrue(!daysOfWeek.containsAll(weekendDays));
    }

    @Test
    public void canRemoveAllButOneCollectionFromAnother() {
        Collection<String> workDays = new ArrayList<>();
        Collection<String> daysOfWeek = new ArrayList<>();
        Collection<String> weekendDays = new ArrayList<>();

        setUpWeekendDays(weekendDays);
        setUpWorkDays(workDays);

        daysOfWeek.addAll(weekendDays);
        daysOfWeek.addAll(workDays);
        assertEquals(7, daysOfWeek.size());
        // at this point, daysOfWeek contains the elements from weekDays and WeekEndDays.
        // lets remove all but one of those collections

        daysOfWeek.retainAll(weekendDays);

        assertEquals(2, daysOfWeek.size());
        assertFalse(daysOfWeek.containsAll(workDays));
    }

    @Test
    public void canConvertCollectionToArray() {

        Collection<String> workdays = new <String>ArrayList();
        Collection<String> weekendDays = new <String>ArrayList();
        Collection<String> daysOfWeek = new <String>ArrayList();

        setUpWorkDays(workdays);
        setUpWeekendDays(weekendDays);

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        assertEquals(weekendDays.size() + workdays.size(), daysOfWeek.size());


        /* we can use the toArray Method in two formats.
        with no args,like this
        toArray()
         /*when we use the first option it will return an array of Type Object  */

        Object[] daysOfWeekArray = daysOfWeek.toArray();
        //check the array is the correct size
        assertEquals(7, daysOfWeekArray.length);

        //If we want to use element from the array, we have to cast them to a string
        assertEquals("Monday".length(),
                ((String)daysOfWeekArray[0]).length());

        /*the other option is to use the toArray method with arguments and define the array type
        as a String like this*/

        String[] anotherArray = new String[daysOfWeek.size()];
        //Q: why do we put daysOfWeek.Size??? a: because this defines the size of the array

        daysOfWeek.toArray(anotherArray);
        // now we dont need to use casting to access contents of the array
        assertEquals("Monday".length(),
                anotherArray[0].length());

        /* note "Monday".length is a method on the string in the collection, Not the array

         */


    }

}







