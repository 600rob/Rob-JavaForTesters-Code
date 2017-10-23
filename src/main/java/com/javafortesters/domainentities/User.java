package com.javafortesters.domainentities;



public class User {

    private String username;
    private String password;


    /*private means that ONLY methods within this class and NOT those that import it
    can access these fields*/

    /*this is the no argument constructor
    you can see it takes no args because the brackets contain no return type.
    it uses two strings "username", "password" but it does not assign these to our field variables
    Instead we prefixed the strings with the word "this" i.e {this("username", "password")
     This causes the no argument constructor to call the argument constructor passing in the
     two strings as parameters.
     So when we create a User object without specifying a username/password i.e
      i.e User bob = new User();
     the default constructor is used, it calls the argument constructor and passes in
     the default String values "username", "password" into String username and String password.

      In summary, the no arg constructor calls the argument constructor and passes in a couple of strings
      which get assigned to the field variables.

      On the other hand if a user object is created with a username ans password defined.
      i.e User bob = new User("user1","password1");

      The argument constructor gets called ignoring the no argument constructor and uses the strings
      defined on instantiation
     */
    public User() {
        this("username", "password");
    }


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }



    // this is the standard password set method. It has no restrictions on password length
    public void setPassword(String password) {
        this.password = password;
    }


//return the permission level for a User as a String with value "Normal"
    public String getPermission() {
        return"Normal";
    }
}

