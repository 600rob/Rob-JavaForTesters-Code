package com.javafortesters.chap007basicsofjavarevisited.examples;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by robert.hope on 06/12/2016.
 */
public class ClassExample {

    public static final String
            CONSTANT = "an example of a constant string that cannot be changed because it is final";

    /*Fields and variables.
    -Fields are variables that are declared at class level and are accessible
    by any method in the class. (and possibly other classes, depending on the scope) see lines 21 and 24
    local variables- these are variables created at method level (eg line 41)
     fields and variables must start with a unicode letter and can then be followed by letters and digits.
     naming convention generally uses camelCase. constants use all UPPER_CASE characters and are delimited by underscore
     ( line 12)
    */

    public static String
            aClassField = "a class field";
    // Static methods and fields. The class can have static fields and methods, which can be used without
    //instantiating the class. we do this all the time when using static imports on assert methods ( it also works on fields).
    // Unlike constant fields these ones can be changed
    //
    protected static String
            proField = " a class field";


    /*field and method scope
    public: - accessible to any class in the same package or any class that impotrs the parent class
    protected: - accessible to any class in the same package or any subl class
    private: - accessible only to methods in the class
    package-private: - when no modifier is used then the field or method is
    accessible to the class and any class in the same package
     */
    public String pubField = "a public field";
    private String privField = " a private field";
    private String name;

    public ClassExample(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }




    @Test
    public void BooleanType() {
        boolean truthy = true;
        boolean falsey = false;
        truthy = Boolean.TRUE;
        falsey = Boolean.FALSE;

        assertTrue(truthy);
        assertFalse(falsey);


    }




}
