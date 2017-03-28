package idv.myleetcode.dp;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class SolutionTest{
    Solution s = new Solution();
    @Test
    public void test1(){
		int[] coins0 = new int[]{2};
        assertEquals(1, s.coinChange_dp(coins0, 2));
		int[] coins = new int[]{1,2,5};
        assertEquals(3, s.coinChange_dp(coins, 11));
		int[] c2 = new int[]{2};
        assertEquals(-1,  s.coinChange_dp(c2, 3));
    }
}
