package com.javafortesters.chap015stringsrevisited;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by robert.hope on 17/08/2017.
 * Write a method that takes a string and a substring as parameters and returns a List<Integer> where each integer
 * is the location of the substring within the string
 * In other words, findAllOccurrences(" Hello fella", "l") would return a List < Integer > with the values 2,3,8,9
 For bonus points, write a findAllOccurrences method which returns the list in the reverse order
 */
public class AllOccurencesLastIndexOfTest {


    @Test
    public void canFindAllOccurrencesInStringsUsingLastIndexOf(){
        // first thing is to write what we want the code to do, then build any methods around it.

        //we want our method to return a List<Integer> with each Integer representing the position of
        // a substring located within a String.
        // The first thing to do is declare the list
        List<Integer> results;
        //The integer list has not been initialised, so now we need to write a method which will do that for us.
        //* Remember, the method needs to take String params "Hello Fella" and "l"

        results = findAllOccurrences("Hello fella", "l");

        /*At this stage now need to go off and create a private method that will create our results list before we
        can run our assert statements.
        * See private List<Integer> findAllOccurrences method for the details */


        System.out.println(results);
            /*assertThat(results.size(), is(4));

            assertThat(results.contains(2), is(true));
            assertThat(results.contains(3), is(true));
            assertThat(results.contains(8), is(true));
            assertThat(results.contains(9), is(true));

            assertThat(results.get(0), is(9));
            assertThat(results.get(1), is(8));
            assertThat(results.get(2), is(3));
            assertThat(results.get(3), is(2));*/
        }



        /* so far, in our @test method, we've have made a call to the method name in order to create an Integer List.
        Now we need to write the code for the method that will actually create that list.
         */
        //In the method declaration declare that the method returns a List<Integer>
        // and that it takes two String params
        private List<Integer> findAllOccurrences(String string,
                String substring) {
//first off, declare the List that we intend to return from this method
            List<Integer> results = new ArrayList<>();
/*
            if(string==null || substring==null){
                throw new IllegalArgumentException("Cannot search using null");
            }

            if(substring.isEmpty()){
                throw new IllegalArgumentException(
                        "Cannot search for Empty substring");
            }*/

// what we need to do now is search through the string and return all index positions
// of any occurrences of the substring that we locate. As  we are doing this in reverse order we need
// to start searching from the end of the string

            // set search to the end of the string
            int lastfoundPosition = string.length();

            do{
                // try and find the substring and use its position in our int variable
                lastfoundPosition = string.lastIndexOf(substring,
                        lastfoundPosition);
                // in the above 2 lines, string is "hello fella", substring is "l" and lastfoundPosition is 10.
                //So in essence the code is doing the following:
                // lastfoundPosition = "hello fella".lastIndexOf("l",
                // 10);

                // if we find the substring
                //*note* remember, if the code cant find the substring, it returns -1
                if(lastfoundPosition!=-1){

                    // add it to the results list
                    results.add(lastfoundPosition);

                    // decrement the next start position. This is  Because we are working through the
                    //string in reverse order so our next position to start from is the one before the one we just used
                    lastfoundPosition--;
                }

                // keep looking through the string until we can't no longer find the substring
            }while(lastfoundPosition!=-1);

            return results;




    }

    //Additional error handling checks
    @Test
    public void worksWhenNothingToFind(){
        List<Integer> results;
        results = findAllOccurrences("Hello fella", "z");
        assertThat(results.size(), is(0));

        results = findAllOccurrences("", "z");
        assertThat(results.size(), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSearchForEmpty(){
        List<Integer> results = findAllOccurrences("", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSearchForNullString(){
        List<Integer> results = findAllOccurrences(null, "hello");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSearchForNullSubString(){
        List<Integer> results = findAllOccurrences("hello", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSearchForNulls(){
        List<Integer> results = findAllOccurrences(null, null);
    }


    }


