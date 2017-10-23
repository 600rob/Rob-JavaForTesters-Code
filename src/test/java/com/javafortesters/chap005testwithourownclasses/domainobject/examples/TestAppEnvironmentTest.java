package com.javafortesters.chap005testwithourownclasses.domainobject.examples;

        import com.javafortesters.domainobject.TestAppEnv;
        import org.junit.Test;
        import static org.junit.Assert.assertEquals;

public class TestAppEnvironmentTest {


    @Test
    public void canGetUrlStatically(){
        /*line 17 is static import,so is the assert Equals on line 20 and 23
        we imported the assertequals method from juint in line 5. because of this, each time we want
        to use the assertEquals method, we simply type assertEquals in out code. This is an example of static
        import and is seen on line 17
         */
        assertEquals("returns hard coded url", "http://192.123.0.3:67", TestAppEnv.getUrl());
        System.out.println(TestAppEnv.getUrl());
    }

    @Test
    public void canGetDomainAndPortStatically(){
        assertEquals ("just the domain","192.123.0.3",
                TestAppEnv.DOMAIN);
/*line 31 is static usage ( i put the code on a different line from the assert equal us to make it clear)
we import the class TestAppENV in line 3. Because we did not import the class statically, this means that each time we want to
want to use one of the constants, DOMAIN or PORT we must prefix them with the class they come from i.e TestAppEnv.
This is Static usage and can be seen in line 31
 */
        assertEquals
                ("just the port","67",TestAppEnv.PORT);

    }

}
