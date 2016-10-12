package idv.myleetcode.stack;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class MinStackTest{

    @Test
    public void test1(){
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        assertEquals(-3, ms.getMin());
        ms.pop();
        assertEquals(0, ms.top());
        assertEquals(-2, ms.getMin());
    }
}
