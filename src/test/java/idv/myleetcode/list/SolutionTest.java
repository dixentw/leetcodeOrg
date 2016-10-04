package idv.myleetcode.list;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class SolutionTest {
    Solution s = new Solution();
    @Test
    public void test203(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode h = s.removeElements(n1, 1);
        int[] r = new int[4];
        int i=0;
        while(h!=null){
            r[i++] = h.val;
            h = h.next;
        }
        assertEquals(Arrays.toString(new int[]{2,3,2,5}), Arrays.toString(r));
    }
    @Test
    public void test234(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        assertFalse(s.isPalindromeO1(n1));
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(3);
        ListNode m4 = new ListNode(2);
        ListNode m5 = new ListNode(1);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        assertTrue(s.isPalindromeO1(m1));
    }
    @Test
    public void testlalala(){
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(3);
        ListNode m4 = new ListNode(4);
        ListNode m5 = new ListNode(5);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        ListNode h = s.reverse(m1);
        while(h!=null){
            //System.out.println(h.val);
            h = h.next;
        }
    }
    @Test
    public void test12(){
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(3);
        ListNode m4 = new ListNode(4);
        ListNode m5 = new ListNode(5);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        ListNode m11 = new ListNode(6);
        ListNode m21 = new ListNode(7);
        ListNode m31 = new ListNode(8);
        ListNode m41 = new ListNode(9);
        ListNode m51 = new ListNode(10);
        m11.next = m21;
        m21.next = m31;
        m31.next = m41;
        m41.next = m51;
        ListNode h = s.merge(m1, m11);
        while(h!=null){
            //System.out.println(h.val);
            h = h.next;
        }
    }
    @Test
    public void test2(){
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(4);
        m1.next = m2;
        m2.next = m3;
        ListNode h = s.addTwoNumbers(n1, m1);
        int[] r = new int[3];
        int i=0;
        while(h!=null){
            r[i++] = h.val;
            h = h.next;
        }
        assertEquals(Arrays.toString(new int[]{7,0,8}), Arrays.toString(r));
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(5);
        h = s.addTwoNumbers(a, b);
        assertEquals(0, h.val);
        assertEquals(1, h.next.val);
        a = new ListNode(9);
        a.next = new ListNode(8);
        b = new ListNode(1);
        h = s.addTwoNumbers(a, b);
        assertEquals(0, h.val);
        assertEquals(9, h.next.val);

    }
    @Test
    public void test141(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next = node.next.next;
        assertTrue(s.hasCycle(node));
    }
    @Test
    public void test29(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode l = s.removeNthFromEnd2(node, 2);
        int[] r = new int[4];
        int i=0;
        while(l!=null){
            r[i++] = l.val;
            l = l.next;
        }
        assertEquals(Arrays.toString(new int[]{1,2,3,5}), Arrays.toString(r));
        node = new ListNode(1);
        l = s.removeNthFromEnd2(node, 1);
        assertEquals(null, l);
    }
    @Test
    public void test24(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode result = s.swapPairs(node);
        int[] r = new int[4];
        int i=0;
        while(result!=null){
            r[i++] = result.val;
            result = result.next;
        }
        assertEquals(Arrays.toString(new int[]{2,1,4,3}), Arrays.toString(r));
    }
    @Test
    public void test61(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode result = s.rotateRight(node, 2);
        int[] r = new int[5];
        int i=0;
        while(result!=null){
            r[i++] = result.val;
            result = result.next;
        }
        assertEquals(Arrays.toString(new int[]{4,5,1,2,3}), Arrays.toString(r));

        node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        result = s.rotateRight(node, 3);
        r = new int[5];
        i=0;
        while(result!=null){
            r[i++] = result.val;
            result = result.next;
        }
        assertEquals(Arrays.toString(new int[]{3,4,5,1,2}), Arrays.toString(r));

        node = new ListNode(1);
        node.next = new ListNode(2);
        result = s.rotateRight(node, 1);
        r = new int[2];
        i=0;
        while(result!=null){
            r[i++] = result.val;
            result = result.next;
        }
        assertEquals(Arrays.toString(new int[]{2,1}), Arrays.toString(r));

        node = new ListNode(1);
        node.next = new ListNode(2);
        result = s.rotateRight(node, 2);
        r = new int[2];
        i=0;
        while(result!=null){
            r[i++] = result.val;
            result = result.next;
        }
        assertEquals(Arrays.toString(new int[]{1,2}), Arrays.toString(r));

        node = new ListNode(1);
        node.next = new ListNode(2);
        result = s.rotateRight(node, 3);
        r = new int[2];
        i=0;
        while(result!=null){
            r[i++] = result.val;
            result = result.next;
        }
        assertEquals(Arrays.toString(new int[]{2,1}), Arrays.toString(r));

        node = new ListNode(1);
        node.next = new ListNode(2);
        result = s.rotateRight(node, 4);
        r = new int[2];
        i=0;
        while(result!=null){
            r[i++] = result.val;
            result = result.next;
        }
        assertEquals(Arrays.toString(new int[]{1,2}), Arrays.toString(r));

        node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        result = s.rotateRight(node, 2000000000);//shold be 2
        r = new int[3];
        i=0;
        while(result!=null){
            r[i++] = result.val;
            result = result.next;
        }
        assertEquals(Arrays.toString(new int[]{2,3,1}), Arrays.toString(r));

    }
}
