package idv.myleetcode.stack;

import static org.junit.Assert.*;
import org.junit.*;

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
}
