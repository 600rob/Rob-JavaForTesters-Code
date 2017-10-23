package com.javafortesters.chap001basicsofjava.examples.classes;

import org.junit.Test;

/**
 * Created by robert.hope on 08/12/2016.
 */
public class ASysOutJunitTest {

    @Test
    public void canOutputHelloWorldToConsole(){
        AClassWithAMethod myClass = new AClassWithAMethod();
        myClass.aMethodOnAClass();}

}
