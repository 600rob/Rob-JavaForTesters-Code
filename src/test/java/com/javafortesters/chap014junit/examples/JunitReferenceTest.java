package com.javafortesters.chap014junit.examples;

import com.javafortesters.domainentities.interim.exceptions.custom.InvalidPassword;
import com.javafortesters.domainentities.interim.exceptions.custom.User;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by robert.hope on 04/07/2017.
 */
public class JunitReferenceTest {


    /*J unit allows us to us before and after annotations which can be used to execute code
    before or after tests get run in order to do things like set up/tear down etc.

    @BeforeClass - runs once before any@test Methods
    @AfterClass - runs once after all test methods
    @Before - runs before each @test method
    @After - runs after each @test method
    */
// Any @beforeClass or @AfterClass must be declared a Static method
    @BeforeClass
    public static void runOnceBeforeClassForAnyTests(){
        System.out.println("BeforeClass Method");
    }

    // @Before or @After do not need to be static
    @Before
    public void runBeforeEveryTestMethod(){
        System.out.println("@before each Method");
    }

    // in order for a method to be recognised as a test we have to annotate it with @Test

    @Test
    public void thisMethodWillNeverFail(){
    }

    /*a method will fail if an exception is thrown. Junit allows us to check for exceptions
    and make the test pass when and exception gets thrown. i.e
    */

    @Test (expected=InvalidPassword.class)
        public void expectInvalidPasswordException()throws
        InvalidPassword{
            User user = new User("user", "<6");
        }

        /*On the other hand we can use a Fail method from junit in order to make a method fail like this
         */

        @Test
        public void failWithDescription(){
            fail("make this test fail even if it passes");
            assertEquals(3,2+1);

        }
        // we can even make if fail with out the method doing anything other tan failing
    @Test
    public void failWithOutDescription() {
        fail();
    }




    /* If we don't want a test to run we can annotate it with @ Ignore like this:
     note this only works when running the entire class is worth adding a comment
     next to the ignore annotation so you know what it is ignored. Also, before or after methods
     do not get called for ignored methods
      */

    @Ignore
    @Test
    public void thisTestIsIgnored(){
        throw new NullPointerException();
    }

    @Ignore("because it is not finished yet")
    @Test
    public void thisTestIsNotFinished(){
        System.out.println("if this prints then you've made a mistake!");
    }

        //@Before and @AfterClass methods will always run regardless of whether a preceding method passes or fails
        @After
    public void runAfterEveryTestMethod(){
            System.out.println("@after each test method");
        }

        @AfterClass
    public static void runOncePerClassAfterAllTests(){
            System.out.println("@Afterclass Method");
        }
}
