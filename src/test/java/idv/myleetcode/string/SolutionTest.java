package idv.myleetcode.string;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class SolutionTest{
    Solution s = new Solution();
    @Test
    public void test14(){
        String[] strs = new String[]{
            "abc23423423",
            "abc43423423",
            "abc63423423",
            "abc83423423",
        };
        String res = s.longestCommonPrefix(strs);
        assertEquals("abc", res);
    }
    @Test
    public void test28(){
        assertEquals(2, s.strStr("abcdef", "cd"));
        assertEquals(-1, s.strStr("abcdef", "xyz"));
        assertEquals(-1, s.strStr("mississippi", "issipi"));

    }
    @Test
    public void test38(){
        assertEquals("1", s.countAndSay(1));
        assertEquals("11", s.countAndSay(2));
        assertEquals("21", s.countAndSay(3));
        assertEquals("1211", s.countAndSay(4));
        assertEquals("111221", s.countAndSay(5));
        assertEquals("312211", s.countAndSay(6));
    }
    @Test
    public void test58(){
        assertEquals(5, s.lengthOfLastWord("hello world"));
    }

    @Test
    public void test345(){
        assertEquals("leotcede", s.reverseVowels("leetcode"));
        assertEquals("aA", s.reverseVowels("Aa"));
        assertEquals("a.b,.", s.reverseVowels("a.b,."));
    }
    @Test
    public void test434(){
        assertEquals(5, s.countSegments("Hello, my name is John"));
        assertEquals(6, s.countSegments(", , , ,        a, eaefa"));
    }
    @Test
    public void test383(){
        assertFalse(s.canConstruct("a", "b"));
        assertTrue(s.canConstruct("aa", "aab"));
        assertFalse(s.canConstruct("aa", "ab"));
    }
    @Test
    public void test5(){
        assertEquals("bab", s.longestPalindrome("babad"));
    }
    @Test
    public void test6(){
        assertEquals("PAHNAPLSIIGYIR", s.convert("PAYPALISHIRING", 3));
    }
    @Test
    public void test17(){
        List<String> res = s.letterCombinations("2");
        assertEquals("[a, b, c]", Arrays.toString(res.toArray()));
        res = s.letterCombinations("");
        assertEquals("[]", Arrays.toString(res.toArray()));
    }
    @Test
    public void test22(){
        List<String> res = s.generateParenthesis(4);
        System.out.println(Arrays.toString(res.toArray()));
    }
    @Test
    public void test91(){
        assertEquals(2, s.numDecodings("12"));
        assertEquals(1, s.numDecodings("10"));
        assertEquals(1, s.numDecodings("27"));
    }
    @Test
    public void test43(){
        assertEquals("612", s.multiply("51", "12"));
    }
    @Test
    public void test93(){
        List<String> res = s.restoreIpAddresses("25525511135");
        assertTrue(res.contains("255.255.11.135"));
        assertTrue(res.contains("255.255.111.35"));
    }
    @Test
    public void test165(){
        assertEquals(-1, s.compareVersion("1.5", "2.5"));
        assertEquals(-1, s.compareVersion("1", "1.1"));
        assertEquals(0, s.compareVersion("1.0", "1"));
        assertEquals(1, s.compareVersion("1.0.1", "1"));
        assertEquals(0, s.compareVersion("2.5", "2.5"));
        assertEquals(1, s.compareVersion("2.5.1", "2.5"));
    }
}
