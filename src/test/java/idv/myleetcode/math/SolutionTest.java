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
    public void testApp(){
        assertEquals(9.0, s.pow(3, 2), 0.0);
        assertEquals(27.0, s.pow(3, 3), 0.0);
    }
}
