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
}
