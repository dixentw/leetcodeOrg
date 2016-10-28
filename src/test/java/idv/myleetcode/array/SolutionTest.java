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
        int[] result = {1,2,3,4,5,6};
        assertTrue(Arrays.equals(A, result));
    }
    @Test
    public void test26(){
        int[] B = new int[]{2,3,4,6,6,6,6,6,7};
        assertEquals(5, s.removeDuplicates(B));
    }
    @Test
    public void test118(){
        List<List<Integer>> tri = s.generate1(5);
        int[][] result = {{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}, {1, 4, 6, 4, 1}};
        for(List<Integer> line : tri){
            assertTrue(line.contains(1));
        }
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
        Arrays.equals(new int[]{5, 6, 7, 1, 2, 3, 4}, A);
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
        /*
        for(int[] a : data){
            System.out.println(Arrays.toString(a));
        }*/
    }
    @Test
    public void test46(){
        //s.strperm("abca");
        int[] A = new int[]{1,2,3,4};
        List<List<Integer>> r = s.permute(A);
        /*
        System.out.println("------------------");
        for(List<Integer> l : r){
            System.out.println(Arrays.toString(l.toArray()));
        }*/
    }
    @Test
    public void test46_2(){
        //s.strperm("abca");
        int[] A = new int[]{1,2,3,4};
        List<List<Integer>> r = s.permute2(A);
        System.out.println("------------------");
        for(List<Integer> l : r){
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
    @Test
    public void test47(){
        int[] A = new int[]{1,2,2,3};
        //List<List<Integer>> r = s.permuteUnique(A);
        System.out.println("--------------");
        List<List<Integer>> r = s.permute2(A);
        for(List<Integer> l : r){
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
    @Test
    public void test324(){
        int[] a = new int[]{1,2,3,4};
        int[] b = new int[]{1,2,5,6};
        int[] c = s.intersection(a, b);
        assertTrue(Arrays.equals(new int[]{1,2}, c));
    }
    @Test
    public void testAddDigit(){
        assertTrue(s.isAnagram("cat", "tac"));
        assertFalse(s.isAnagram("cat", "sac"));
    }
    @Test
    public void testAddOne(){
        int[] numb = new int[]{9,9,9,9};
        int[] numb1 = new int[]{9,9,8,9};
        Arrays.equals(new int[]{1,0,0,0,0}, s.plusOne(numb));
        Arrays.equals(new int[]{9,9,9,9}, s.plusOne(numb1));
    }
    @Test
    public void testDuplicate(){
        int[] nums1 = {0,1,3,2,4,6,6,7};
        int[] nums2 = {0,1,3,2,4,6,5,7};
        assertTrue(s.containsDuplicate(nums1));
        assertFalse(s.containsDuplicate(nums2));
    }
    @Test
    public void testSubsets(){
        int[] nums = {1,2,3};
        List<List<Integer>> ret = s.subsets(nums);
        System.out.println("=============================");
        for(List<Integer> sub : ret){
			System.out.println(sub);
		}
    }
    @Test
    public void testProfile122(){
        int[] A = {5,4,3,6,10,32,31,30,45,3};
        assertEquals(44, s.maxProfit2(A));
        A = new int[]{5,4,3,6,10,32,31,30,45,46};
        assertEquals(45, s.maxProfit2(A));
        A = new int[]{4,2,1};
        assertEquals(0, s.maxProfit2(A));
        A = new int[]{1,2};
        assertEquals(1, s.maxProfit2(A));
        A = new int[]{1,7,4,2};
        assertEquals(6, s.maxProfit2(A));
    }
    @Test
    public void test15(){
        int[] S = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = s.threeSum_old(S);
        assertEquals("[-1, -1, 2]", Arrays.toString(result.get(0).toArray()));
        assertEquals("[-1, 0, 1]", Arrays.toString(result.get(1).toArray()));
    }
}
