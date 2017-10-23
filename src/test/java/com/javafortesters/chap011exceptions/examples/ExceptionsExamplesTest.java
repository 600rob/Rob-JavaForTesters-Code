package com.javafortesters.chap011exceptions.examples;

import com.javafortesters.domainentities.interim.exceptions.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by robert.hope on 11/05/2017.
 */
public class ExceptionsExamplesTest {

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
    public void CatchANullPointerException(){

        /* here we will use the try and catch
        keywords in order to handle the exception
         */

        Integer age = null;
        String ageAsString;
        /*note, we have to declare agesAsString here in order for it to be in
        scope for use by the try. the try block is delimited with {} so if we declared
         in inside the curly braces, it would go out of scope for anything after the try block*/
        try {
            ageAsString = age.toString();
        }

        // declare the type of item we want to catch and handle (NullPointerException),
        // also give it an identifier (e)
        //the catch block is designed to catch the null pointer, handle it and allow the rest of the
        //code to execute as normal until completion.
        catch(NullPointerException e){
            age = 18;
            ageAsString =age.toString();
        }

        String yourAge = "you are " + ageAsString + " years old";
        assertEquals("you are 18 years old", yourAge);
/*
general notes:
-Code in the try block will always run.
-The catch block will execute only if the declared exception is thrown.
-Exceptions that are thrown in the catch block will propagate up the stack i.e. to calling methods.
-Exceptions will ONLY be caught If they are of the type declared in the catch block
-If a different exception is thrown then it will NOT be caught ONLY NullPointerException will be caught
in this instance because thats what i specified
-If an exception is thrown within the catch block
then it won’t be re-caught again because there is no try catch statement surrounding it.
*/
    }

    @Test
    public void catchMultipleExceptions(){
        //the catch block can be repeated to catch multiple exception types as shown below
        Integer age=null;
        String ageAsString;

        try{
            ageAsString = age.toString();

        }catch(NullPointerException e){

            age = 18;
            ageAsString = age.toString();

        }catch(IllegalArgumentException e){
            System.out.println("Illegal Argument: " +
                    e.getMessage());
        }

        String yourAge =
                "You are " + age.toString() + " years old";

        assertEquals("You are 18 years old", yourAge);
    }

    @Test (expected = NullPointerException.class)
    /*
    The line above is a JUnit feature which allows us to check for thrown exceptions.
   The feature tells the test method to expect an exception error to be thrown and still let the code run
   and pass.
   If no exception is thrown during execution, then the test method fails

   for example the following code passes because it expects a null pointer. (which is what gets thrown)
     */
    public void nullPointerExceptionExpected(){
        Integer age=null;
        age.toString();
    }

    @Test //(expected = IllegalArgumentException.class)
    public void cantSetUserWithLessThan6CharPassword(){

        new User("rob", "rob1");
    }

    @Test
    public void tryCatchFinallyPseudoCode() {
        /* so we already know about Try and Catch.
        we can add to this something called Finally.
        Finally allows us to ALWAYS execute some code
        If flows like the below psuedo code
         */


        try {
            // try and do something

        } catch (NullPointerException e) {
            // handle the exception here

        } finally {
            // perform the code here
            // regardless of whether an
            // exception was thrown or not
        }
    }


        @Test
    public void tryCatchFinallyANullPointerException(){
            Integer age = null;
            String ageAsString;
            String yourAge;

            try{
                ageAsString = age.toString();

            }

            catch (NullPointerException e) {
                age = 18;
                ageAsString = age.toString();
            }
            finally{
                yourAge = "you are " + age.toString() + " years old";
            }
            assertEquals("you are 18 years old", yourAge);


            /*The finally block is mainly used when we want to re-throw
             an exception, but before we lose control over the code
             execution we want to tidy up resources. * note i could
             just access the ageAsString variable without the finally block
              */

        }

    @Test //(expected = IllegalArgumentException.class)

    /*in this example, instead of fixing the age, we re-throe the NullPointer as and IllegalArgument.
    we create a null pointer in the try block
    in the catch block, we re throw the null pointer as an illegal argument exception.
    if we did not have the finally block, the code would only execute up to the
    illegal argument in the catch block
    ( try commenting out the expected annotation to check)

     */
    public void exampleTryCatchFinally(){
        Integer age=null;

        try{
            System.out.println("1. generate a null pointer exception");
            System.out.println(age.toString());

        }catch(NullPointerException e){
            System.out.println("2. handle null pointer exception");
            throw new IllegalArgumentException
                    ("Null pointer became Illegal", e);
        }finally{
            System.out.println("3. run code in finally section");
        }
    }



}
