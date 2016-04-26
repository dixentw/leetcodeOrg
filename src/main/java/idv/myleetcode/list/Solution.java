package idv.myleetcode.list;

import java.util.*;
/**
 * Hello world!
 */
public class Solution{
    //203. Remove Linked List Elements
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode tmp = dummyHead;
        while(tmp.next!=null){
            if(tmp.next.val==val){
                tmp.next = tmp.next.next;
            }
            tmp = tmp.next;
        }
        return dummyHead.next;
    }
}
