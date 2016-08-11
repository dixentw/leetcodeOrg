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
}
