package idv.amazon;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class SolutionTest{
    Solution s = new Solution();

    @Test
    public void testDistance(){
        int[] lx = {1};
        int[] ly = {1};
        int[][] ays  = s.getLockerDistanceGrid(3,5,lx, ly);
        // for(int[] array : ays){
        //     System.out.println(Arrays.toString(array));
        // }
    }
    @Test
    public void testDistance2(){
        int[] lx = {2,4};
        int[] ly = {3,7};
        int[][] ays  = s.getLockerDistanceGrid(5,7,lx, ly);
        //
        // for(int[] array : ays){
        //     System.out.println(Arrays.toString(array));
        // }
    }
    @Test
    public void test1(){
        int[][] data = new int[][]{
            {0,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0},
            {0,0,1,1,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,1,0,0,0,0},
            {0,0,1,0,0,0,1,0,0,0,0},
            {0,0,1,1,0,0,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0},
        };
        int result = s.maxIsland(data);
        assertEquals(8, result);
    }
    @Test
    public void testlala(){
        int[][] grid = new int[][]{
            {0,0,0,0},
            {1,0,1,0},
            {1,1,0,0}
        };
        assertEquals(4, s.getExitGrid(grid, 3, 4, 1, 3));
    }
    @Test
    public void testnew(){
        s.testTreeSet();
    }
	@Test
    public void testsubString(){
        List<List<String>> res = s.getAllSubString("abc");
		for(List<String> ls : res){
			System.out.println(Arrays.toString(ls.toArray()));
		}
    }
	@Test
	public void testFindNumberOfisland(){
		int[][] map = new int[][]{
			{1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
		};
		assertEquals(5, s.findNumberOfIsland(map));
	}
	@Test
	public void testCountInversion(){
		int[] arr = new int[]{1, 20, 6, 4, 5};
		assertEquals(5, s.countInvertion(arr));
	}

}
