package com.javafortesters.chap009revisited;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by robert.hope on 07/02/2017.
 */
public class Create100UsersExersisce {

    @Test
    public void createUserArray(){

        User[] users = new User[3];

        users[0] = new User ("user1","password1");
        users[1] = new User ("user2","password2");
        users[2] = new User ("user3","password3");


        for(User a : users){
            System.out.println(a.getUsername());

        }
    }

    @Test
    public void create100Users(){

        User [] usergroup = new User [100];

        for(int a = 0 ; a<usergroup.length; a++){
            int userID = a+1;

            usergroup[a] = new User ("user"+ userID, "password" + userID );

            assertEquals("user"+userID+"|"+"password"+userID,
                    usergroup[a].getUsername()+"|"+usergroup[a].getPassword());

            System.out.println(usergroup[a].getUsername()+"|"+usergroup[a].getPassword());



            }

    }




    }


