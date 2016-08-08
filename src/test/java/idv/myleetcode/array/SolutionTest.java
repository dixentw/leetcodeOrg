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
    public void test1(){
        int[] A = new int[]{2, 7, 11, 15};
        int[] result = s.twoSum(A, 9);
        assertTrue(result[0]==1||result[0]==0);
        assertTrue(result[1]==1||result[1]==0);
    }
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
        /*
        for(List<Integer> l : r){
            System.out.println(Arrays.toString(l.toArray()));
        }*/
    }
    @Test
    public void test324(){
        int[] a = new int[]{1,2,3,4};
        int[] b = new int[]{1,2,5,6};
        int[] c = s.intersection(a, b);
        System.out.println(Arrays.toString(c));
    }
    @Test
    public void testAddDigit(){
        System.out.println(s.isAnagram("cat", "tac"));
        System.out.println(s.isAnagram("cat", "sac"));
    }
    @Test
    public void testAddOne(){
        int[] numb = new int[]{9,9,9,9};
        int[] numb1 = new int[]{9,9,8,9};
        System.out.println(Arrays.toString(s.plusOne(numb)));
        System.out.println(Arrays.toString(s.plusOne(numb1)));
    }
    @Test
    public void testDuplicate(){
        int[] nums1 = {0,1,3,2,4,6,6,7};
        int[] nums2 = {0,1,3,2,4,6,5,7};
        assertTrue(s.containsDuplicate(nums1));
        assertFalse(s.containsDuplicate(nums2));
    }
}
