package idv.myleetcode.list;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class SolutionTest {
    Solution s = new Solution();
    private void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val + " => ");
            head = head.next;
        }
    }
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
        printList(s.removeElements(n1, 1));
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
            System.out.println(h.val);
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
            System.out.println(h.val);
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
        while(h!=null){
            System.out.print(h.val+", ");
            h = h.next;
        }
        System.out.println();
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
}
