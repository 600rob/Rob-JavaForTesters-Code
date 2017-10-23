package com.javafortesters.chap015stringsrevisited.examples;

import org.junit.Test;




import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * we have learned that a String is an immutable object, but Java provides the StringBuilder class which
 * allows us to manipulate and create strings.
 *
 * StringBuilder allows us to do the following:
 -append values to the end of the string
 -delete characters, or sub strings, from the string
 -insert values into the string
 -replace substrings with other strings
 -reverse the string
 *
 *
 *
 */
public class StringBuilderTest {

    @Test
    public void quickStringBuilderDemo() {

        // instantiate a new string builder object
        StringBuilder builder = new StringBuilder();

        /* StringBuilder allows us to manipulate Strings by holding an internal representation of the string
which is only converted into a String when the toString method is called. e.g.*/

        builder.append("Hello there").
                replace(7, 11, "World").
                delete(5, 7);
        System.out.println(builder);
        assertThat(builder.toString(), is("HelloWorld"));

        // note how each line of the string builder statement
        // is dot separated and only terminated by a semi colon at the end of the last line

    }

    @Test

    public void canConstructStringBuilder() {

        // we can construct an empty StringBuilder
        StringBuilder sbu = new StringBuilder();
        //or with a starting string value from anything that implements the CharSequence interface.
        // in other words, a valid string
        StringBuilder sb = new StringBuilder("hello");

        //if we create an empty String builder the default memory allocation capacity is 16.
        //use the capacity method to find out
        System.out.println(sbu.capacity());

        //when an item is appended, its capacity is automatically increased

        //you can create a StringBuilder with a custom capacity if you want

        StringBuilder sblen = new StringBuilder(512);
        assertThat(sblen.capacity(), is(512));
        assertThat(sblen.toString().length(), is(0));

        //if we create a StringBuilder that is not empty the its capacity is auto sized. eg:

        assertThat(sb.toString().length(), is(5));


    }

    @Test
    public void ensureCapacityForStringBuilder() {
        StringBuilder builder = new StringBuilder("abcdefg");
        //we can size a String builder after construction using the ensure capacity method
        builder.ensureCapacity(600);
        assertThat(builder.capacity(), is(600));
        assertThat(builder.toString(), is("abcdefg"));
        // right now the string length is 7 and the capacity size is 600
        //if we dont need the additional capacity we can set the minimum
        // required capacity using the trimToSize Method as shown below
    }

    @Test
    public void capacityManagementWithTrimToSize(){
        StringBuilder builder = new StringBuilder(600);
        assertThat(builder.capacity(), is(600));
        builder.append("abcdefg");
        assertThat(builder.capacity(),is(600));

        /* note we don't need to specify the size we want to trim to...The method does this automatically
        based on the string size
         */
        builder.trimToSize();
        assertThat(builder.capacity(),is(7));
        System.out.println(builder.capacity());


    }

    @Test
    public void appendToStringBuilder(){
        /*the append method is similar to the concatenation process for a string.
        it allows us to append items on to the end of a String */

        StringBuilder builder = new StringBuilder();

        builder.append(">");
        builder.append(1);
        builder.append("+");
        builder.append(2);

        char[] ca = {' ', '=', ' ', '3'};
        builder.append(ca);

        assertThat(builder.toString(),is(">1+2 = 3"));
        System.out.println(builder);
    }

    @Test
    public void canInsertIntoStringBuilder(){

        /*the insert method supports the same objects and primitives as append
        When using the insert method, we have to specify the position that we want to insert
        the item into.... for example....
         */

        StringBuilder builder = new StringBuilder("123890");
        // remember, indexes start a zero so dont get confused with the insert point!
        builder.insert(3,"4567");
        assertThat(builder.toString(),is("1234567890"));
        System.out.println(builder);

        //if we use an index that is longer than the available indexes, we get an out of bounds exception

        //builder.insert(15,"abs");

        //if the StringBuilder has values in the string,
        // we can insert at the start, end or anywhere in between to amend it
    }


    /* when inserting a char[] into a StringBuilder we have some additional options as follows:
    we can specify the offset in the char[] and the number of characters to copy from the char array */
    @Test
    public void insertCharArrayIntoStringBuilder(){

        StringBuilder builder = new StringBuilder("abgh");
        char[] ca = {'.', 'a','b','c','d','e','f'};
        // at position 2 in the string
        // insert from the char[] ca
        // starting at index 3 'c'
        // inclusive the next 4 indexes

        builder.insert(2,ca,3,4);
        assertThat(builder.toString(),is("abcdefgh"));
        System.out.println(builder);
    }


/*we can also delete subStrings, based on indexes as shown in the following method */

@Test
public void canDeleteUsingIndexes(){

    StringBuilder builder = new StringBuilder("abcdefg");
    //specify the start index to delete from, e.g. 2, which is “c”,
    // and specify the last index to delete up to but not including, e.g. 4, which would span “cd”
    // from the string:
    // abcdefg
    // 0123456

    builder.delete(2,4);
    assertThat(builder.toString(),is("abefg"));

    //we can also delete a specific character at a specified index using deleteCharAt

    StringBuilder builder2 = new StringBuilder("abcdefg");
    builder2.deleteCharAt(2);
    assertThat(builder2.toString(), is("abdefg"));
    System.out.println(builder2.toString());

}

@Test
    public void replaceSubstringsAndCharacters() {
    /*The replace method allows us to replace subStrings and Characters by specifying
a start index and an end index, along with a String as params.

The characters from start index to end index are replaced by the String
*/

    StringBuilder builder = new StringBuilder("abcdefgh");
    builder.replace(0, 4, "12345678");
    System.out.println(builder.toString());

    //in this example the string to replace is only 4 characters but the
    //'gap' is automatically lengthened in order to allow the replacement string to be inserted
}

    /* if we wanted to replace individual characters we could use the setCharAt method shown below*/

    @Test
    public void replaceStringBuilderChar(){
        StringBuilder builder = new StringBuilder("012345678");
        builder.setCharAt(5,'f');
        assertThat(builder.toString(), is("01234f678"));

    }

    /* there is also a useful method that allows us to reverse the characters in string
    as shown below */

@Test
    public void canReverseAString(){

    StringBuilder rob = new StringBuilder("treboR");
    assertThat(rob.reverse().toString(),is("Robert"));
    System.out.println(rob);

}

/* the subString method returns a String from the start index to the end index.
i.e.
 */

@Test
    public void canUseSubStrings(){

    StringBuilder builder = new StringBuilder("0123456789");
    assertThat(builder.substring(3,7),is("3456"));
    System.out.println(builder.substring(3,7));
// remember, the end index is NOT included in the substring!
    //if you don't specify an end index, the subString will go to the end of the target String like this:

    assertThat(builder.substring(3), is("3456789"));
    System.out.println(builder.substring(3));
}


}