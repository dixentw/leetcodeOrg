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
	@Test
    public void test2(){
        int[] unsort = new int[]{1, 23, 12, 9, 30, 2, 50};
        s.heapSortMin(unsort);
        int[] expect = new int[]{50,30,23,12,9,2,1};
        assertTrue(Arrays.equals(expect, unsort));
		int[][] a = new int[]{
			{1, 3, 5, 7, 9},
			{0, 2, 4, 6, 8},
			{2, 3, 5, 7, 11}
		}
		s.smallestRange(a);
    }
}
