package idv.amazon;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class SolutionTest{
    Solution s = new Solution();
    @Test
    public void testAAA(){
        s.hello();
    }
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
}
