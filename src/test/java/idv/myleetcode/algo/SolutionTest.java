package idv.myleetcode.algo;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class SolutionTest {
    @Test
    public void testMultiThread(){
        try{
            Solution s = new Solution();
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
}
