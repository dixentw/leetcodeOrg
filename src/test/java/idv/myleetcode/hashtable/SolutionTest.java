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
    @Test
    public void test290(){
        assertTrue(s.wordPattern("abba", "dog cat cat dog"));
        assertFalse(s.wordPattern("abba", "dog cat cat fish"));
        assertFalse(s.wordPattern("aaaa", "dog cat cat dog"));
        assertFalse(s.wordPattern("abba", "dog dog dog dog"));
        assertFalse(s.wordPattern("jquery", "jquery"));
    }
    @Test
    public void test205(){
        assertTrue(s.isIsomorphic("egg", "add"));
        assertFalse(s.isIsomorphic("ab", "cc"));
        assertFalse(s.isIsomorphic("foo", "bar"));
        assertTrue(s.isIsomorphic("paper", "title"));
    }

}
