package idv.myleetcode.algo;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class GfgTest {
    private Gfg g = new Gfg();

    @Test
    public void test1(){
        int[] result = g.getMaxN(new int[]{1, 23, 12, 9, 30, 2, 50}, 3);
        int[] expect = new int[]{50,30,23};
        assertTrue(Arrays.equals(expect, result));
    }
    @Test
    public void test2(){
        int[] A = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        g.buildMaxHeap(A);
        System.out.println(Arrays.toString(A));
    }
    @Test
    public void test3(){
        int[] result = g.getMaxN2(new int[]{1, 23, 12, 9, 30, 2, 50}, 4);
        int[] expect = new int[]{50,30,23,12};
        assertTrue(Arrays.equals(expect, result));
    }
    @Test
    public void test4(){
        int[] ori = new int[]{1, 23, 12, 9, 30, 2, 50};
        g.bubbleSort(ori);
        int[] expect = new int[]{1,2,9,12,23,30,50};
        assertTrue(Arrays.equals(expect, ori));
    }
    @Test
    public void test5(){
        int[] ori = new int[]{1, 23, 12, 9, 30, 2, 50};
        g.insertionSort(ori);
        int[] expect = new int[]{1,2,9,12,23,30,50};
        assertTrue(Arrays.equals(expect, ori));
    }
    @Test
    public void test6(){
        int[] ori = new int[]{1, 23, 12, 9, 30, 2, 50};
        g.selectionSort(ori);
        int[] expect = new int[]{1,2,9,12,23,30,50};
        assertTrue(Arrays.equals(expect, ori));
    }
    @Test
    public void test7(){
        int[] ori = new int[]{1, 23, 12, 9, 30, 2, 50};
        g.quickSort(ori,0, ori.length-1);
        System.out.println(Arrays.toString(ori));
        int[] expect = new int[]{1,2,9,12,23,30,50};
        assertTrue(Arrays.equals(expect, ori));
    }
}
