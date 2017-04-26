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
}
