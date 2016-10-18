package idv.myleetcode.stack;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class SolutionTest{

    Solution s = new Solution();
    @Test
    public void test1(){
        String result = s.intoPost("a+b*(c^d-e)^(f+g*h)-i");
        assertEquals("abcd^e-fgh*+^*+i-", result);
    }
    @Test
    public void test2(){
        assertEquals(-4, s.evalPost("231*+9-"));
    }
    @Test
    public void test3(){
        int[] A = new int[]{4,5,2,25};
        int[] result = s.nextGreatE(A);
        System.out.println(Arrays.toString(result));
    }
    @Test
    public void test4(){
        String str = "{}()[";
        assertFalse(s.isValid(str));
        str = "{([])}";
        assertTrue(s.isValid(str));
        str = "{([])}";
        assertTrue(s.isValid(str));
    }
    @Test
    public void test5(){
        String str = "/home/";
        assertEquals("/home", s.simplifyPath(str));
        str = "/a/./b/../../c/";
        assertEquals("/c", s.simplifyPath(str));
        str = "/";
        assertEquals("/", s.simplifyPath(str));
        str = "/..";
        assertEquals("/", s.simplifyPath(str));
    }
    @Test
    public void test6(){
        String[] strs = {"2", "1", "+", "3", "*"};
        assertEquals(9, s.evalRPN(strs));
        String[] strs1 = {"4", "13", "5", "/", "+"};
        assertEquals(6, s.evalRPN(strs1));
    }
    @Test
    public void test7(){
        String str = "3[a]2[bc]";
        assertEquals("aaabcbc", s.decodeString(str));
    }
    @Test
    public void test8(){
        String str = "3[a]2[bc]";
        assertEquals("aaabcbc", s.decodeString2(str));
        str = "ef";
        assertEquals("ef", s.decodeString2(str));
        str = "2[abc]3[cd]ef";
        assertEquals("abcabccdcdcdef", s.decodeString2(str));
        str = "3[a2[c]]";
        assertEquals("accaccacc", s.decodeString2(str));
    }
}
