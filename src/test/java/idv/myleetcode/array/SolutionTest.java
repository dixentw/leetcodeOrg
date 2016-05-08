package idv.myleetcode.array;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class SolutionTest {
    Solution s = new Solution();
    @Test
    public void test88(){
        int[] A = new int[6];
        A[0] = 1;
        A[1] = 3;
        A[2] = 5;
        int[] B = new int[]{2,4,6};
        s.merge(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }
    @Test
    public void test26(){
        int[] B = new int[]{2,3,4,6,6,6,6,6,7};
        assertEquals(5, s.removeDuplicates(B));
        System.out.println(Arrays.toString(B));
    }
    @Test
    public void test118(){
        List<List<Integer>> tri = s.generate1(5);
        System.out.println(Arrays.deepToString(tri.toArray()));
    }
    @Test
    public void test121(){
        int[] A = new int[]{2,1};
        assertEquals(0, s.maxProfit(A));
        A = new int[]{1,2,3,4,5,7,100};
        assertEquals(99, s.maxProfit(A));
    }
    @Test
    public void test169(){
        int[] A = new int[]{1,2,3,5,5,5,5};
        assertEquals(5, s.majorityElement(A));
    }
    @Test
    public void test189(){
        int[] A = new int[]{1,2,3,4,5,6,7};
        s.rotate(A, 3);
        System.out.println(Arrays.toString(A));

    }
    @Test
    public void test217(){
        int[] A = new int[]{4,1,2,3,1,5};
        assertTrue(s.containsDuplicate(A));
        A = new int[]{4,1,2,3,7,5};
        assertFalse(s.containsDuplicate(A));
    }
    @Test
    public void test219(){
        int[] A = new int[]{4,1,2,3,1,5};
        assertTrue(s.containsNearbyDuplicate(A, 3));
        assertFalse(s.containsNearbyDuplicate(A, 1));
    }
    @Test
    public void test289(){
        int[][] data = new int[][]{
            {0,0,0,0,0},
            {0,0,1,0,0},
            {0,0,1,0,0},
            {0,0,1,0,0},
            {0,0,0,0,0}
        };
        s.gameOfLife(data);
        for(int[] a : data){
            System.out.println(Arrays.toString(a));
        }
    }
    @Test
    public void test46(){
        s.strperm("abc");
        int[] A = new int[]{1,2,3,4};
        List<List<Integer>> r = s.permute(A);
        for(List<Integer> l : r){
            System.out.print("@@@");
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}
