package idv.myleetcode.stack;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class MyQueueTest{

    @Test
    public void test1(){
        MyQueue mq = new MyQueue();
        mq.push(1);
        mq.push(2);
        mq.push(3);
        mq.push(4);
        mq.push(5);
        assertEquals(1, mq.peek());
        mq.pop();
        assertEquals(2, mq.peek());
        mq.pop();
        assertEquals(3, mq.peek());
        mq.pop();
        assertEquals(4, mq.peek());
        mq.pop();
        assertEquals(5, mq.peek());
        mq.pop();
        assertTrue(mq.empty());
    }
}
