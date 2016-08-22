package idv.myleetcode.bit;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class SolutionTest {
    Solution s = new Solution();

    @Test
    public void test1(){
        int[] B = {2,2,2,4};
        assertEquals(4, s.getAppear1(B));
    }
    @Test
    public void test2(){
        assertEquals(1073741824, s.reverseBit(2));
    }
}
