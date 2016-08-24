package idv.myleetcode.algo;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class SolutionTest {
    private Solution s = new Solution();

    @Test
    public void testAddDigit(){
        System.out.println(s.addDigit(1990));
    }

    @Test
    public void testBinarySearch(){
        int n = s.firstBadVersion(2);
        System.out.println("fffffff : " +n);
    }

    @Test
    public void testMultiThread(){
        try{
            assertEquals(18, s.computeArea(0,0,3,3,3,0,6,3));
            assertEquals(28, s.computeArea(0,0,4,4,3,0,7,4));
            assertEquals(4, s.computeArea(0,0,0,0,-1,-1,1,1));
            assertEquals(17, s.computeArea(-2,-2,2,2,3,3,4,4));
            assertEquals(17, s.computeArea(-2,-2,2,2,-4,-4,-3,-3));
            assertEquals(19, s.computeArea(-2,-2,2,2,1,-3,3,-1));
        }catch(Exception e){
            System.out.println("exception");
        }
    }
    @Test
    public void testNumOfIsland(){
        /*
        int[][] data = new int[][]{
            {0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,1,0,0,0,0},
            {0,0,1,0,0,1,1,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,1,0,0,0,0,0},
            {0,0,1,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0},
        };
        assertEquals(4, s.numberOfIsland(data));
        */
        char[][] ddd = new char[][]{
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        assertEquals(1, s.numberOfIsland(ddd));
    }
    @Test
    public void testStairCase(){
        s.stairCase(6);
    }
    @Test
    public void testInversion(){
        assertEquals(5, s.countInversion(new int[]{1, 20, 6, 4, 5}));
    }
}
