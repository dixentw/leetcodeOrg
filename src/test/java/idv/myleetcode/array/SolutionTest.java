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
        result = s.twoSum_1(A, 9);
        assertEquals(2, result[0]);
        assertEquals(7, result[1]);
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
        //System.out.println("------------------");
        for(List<Integer> l : r){
            //System.out.println(Arrays.toString(l.toArray()));
        }
    }
    @Test
    public void test47(){
        int[] A = new int[]{1,2,2,3};
        //List<List<Integer>> r = s.permuteUnique(A);
        //System.out.println("--------------");
        List<List<Integer>> r = s.permute2(A);
        for(List<Integer> l : r){
            //System.out.println(Arrays.toString(l.toArray()));
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
        for(List<Integer> sub : ret){
            //System.out.println(sub);
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
    @Test
    public void test53(){
        int[] A = {-2,1,-3,4,-1,2,1,-5,4};
        assertEquals( 6, s.maxSubArray(A));
        assertEquals( 6, s.maxSubArray1(A));
        assertEquals( 6, s.maxSubArray2(A));
    }
    @Test
    public void test414(){
        assertEquals(1, s.thirdMax(new int[]{3,2,1}));
        assertEquals(2, s.thirdMax(new int[]{1,2}));
        assertEquals(1, s.thirdMax(new int[]{2,2,3,1}));
        assertEquals(5, s.thirdMax(new int[]{5,2,2}));
        assertEquals(2, s.thirdMax(new int[]{1,2,2,5,3,5}));
    }
    @Test
    public void test11(){
        assertEquals(12, s.maxArea(new int[]{2,3,4,5,4,3}));
    }
    @Test
    public void test31(){
        int[] testArr = new int[]{1,2,3};
        s.nextPermutation(testArr);
        assertEquals("[1, 3, 2]", Arrays.toString(testArr));
        testArr = new int[]{3,2,1};
        s.nextPermutation(testArr);
        assertEquals("[1, 2, 3]", Arrays.toString(testArr));
        testArr = new int[]{1,1,5};
        s.nextPermutation(testArr);
        assertEquals("[1, 5, 1]", Arrays.toString(testArr));
    }
    @Test
    public void test16(){
        int[] A = new int[]{-1, 2, 1, -4};
        assertEquals(2, s.threeSumClosest(A, 1));
    }
    @Test
    public void test18(){
        int[] A = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = s.fourSum(A, 0);
        assertEquals(3, result.size());
        for(List<Integer> bb : result){
            assertEquals(0, Arrays.stream(bb.toArray(new Integer[0])).mapToInt(Integer::intValue).sum());
        }
        int[] B = new int[]{-3,-2,-1,0,0,1,2,3};
        result = s.fourSum(B, 0);
        assertEquals(8, result.size());
    }
    @Test
    public void test34(){
        int[] A = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = s.searchRange_old(A, 8);
        assertEquals("[3, 4]", Arrays.toString(result));
        int[] B = new int[]{2, 2};
		result = s.searchRange_old(B, 2);
		assertEquals("[0, 1]", Arrays.toString(result));
        int[] C = new int[]{1};
        result = s.searchRange_old(C, 1);
        assertEquals("[0, 0]", Arrays.toString(result));
        int[] D = new int[]{1, 4};
		result = s.searchRange_old(D, 4);
		assertEquals("[1, 1]", Arrays.toString(result));
    }
    @Test
    public void test35(){
        int[] C = new int[]{1,3,5,6};
        int result = s.searchInsert(C, 5);
        assertEquals(2, result);
        result = s.searchInsert(C, 2);
        assertEquals(1, result);
        result = s.searchInsert(C, 7);
        assertEquals(4, result);
        result = s.searchInsert(C, 0);
        assertEquals(0, result);
    }
    @Test
    public void test268(){
        int[] C = new int[]{0,1,3};
        int result = s.missingNumber(C);
        assertEquals(2, result);
    }
    @Test
    public void test39(){
        int[] C = new int[]{2, 3, 6, 7};
        List<List<Integer>> result = s.combinationSum(C, 7);
        assertEquals("[2, 2, 3]", Arrays.toString(result.get(0).toArray()));
        assertEquals("[7]", Arrays.toString(result.get(1).toArray()));
    }
    @Test
    public void test40(){
        int[] C = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = s.combinationSum2(C, 8);
        assertEquals("[1, 1, 6]", Arrays.toString(result.get(0).toArray()));
        assertEquals("[1, 2, 5]", Arrays.toString(result.get(1).toArray()));
        assertEquals("[1, 7]", Arrays.toString(result.get(2).toArray()));
        assertEquals("[2, 6]", Arrays.toString(result.get(3).toArray()));
    }
    @Test
    public void test48(){
        int[][] C = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        s.rotate48(C);
        assertEquals("[7, 4, 1]", Arrays.toString(C[0]));
        assertEquals("[8, 5, 2]", Arrays.toString(C[1]));
        assertEquals("[9, 6, 3]", Arrays.toString(C[2]));
    }
    @Test
    public void test54(){
        int[][] C = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> res = s.spiralOrder(C);
        assertEquals("[1, 2, 3, 6, 9, 8, 7, 4, 5]", Arrays.toString(res.toArray()));
    }
    @Test
    public void test55(){
        int[] C = {2,3,1,1,4};
        assertTrue(s.canJump(C));
        int[] D = {3,2,1,0,4};
        assertFalse(s.canJump(D));
    }
    @Test
    public void test45(){
        int[] C = {2,3,1,1,4};
        assertEquals(2, s.jump(C));
        //int[] D = {0};
        //assertEquals(1, s.jump(D));
    }
	@Test
    public void test59(){
		int[][] ra = s.generateMatrix(4);
		for(int[] t : ra){
			System.out.println(Arrays.toString(t));
		}
    }
	@Test
    public void test62(){
		assertEquals(28, s.uniquePaths(3, 7));
    }
	@Test
    public void test63(){
		int[][] c = {
			{0,0,0},
			{0,1,0},
			{0,0,0}
		};
		assertEquals(2, s.uniquePathsWithObstacles(c));
    }
	@Test
    public void test64(){
		int[][] c = {
			{0,1,1},
			{0,3,0},
			{0,1,0}
		};
		assertEquals(1, s.minPathSum(c));
    }
	@Test
    public void test73(){
		int[][] c = {
			{0,1,1},
			{3,3,3},
			{5,1,8}
		};
		s.setZeroes(c);
		for(int[] line : c){
			System.out.println(Arrays.toString(line));
		}
		int[][] d = {
			{1,0,3}
		};
		s.setZeroes(d);
		for(int[] line : d){
			System.out.println(Arrays.toString(line));
		}

    }
	@Test
    public void test74(){
		int[][] c = {
			{1,3,5,7},
			{10,11,16,20},
			{23,30,34,50}
		};
		assertEquals(true, s.searchMatrix(c, 3));

    }
	@Test
    public void test75(){
		int[] c = {0,2,2,2,2,0,0,1,0,0,1,0,1};
		s.sortColors(c);
		assertEquals("[0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2]", Arrays.toString(c));
    }
	@Test
    public void test79(){
		char[][] m = {
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}
		};
		assertTrue(s.exist(m, "ABCCE"));
		char[][] m1 = {
			{'A','A'}
		};
		assertFalse(s.exist(m, "AAA"));
    }
	@Test
    public void test80(){
		int[] a = {1,1,1,2,2,3};
		assertEquals(5, s.removeDuplicates2(a));
    }
	@Test
    public void test81(){
		int[] a = {4 ,5, 6, 7, 0, 1, 2};
		assertTrue(s.search_d(a, 6));
		assertFalse(s.search_d(a, 10));

		int[] c = {4,5,6,7,8,1,2,3};
		assertTrue(s.search_d(c, 8));
		int[] d = {3,1};
		assertTrue(s.search_d(d, 1));
		int[] e = {5,1,3};
		assertTrue(s.search_d(e, 3));

		//repeat sequence
		int[] b = {1,1,3,1};
		assertTrue(s.search_d(b, 3));
		int[] f = {1,3,1,1,1};
		assertTrue(s.search_d(f, 3));
    }
	@Test
    public void test120(){
		List<List<Integer>> test = new ArrayList<>();
		test.add(new ArrayList<Integer>(Arrays.asList(2)));
		test.add(new ArrayList<Integer>(Arrays.asList(3,4)));
		test.add(new ArrayList<Integer>(Arrays.asList(6,5,7)));
		test.add(new ArrayList<Integer>(Arrays.asList(4,1,8,3)));
		assertEquals(11, s.minimumTotal(test));
    }
	@Test
    public void test152(){
		int[] a = {2,3,-2,4};
		assertEquals(6, s.maxProduct(a));
		int[] b = {-2};
		assertEquals(-2, s.maxProduct(b));
		int[] c = {-2,3,-4};
		assertEquals(24, s.maxProduct(c));
    }
	@Test
    public void test162(){
		int[] a = {1,2,3,1};
		assertEquals(2, s.findPeakElement(a));
		int[] b = {3,4,3,2,1};
		assertEquals(1, s.findPeakElementLog(b));
    }
	@Test
    public void test167(){
		int[] a = {2,7,11,15};
		int[] res = s.twoSum_167(a, 9);
		assertEquals("[1, 2]", Arrays.toString(res));
    }
	@Test
    public void test209(){
		int[] a = {2,3,1,2,4,3};
		int res = s.minSubArrayLen(7, a);
		assertEquals(2, res);
		int[] b = {7,7,5,2};
		res = s.minSubArrayLen(6, b);
		assertEquals(1, res);
    }
	@Test
	public void test220(){
		List<String> res = s.summaryRanges(new int[]{0,1,2,4,5,7});
		assertEquals("0->2", res.get(0));
		assertEquals("4->5", res.get(1));
		assertEquals("7", res.get(2));
	}
	@Test
	public void test229(){
		int[] a = new int[]{8,8,7,7,7};
		List<Integer> res = s.majorityElement2(a);
		assertEquals(8, (int)res.get(0));
		assertEquals(7, (int) res.get(1));
		int[] b = new int[]{1,2,2,3,2,1,1,3};
		res = s.majorityElement2(b);
		for(Integer i : res){
			System.out.println(i);
		}
	}
	@Test
    public void test216(){
		List<List<Integer>> r = s.combinationSum3(3, 7);
		assertEquals("[1, 2, 4]", Arrays.toString(r.get(0).toArray()));
    }
	@Test
    public void test238(){
		int[] res = s.productExceptSelf_s1(new int[]{1,2,3,4});
		assertEquals("[24, 12, 8, 6]", Arrays.toString(res));
    }
}
