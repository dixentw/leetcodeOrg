package idv.myleetcode;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * Unit test for simple App.
 */
public class AppTest{
    /**
    * Rigourous Test :-)
    */
    App a = new App();
    @Test
    public void testApp(){
        assertTrue( a.parlindrome("abcdcba") );
        assertTrue( a.parlindrome("abccba") );
    }
}
