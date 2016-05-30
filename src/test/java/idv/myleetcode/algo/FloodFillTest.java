package idv.myleetcode.algo;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class FloodFillTest {
    @Test
    public void testFill(){
        int[][] data = new int[][]{
            {0,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0},
            {0,0,1,1,1,1,1,0,0,0,0},
            {0,0,1,0,0,0,1,0,0,0,0},
            {0,0,1,0,0,0,1,0,0,0,0},
            {0,0,1,0,0,0,1,0,0,0,0},
            {0,0,1,1,1,1,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0},
        };
        FloodFill.fill(data, 4, 4, 0, 1);
        for(int i=0; i<data.length; i++){
            System.out.println(Arrays.toString(data[i]));
        }
    }
}
