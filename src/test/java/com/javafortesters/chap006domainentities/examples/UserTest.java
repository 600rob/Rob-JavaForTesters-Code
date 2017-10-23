package com.javafortesters.chap006domainentities.examples;


import com.javafortesters.domainentities.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by robert.hope on 01/12/2016.
 */
public class UserTest {

    @Test
    public void canConstructNewAUser() {
        User user = new User();
        System.out.println(user.getUsername()+"/"+user.getPassword() );
    }


    @Test
    public void userHasDefaultUsernameAndPassword() {
        User user = new User();

        assertEquals("default username expected", "username", user.getUsername());
        assertEquals("default password expected", "password", user.getPassword());
        System.out.println(user.getUsername() +"/"+ user.getPassword());
    }

   /* @Test
    public void canSetNewValueForUsernameAndPassword() {
        User user1 = new User();
        user1.password = "pa55word";
        user1.username = "geezer";
        assertEquals("not default password", "geezer", user1.username())

        System.out.println(user1.username+"/"+user1.password);
 }
//THIS METHOD ONLY WORKS IF WE MAKE THE FIELDS IN THE USER CLASS PUBLIC
*/

   @Test
    public void canConstructWithUserNameAndPassword()
   {User user2 = new User("admin","pa55word");
       assertEquals("given username expected","admin", user2.getUsername() );
       assertEquals("given password expected","pa55word", user2.getPassword() );
       System.out.println(user2.getUsername() +"/"+ user2.getPassword());
   }

   @Test
    public void canSetPasswordAfterConstructed(){
       User user3 = new User();
       user3.setPassword("pazzword");
       assertEquals("setter password expected", "pazzword", user3.getPassword());
       System.out.println(user3.getUsername()+"/"+user3.getPassword());
   }

}










