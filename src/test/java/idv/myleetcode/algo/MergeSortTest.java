package idv.myleetcode.algo;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class MergeSortTest {
    @Test
    public void testA(){
        int[] A = {1,2,34,5,6,3,11,100,8,40};
        int[] B = MergeSort.mergeSort(A);
        System.out.println(Arrays.toString(B));
    }
    @Test
    public void testB(){
        int[][] A = {
            {1,2,3,4},
            {5,6,7,8},
            {89,99,100,120},
            {88,90,99,121}
        };
        int[] B = MergeSort.mergeKArrays(A);
        System.out.println(Arrays.toString(B));
    }
}
