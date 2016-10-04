package idv.myleetcode.list;

import java.util.*;
/**
 * Hello world!
 */
public class Solution{
    // 83
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmpHead = head;
		ListNode prev = null;
		while(head!=null){
			ListNode theNext = head.next;
			if(prev==null){
				prev = head;
			}else{
			    if(prev.val==head.val){
				    prev.next = theNext;
			    }else{
				    prev = head;
			    }
			}
			head = theNext;
		}
        return tmpHead;
    }

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
    //234. palidrome linked List
    public boolean isPalindrome(ListNode head){
        if(head==null){
            return true;
        }
        Stack<Integer> s = new Stack<Integer>();
        ListNode n = head;
        do{
            s.push(n.val);
            n = n.next;
        }while(n!=null);
        do{
            if(n.val!=s.pop()){
                return false;
            }
            n = n.next;
        }while(n != null);
        return true;
    }
    public boolean isPalindromeO1(ListNode head){
        if(head==null||head.next==null){
            return true;
        }
        ListNode s1 = head;
        ListNode s2 = head;
        while(s2.next!=null && s2.next.next!=null){
            s1 = s1.next;
            s2 = s2.next.next;
        }
        ListNode c = s1.next;
        ListNode p = null;
        ListNode n = null;
        while(c!=null){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        ListNode prev = head;
        while(p!=null){
            if(prev.val!=p.val){
                return false;
            }
            prev = prev.next;
            p = p.next;
        }
        return true;
    }
    //reverse practice
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode n = null;
        while(curr!=null){
            n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        return prev;
    }
    //merge sorted list
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(true){
            if(head1==null){
                tail.next = head2;
                break;
            }
            if(head2==null){
                tail.next = head1;
                break;
            }
            if(head1.val < head2.val){
                tail.next = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        return dummy.next;
    }
    //2. Add Two Numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int carry = 0;
        while(true){
            if(l1==null&&l2==null){
                if(carry!=0){
                    tail.next = new ListNode(carry);
                }else{
                    break;
                }
            }
            int v1=0;
            int v2=0;
            if(l1!=null){
                v1 = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1+v2+carry;
            if(sum >= 10){
                carry = 1;
                sum = sum%10;
            }else{
                carry = 0;
            }
            ListNode tmp = new ListNode(sum);
            tail.next = tmp;
            tail = tail.next;
        }
        return dummy.next;
   }
   //141. Linked List Cycle
   public boolean hasCycle(ListNode head) {
       ListNode step1 = head;
       ListNode step2 = head;
       while(step1!=null&&step2!=null&&step2.next!=null){
           step1 = step1.next;
           step2 = step2.next.next;
           if(step1==step2){
               return true;
           }
       }
       return false;
    }
    //19. Remove Nth Node From End of List
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> curs = new ArrayList<>();
        ListNode tmp = head;
        while(tmp!=null){
            curs.add(tmp);
            tmp = tmp.next;
        }
        ListNode dNode= curs.get(curs.size()-n);
        if(curs.size() - n <= 0){ // remove head
            return dNode.next;
        }else{
            ListNode pNode= curs.get(curs.size()-n-1);
            pNode.next = dNode.next;
            dNode = null;
        }
        return head;
    }
    //19. Remove Nth Node From End of List
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode normal = dummy;
        ListNode slow = dummy;
        for(int i=0; i<=n; i++){
            normal = normal.next;
        }
        while(normal!=null){
            slow = slow.next;
            normal = normal.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
    //24. Swap Nodes in Pairs
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while(curr.next!=null&&curr.next.next!=null){
            ListNode x = curr.next;
            ListNode y = curr.next.next;
            x.next = y.next;
            curr.next = y;
            y.next = x;
            curr = x;
        }
        return dummy.next;
    }
    //61. Rotate List
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode normal = dummy;
        ListNode slow = dummy;
        for(int i=0; i<k; i++){
            normal = normal.next;
            if(normal==null){
                normal = dummy;
                k = k%i;
                i = -1;
            }
        }
        while(normal.next!=null){
            normal = normal.next;
            slow = slow.next;
        }
        //slow not move, return origin
        if(slow==dummy){
            return slow.next;
        }
        normal.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
    //92. Reverse Linked List II
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        for(int i=0; i<m-1; i++){
            curr = curr.next;
        }
        ListNode prev = null;
        ListNode nx = null;
        ListNode tmp = curr.next;
        for(int i=0; i<=n-m; i++){
            nx = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = nx;
        }
        curr.next.next = tmp;
        curr.next = prev;
        return dummy.next;
    }
}
