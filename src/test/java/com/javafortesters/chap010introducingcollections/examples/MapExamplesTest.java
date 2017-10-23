package com.javafortesters.chap010introducingcollections.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by robert.hope on 07/04/2017.
 */
public class MapExamplesTest {

    @Test

    public void mapExamplesExplored(){

        Map<String,User> mapa = new HashMap<>(); //use this version with generics as its quicker

        //you can also use the other declarations like this

        Map<String,User> mapb = new HashMap<String, User>();
        Map<String,User> mapc = new <String, User> HashMap();

        /* some of the methods that Map implements
        map.containsKey(o)
        map.containsValue(o)
        map.entrySet()
        map.get(o)
        map.keySet()
        map.put(o,o)
        map.putAll(m);
        map.size()
        map.clear();
        map.isEmpty()
        map.values()
        map.remove(o)

        it also implements the following from the collection interface:
        size
        clear
        isEmpty
        */
    }

    @Test
    public void canAddKeyValuePairsToMap(){

        /* A map is declared with two values, a key and a value. The key represents its position in the map.
        The value is...... the type of thing being stored in the map
        */
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        //so in the above lines we have assigned "value1" to key position "key1" and so on....
        //The key, can be an object, as can the value. It just depends how we declare the map
        assertEquals(3,map.size());

        //if we put a key value pair in the place of an existing one it will overwrite the
        //existing value

        // we can get values from the map using their key position like this:

        System.out.println(map.get("key1"));
        assertEquals("key2 = value2", "value2", map.get("key2"));

        // if we try to access a key that does not exist we get a null value returned

        System.out.println(map.get("key4"));


    }

    @Test
    public void canRemoveKeyValuePairsFromMap(){

        Map<String,String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");

        // we can remove a key value pair using its key value like this:

        map.remove("key3");

        // the verify that i has been removed

        assertEquals(2,map.size());

        // note, if we try to delete a key that does not exist, we dont get an error.
        // nothing happens since there is no impact of deleting something that is not there!


    }

    @Test
    public void emptyAMapUsingClear(){

        /*in the same way as we did with a collection, we can empty an entire map
        using the clear method */
        Map<String,String> map = new HashMap<>();

        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");

        assertEquals(3,map.size());

        map.clear();
        //now the map is clear, verify that it ACTUALLY is clear

        assertEquals(0,map.size());
        assertTrue(map.isEmpty());


    }


    @Test
    public void  checkContentsOfMapByContainsKey(){
        /*there are two contains method that we can use to check the contents of a map. ContainsKey
        and ContainsValue. As the name suggest they check each type. Both methods return true of false
        depending on if a value with the specified ket exists in the map. for example: * note,
        you have do do something with the boolean result like print if you want to see it in the console
         */

        Map<String,String> map = new HashMap<>();

        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");

        System.out.println(map.containsKey("key1"));
        assertTrue(map.containsKey("key2"));
        assertFalse(map.containsKey("key11"));

        //containsValue method works the same way.i.e

        assertTrue(map.containsValue("value1"));
        assertFalse(map.containsValue("tescovalue"));

    }

    @Test
    public void canPutOneMapIntoAnother(){

        /* we can add the entire contents one map into another using the putAll method*/
        Map<String,String> mapa = new HashMap<>();
        Map<String,String> mapb = new HashMap<>();


        mapa.put("key1", "value1");
        mapa.put("key2", "value2");
        mapa.put("key3", "value3");

        mapb.put("key1","testvalue1");
        mapb.put("key4","testvalue2");

        //we can see that both maps contain a value with key1. If we try to copy mapa into mapb
        // the duplicate key (in this case key1) will be overwritten with the key, and its value from
        // the source map. i.e "key1","testvalue1" will become "key1","value1"

        mapb.putAll(mapa);

        System.out.println(mapb.get("key1"));
        assertEquals(4,mapb.size());

    }

    @Test
    public void canReturnAllMapValuesUsingValue(){

        /* Value can be used to let us to put all of the values stored in a map, into a collection.
         the collection can then be used to expose those values like this:
         ( you can probably use other methods on the collection interface that allow us to work with the data*/

        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Collection<String> value = map.values();

        System.out.println(value);


    }

    @Test
    public void canReturnAllMapValuesUsingKeySet() {

        /* keySet can be used to let us to put all of the keys stored in a map, into a set.
         the set can then be used to expose those keys like this: */

        Map<String, String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Set<String> keys = map.keySet();

        System.out.println(keys);
    }



    @Test
    public void canUseEntrySet(){
        /* entrySet returns the set of entry Objects from java.util.Map
        where, and Entry is the "key,Value" pair
        Entry exposes the methods:
        getValue
        getKey
        setvalue
             */
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        //    the following code iterates through the entries in the Map and sets all values to "bob"

        Set<Map.Entry<String,String>> entries = map.entrySet();

        for( Map.Entry<String,String> entry : entries){
            entry.setValue("bob");
        }

        assertEquals("bob", map.get("key1"));
        assertEquals("bob", map.get("key2"));
        assertEquals("bob", map.get("key3"));
    }









}
