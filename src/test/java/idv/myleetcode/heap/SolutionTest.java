package idv.myleetcode.heap;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class SolutionTest{
    Solution s = new Solution();
    @Test
    public void test1(){
        int[] unsort = new int[]{1, 23, 12, 9, 30, 2, 50};
        s.heapSort(unsort);
        int[] expect = new int[]{1,2,9,12,23,30,50};
        assertTrue(Arrays.equals(expect, unsort));
    }
}
