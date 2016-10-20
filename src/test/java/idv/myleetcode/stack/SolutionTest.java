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
        //System.out.println(Arrays.toString(result));
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
    @Test
    public void test9(){
        assertEquals("1219", s.removeKdigits("1432219", 3));
        assertEquals("200", s.removeKdigits("10200", 1));
        assertEquals("0", s.removeKdigits("10", 2));
        assertEquals("0", s.removeKdigits("100", 1));
        assertEquals("46", s.removeKdigits("100546", 2));
    }
    @Test
    public void test10(){
        assertEquals(6, s.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        assertEquals(2, s.trap(new int[]{2,0,2}));
        assertEquals(1, s.trap(new int[]{5,4,1,2}));
        assertEquals(14, s.trap(new int[]{5,2,1,2,1,5}));
        /*
        assertEquals(6, s.trap_old(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        // wrong : assertEquals(2, s.trap_old(new int[]{2,0,2}));
        assertEquals(1, s.trap_old(new int[]{5,4,1,2}));
        assertEquals(14, s.trap_old(new int[]{5,2,1,2,1,5}));
        assertEquals(23, s.trap_old(new int[]{5,5,1,7,1,1,5,2,7,6}));
        //Wrong case, pending
         assertEquals(23, s.trap_old(new int[]{5,3,7,7}));
        */

    }
    @Test
    public void test11(){
        assertEquals(5, s.largestRectangleArea(new int[]{5}));
        assertEquals(4, s.largestRectangleArea(new int[]{2,4}));
        assertEquals(4, s.largestRectangleArea(new int[]{1,2,2}));
        assertEquals(15, s.largestRectangleArea(new int[]{5,5,6}));
        assertEquals(2, s.largestRectangleArea(new int[]{2,0,2}));

    }
}
