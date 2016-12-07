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
    @Test
    public void test204(){
        assertEquals(3, s.countPrimes(7));
    }
    @Test
    public void test36(){
        char[][] A = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        assertTrue(s.isValidSudoku(A));
    }
    @Test
    public void test350(){
        int[] a = {1,2,2,1};
        int[] b = {2,2};
        int[] result = s.intersect(a, b);
        Arrays.equals(new int[]{2,2}, result);
        int[] c = {3,1,2};
        int[] d = {1,1};
        result = s.intersect(c, d);
        Arrays.equals(new int[]{1}, result);
    }
    @Test
    public void test3(){
        assertEquals(3, s.lengthOfLongestSubstring("pwwkew"));
        System.out.println("ffff");
        assertEquals(1, s.lengthOfLongestSubstring("c"));
        assertEquals(2, s.lengthOfLongestSubstring("au"));
        assertEquals(1, s.lengthOfLongestSubstring("aa"));
        assertEquals(3, s.lengthOfLongestSubstring("aabc"));
        assertEquals(3, s.lengthOfLongestSubstring("dvdf"));
    }
}
