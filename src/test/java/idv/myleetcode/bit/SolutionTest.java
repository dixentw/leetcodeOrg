package idv.myleetcode.bit;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class SolutionTest {
    Solution s = new Solution();

    @Test
    public void test1(){
        int[] B = {2,2,2,4};
        System.out.println(s.getAppear1(B));
    }
}
