package idv.myleetcode.hashtable;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class SolutionTest {
    Solution s = new Solution();

    @Test
    public void test299(){
        String result = s.getHint("1807", "7810");
        assertEquals("1A3B", result);
        result = s.getHint("1123", "0111");
        assertEquals("1A1B", result);
    }

}
