package idv.myleetcode.math;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * Unit test for simple App.
 */
public class SolutionTest{
    /**
    * Rigourous Test :-)
    */
    Solution s = new Solution();
    @Test
    public void testPow(){
        assertEquals(9.0, s.pow(3, 2), 0.0);
        assertEquals(27.0, s.pow(3, 3), 0.0);
    }
    @Test
    public void testParlidromeNum(){
        assertTrue(s.isPalindrome2(1));
        assertTrue(s.isPalindrome2(131));
        assertFalse(s.isPalindrome2(21));
        assertFalse(s.isPalindrome2(-1));
        assertFalse(s.isPalindrome2(-2147447412));
    }
    @Test
    public void testAddBinary(){
        assertEquals("10", s.addBinary("1", "1"));
        assertEquals("100", s.addBinary("11", "1"));
    }
}
