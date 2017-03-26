package idv.donuts;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class SolutionTest{
	Solution s = new Solution();
	@Test
	public void test1(){
		s.hello();
	}
	@Test
	public void test2(){
		int[] A = {-1, 3, -4, 5, 1, -6, 2, 1};
		//System.out.println(s.solution1(A));
	}
	@Test
	public void test3(){
		//System.out.println(s.solution2(1213));
	}
	@Test
	public void test4(){
		int[] A = {6, 10, 6, 9, 7, 8};
		//System.out.println(s.solution3(A));
		int[] B = {1, 2, 2, 2, 3, 4};
		//System.out.println(s.solution3(B));
	}
	@Test
	public void test5(){
		int[][] A = {
			{5, 4, 4},
			{4, 3, 4},
			{3, 2, 4},
			{2, 2, 2},
			{3, 3, 4},
			{1, 4, 4},
			{4, 1, 1}
		};
		//should be 11
		System.out.println(s.solution4(A));
		int[][] B = {
			{5, 5, 5},
			{4, 4, 4}
		};
		System.out.println(s.solution4(B));
	}
	@Test
	public void test6(){
		int[] A = {0,0,0,0};
		//System.out.println(s.solution5(A));
	}
	@Test
	public void test7(){
		int[] A = {10,2,5,1,8,20};
		//System.out.println(s.solution6(A));
		int[] B = {5,10,18,7,8,3};
		//System.out.println(s.solution6(B));
	}
	@Test
	public void test8(){
		assertEquals(17, s.solution("10:00", "13:21"));
	}
	@Test
	public void test9(){
		assertEquals(2, s.solution_2("a0Ba"));
	}
	@Test
	public void test10(){
		int[][] A = {
			{7,-2,0,4,2},
			{-1,0,4,3,1},
			{1,2,1,-1,2},
			{4,0,0,-3,0}
		};
		assertEquals(4, s.solution_3(A));
	}

}
