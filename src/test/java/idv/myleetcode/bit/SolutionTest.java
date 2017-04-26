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
    @Test
    public void test3(){
        assertEquals(7, s.getSum(2, 5));
        assertEquals(4, s.getSum(1, 3));
    }
    @Test
    public void test4(){
        int[] result = s.countBits2(15);
        int[] expect = new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
        assertTrue(Arrays.equals(expect, result));
    }
	@Test
    public void test397(){
        assertEquals(3, s.integerReplacement(8));
        assertEquals(4, s.integerReplacement(7));
        assertEquals(3, s.integerReplacement(5));
        assertEquals(4, s.integerReplacement(9));
    }

}
