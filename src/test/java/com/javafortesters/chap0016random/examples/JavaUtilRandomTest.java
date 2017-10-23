package com.javafortesters.chap0016random.examples;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by robert.hope on 05/09/2017.
 */
public class JavaUtilRandomTest {

        /*
    java.util.random
    The java.util.random package provides methods to generate random values as follows:
    -boolean
    nextBoolean - return either true or false
    -long
    nextLong - return a random long value
    -int
    nextInt - random int over the range of all Integer values
    nextInt( int below) - random int greater than or equal to 0 and less than below
    -double
    nextDouble - flat distribution where each value between 0.0 and 1.0 has equal chance of being returned
    -nextGaussian - a Gaussian distribution with a mean of 0.0 and a standard deviation of 1.0,
    meaning about 70% values hovering around the 0.0 mark (+ or - 1.0)
    -float
    nextFloat - random float greater than or equal to 0.0 and less than 1.0
    -byte[]
    nextBytes - fill a given byte[] with random bytes. */

    //To use the above methods we first have to instantiate a Random object as follows:

    @Test
    public void canUseRandomMethods() {

        Random generate = new Random();

        // now we have a random object we can call any of the random methods against
        //our object. we do this by first creating a new instance of each data type, then calling the
        //required method against it like so:

        boolean randomBoolean = generate.nextBoolean();
        long randomLong = generate.nextLong();
        int randomInt = generate.nextInt();
        int randomIntRange = generate.nextInt(12); // generates a random in less or equal to the param passed in
        double randomDouble = generate.nextDouble();
        double randomGaussian = generate.nextGaussian();

        byte[] bytes = new byte[generate.nextInt(100)];
        // fill bytes with random data
        generate.nextBytes(bytes);
        Assert.assertNotNull(generate);
/*int i;
        for ( i=0 ; i<100; i++){
       int randomIntRange = generate.nextInt(12);
       System.out.println(randomIntRange);
       }*/

    }



    /*nextInt( int below)

When generating a random int we can specify the upper range for the generation. nextInt( int below)
This generates random ints between and less than the value specified. for example:

int ranInt = generate.nextInt(5);

Would generate a random int greater than or equal to 0 and between 4 but less than 5

If we want to use nextInt to generate an integer from a specific number, e.g. 1 instead of 0 then we have to
 use an algorithm as follows:

- calculate the range of numbers
- add 1 to this, since the nextInt maximum is one less than desired
-and add the start number.
 e.g. int minValue = 1; int maxValue = 5; int randomIntRange = generate.nextInt( maxValue - minValue + 1) + minValue;
*/

    @Test
    public void generateRandomIntGivenRangeNot0() {
        Random generate = new Random();

        int minValue = 1;
        int maxValue = 5;
        int i;
        for (i = 0; i < 20; i++) {
            int randomIntRange = generate.nextInt(
                    maxValue - minValue + 1) + minValue;
            assertThat(randomIntRange <= maxValue, is(true));
            assertThat(randomIntRange >= minValue, is(true));
            System.out.println(randomIntRange);
        }
    }

    @Test
    public void canCreateRandomGaussian() {

        //just a quick test to see what the hell a gaussian is?
        Random rang = new Random();
        int i;

        for (i = 0; i < 100; i++) {

            double randomgaussioan = rang.nextGaussian();
            System.out.println(randomgaussioan);
        }

    }


    /* seeding random numbers:

    The random numbers are ‘pseudo random’ because they are based on a ‘seed’,
     and each call to ‘random’ is deterministic if the ‘seed’ is controlled.

    For example: Random generate = new Random( 1234567L);
     Would generate a random number generator where the nextInt returns 1042961893


    This is useful when you want to make method execution repeatable.
     e.g. if at the start of a run you seed the Random with the current date time,
      then if you log the date and time, you could repeat the run exactly,
      even if random data was used.

      */
//For Example:
    @Test
    public void canSeedWithCurrentDateTime() {
        long currentSeed = System.currentTimeMillis();
        System.out.println(" seed used: " + currentSeed);
        Random generate = new Random(currentSeed);

        //If the System.out.println was a logging call,
        // then I could recreate the run by seeding random with the seed value logged in the output.

    }

    /*A crude way to generate random strings is to build a String by randomly adding a valid character to the String.
    For Example if I want to build a String from the uppercase letters and space:

     */

    @Test
    public void generateARandomCharExample() {

        String validValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";

        //then i can randomly select a character from that String

        Random random = new Random();
        // below, we use the length of validValues (27) as a seed when generating
        // or ranIndex
        int rndIndex = random.nextInt(validValues.length());
        System.out.println(" choose index position " + rndIndex + " as our random letter from String validValues");
        //Next, set the value of rChar to a position equal to the value of the rndIndex
        // within our String validValues
        char rChar = validValues.charAt(rndIndex);

        if (rChar != ' ') {
            Assert.assertTrue(rChar >= 'A');
            Assert.assertTrue(rChar <= 'Z');
            System.out.println("letter " + rChar + " is equivalent to rndIndex position "
            + rndIndex + " in String validValues");

            // ive printed out the rndIndex to make the code
            // and out pur a bit easier to understand
        }

    }
}





