package idv.myleetcode;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * Unit test for simple App.
 */
public class AppTest{
    App a = new App();
    @Test
    public void testApp(){
        assertTrue( a.parlindrome("abcdcba") );
        assertTrue( a.parlindrome("abccba") );
    }
    @Test
    public void testBits(){
        int b = a.getSingle(new int[]{3,2,3,3});
        assertEquals(2,b);
    }
    @Test
    public void testReverse(){
        assertEquals("edcba", a.reverse("abcde"));
        assertEquals("dcba", a.reverse("abcd"));
    }
}
