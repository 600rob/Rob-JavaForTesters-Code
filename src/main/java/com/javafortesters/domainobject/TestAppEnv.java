package com.javafortesters.domainobject;

/**
 * Created by robert.hope on 29/11/2016.
 */
public class TestAppEnv {


    public static final String DOMAIN ="192.123.0.3";
    public static final String PORT ="67";

    public static String getUrl() {
        return "http://"+DOMAIN+":"+PORT;
    }
}
