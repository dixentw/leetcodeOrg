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
		System.out.println(Arrays.toString(res.toArray()));
		res = s.letterCombinations("");
		System.out.println(Arrays.toString(res.toArray()));
	}

}
