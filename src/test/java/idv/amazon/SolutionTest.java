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
	@Test
	public void testCheckWinner(){
		List<List<String>> codes = new ArrayList<>();
		codes.add(new ArrayList<>());
		codes.get(0).add("apple");
		codes.get(0).add("apple");
		codes.add(new ArrayList<>());
		codes.get(1).add("banana");
		codes.get(1).add("anything");
		codes.get(1).add("banana");
		List<String> shopping= new ArrayList<>();
		shopping.add("orange");
		shopping.add("apple");
		shopping.add("apple");
		shopping.add("banana");
		shopping.add("orange");
		shopping.add("banana");
		assertEquals(1, s.checkWinner(codes, shopping));
		shopping.clear();
		shopping.add("apple");
		shopping.add("banana");
		shopping.add("apple");
		shopping.add("banana");
		shopping.add("orange");
		shopping.add("banana");
		System.out.println("--------");
		assertEquals(0, s.checkWinner(codes, shopping));
	}
	@Test
	public void testFieldTime(){
		List<Integer> line1 = new ArrayList<Integer>();
		line1.add(1);
		line1.add(1);
		line1.add(0);
		line1.add(2);
		List<Integer> line2 = new ArrayList<Integer>();
		line2.add(3);
		line2.add(1);
		line2.add(1);
		line2.add(1);
		List<List<Integer>> input = new ArrayList<>();
		input.add(line1);
		input.add(line2);
		assertEquals(14, s.levelFieldTime(2, 4,input));

	}

}
