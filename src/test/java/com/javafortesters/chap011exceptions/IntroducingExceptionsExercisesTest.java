package com.javafortesters.chap011exceptions;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by robert.hope on 12/05/2017.
 */
public class IntroducingExceptionsExercisesTest {

    @Test
    public void throwANullPointerException(){
/* ive deliberately given the age variable a null value
 in order to trying to create a null pointer exception.
 we can fix it by assigning the correct value to the variable
  */
        Integer age = null;

        String ageAsString = age.toString();

        String yourAge = "you are " + ageAsString + " years old";
        assertEquals("you are 18 years old", yourAge);

    }

    @Test
    public void fixTheNullPointerException(){
//simply assign a valid value for the age variable and the code will run with our errors
        Integer age = 18;

        String ageAsString = age.toString();

        String yourAge = "you are " + ageAsString + " years old";
        assertEquals("you are 18 years old", yourAge);

    }


    @Test
    public void CatchANullPointerException(){

        /* here we will use the try and catch
        keywords in order to handle the exception
         */

        Integer age = null;
        String ageAsString;
        /*note, we have to declare ages as string here in order for it to be in
        scope for all of the code */
        try {
            ageAsString = age.toString();
        }


        catch(NullPointerException e){
            age = 18;
            ageAsString =age.toString();
        }

        String yourAge = "you are " + ageAsString + " years old";
        assertEquals("you are 18 years old", yourAge);

    }




    @Test
    public void TryToCatchAnUnspecifiedException(){

        /* here we will use the try and catch
        a different exception with out specifying  in the catch block
         */

        Integer age = null;
        String ageAsString;

        try {
            ageAsString = age.toString();
        }


        catch(ArithmeticException e){
            age = 18;
            ageAsString =age.toString();
        }
        /* we've attempted to catch an exception that will not get thrown. Hence
        we'll get a null pointer exception as there is no error handling in place
         */

        String yourAge = "you are " + ageAsString + " years old";
        assertEquals("you are 18 years old", yourAge);

    }



    @Test
    public void DontHandleTheExceptionInTheCatchBlock() {

        /* We will use a try & catch block but the catch block
        will deliberately NOT handle the null pointer by removing the age from the catch block
         */

        Integer age = null;
        String ageAsString;

        try {ageAsString = age.toString();
        }
        // comment out the age statement to see what happens
        catch (ArithmeticException e) {
            //age = 18;
            ageAsString = age.toString();
        }

        String yourAge = "you are " + age.toString() + " years old";
        assertEquals("you are 18 years old", yourAge);

        /*in this example, the catch block cant find an arithmeticException.
        as a result we get the null pointer that occurs.
         */

    }


/*


    @Test
    public void TryToCatchACheckedException(){

        //here we will use the try and catch on
        //a checked exception.


        Integer age = null;
        String ageAsString;

        try {
            ageAsString = age.toString();
        }


       catch(NoSuchMethodException e){
            age = 18;
            ageAsString =age.toString();
       }

       // When we attempt to catch NoSuchMethodException it triggers an syntax error on
       //ln 145.
        //NoSuchMethodException is a checked exception and needs to be declared as thrown
        //by methods. The toString method does not declare that it will throw a NoSuchMethodException
        //so I receive a syntax error. NullPointerException and ArithmeticException are unchecked
        //exceptions and don’t need to be declared as thrown by methods.

    String yourAge = "you are " + ageAsString + " years old";
        assertEquals("you are 18 years old", yourAge);

    }
    */









    @Test
    public void UseExceptionAsAnObject(){

        /*in my catch block I declared a parameter e as a NullPointerException.
This means that within the catch block I have access to a local variable e.
we could call this variable whatever you want, a lot of people stick with e as a convention.

e is an object of type NoSuchMethodException
so I have access to a variety of methods on this exception. A few are as follows

getMessage - shows me the error message associated with the exception so I can log it

getStackTrace - an Array of StackTraceElement object with method calls that reveal
the lines of code which led up to the throwing of the exception, which can help with debugging

printStackTrace - which prints the stack trace to the error output stream - typically your console or command line
        */

        Integer age = null;
        String ageAsString;

        try {
            ageAsString = age.toString();
        }
        catch (NullPointerException e){
            //System.out.println("getMessage - " + e.getMessage());
            //System.out.println("getStackTrace - " + e.getStackTrace());
            //System.out.println("printStackTrace");
            //e.printStackTrace();


                   /*From this I can see that getMessage on a NullPointerException
 does not return a message, so we need to use the stack trace
 to figure out what went wrong. Other exceptions do return messages,
 and when you start creating your own exceptions, I recommend
 that you add a message to make it easier for other people to
 understand the problem in the code.*/

            /* getStackTrace returns an array of StackTraceElement Objects
            so we could access am element ie [0] which would be the most recent item
            in the stack trace. Like this
            */

            System.out.println(e.getStackTrace()[0]);

            /*in addition to normal array methods lie dot length
            we also have access to the following methods: getClassName, getFileName,
            getLineNumber,getMethodName so we can also find out information about a particular stack
            trace element like this:
           */
            //print the entire stack trace array length
            System.out.println(e.getStackTrace().length);
            //print the class name of a stack element
            System.out.println(e.getStackTrace()[0].getClassName());
            //print a stack trace element file name
            System.out.println(e.getStackTrace()[0].getFileName());
            //print a stacktrace element line number
            System.out.println(e.getStackTrace()[0].getLineNumber());
            //print a stacktrace element method name
            System.out.println(e.getStackTrace()[0].getMethodName());



        }



    }



}
