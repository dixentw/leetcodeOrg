package idv.booking;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class SolutionTest{
    Solution s = new Solution();
    @Test
    public void test1(){
       assertEquals("hello booking.com", s.greeting());
    }
    @Test
    public void test2(){
        s.StairCase(6);
    }
}
