package idv.myleetcode.list;

import java.util.*;
import idv.myleetcode.tree.TreeNode;

public class Solution{
    // 83
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
		ListNode prev = null;
		while(curr!=null){
			ListNode tmp = curr.next;
			if(prev!=null && prev.val==curr.val){
			    prev.next = tmp;
			}else{
                prev = curr;
            }
			curr = curr.next;
		}
        return head;
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
        ListNode start = dummy;
        for(int i=0; i<m-1; i++){
            start = start.next;
        }
        ListNode prev = null;
        ListNode curr = start.next;
        for(int i=0; i<=n-m; i++){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        start.next.next = curr;
        start.next = prev;
        return dummy.next;
    }
    //160. Intersection of Two Linked Lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        if(pa==null||pb==null){
            return null;
        }
        boolean exchangedA = false;
        boolean exchangedB = false;
        while(pa!=pb){
            pa = pa.next;
            if(pa==null){
                if(exchangedA){
                    pa = headA;
                }else{
                    pa = headB;
                    exchangedA = true;
                }
            }
            pb = pb.next;
            if(pb==null){
                if(exchangedB){
                    pb = headB;
                }else{
                    pb = headA;
                    exchangedB = true;
                }
            }
            if(pa==headA&&pb==headB){
                return null;
            }
        }
        return pa;
    }
    //148. Sort List
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(newHead);
        return mergeList(l1, l2);
    }
    private ListNode mergeList(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(0);
        ListNode p1 = h1;
        ListNode p2 = h2;
        ListNode cur = dummy;
        while(p1!=null && p2!=null){
            if(p1.val > p2.val){
                cur.next = p2;
                p2 = p2.next;
            }else{
                cur.next = p1;
                p1 = p1.next;
            }
            cur = cur.next;
        }
        if(p1==null){
            cur.next = p2;
        }
        if(p2==null){
            cur.next = p1;
        }
        return dummy.next;
    }
    //147. Insertion Sort List
    public ListNode insertionSortList(ListNode head) {
        ListNode d = new ListNode(0);
        ListNode i = d;
        ListNode j = head;
        ListNode n = null;
        while(j!=null){
            n = j.next;
            while(i.next !=null && i.next.val < j.val){
                i = i.next;
            }
            j.next = i.next;
            i.next = j;
            //reset
            i = d;
            j = n;
        }
        return d.next;
    }
    //82. Remove Duplicates from Sorted List II
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode tmp = d;
        while(tmp.next!=null){
            ListNode x = tmp.next;
            if(x==null){
                break;
            }
            while(x.next!=null&& x.val==x.next.val){
                x = x.next;
            }
            if(tmp.next!=x){ // x move, so there is some duplication
                tmp.next = x.next;
                x = tmp.next;
            }else{
                tmp = tmp.next;
            }
        }
        return d.next;
    }
    //143. Reorder List
    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode c = slow.next;
        slow.next = null;
        ListNode p = null;
        while(c!=null){
            ListNode n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        ListNode p1 = head;
        ListNode p2 = p;
        while(p1!=null){
            ListNode tmp = p1.next;
            p1 = p1.next = p2;
            p2 = tmp;
        }
    }
    //109. Convert Sorted List to Binary Search Tree
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        TreeNode node = new TreeNode(second.val);
        node.left = sortedListToBST(dummy.next);
        node.right = sortedListToBST(second.next);
        return node;
    }
    //86. Partition List
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy;
        ListNode right = rightDummy;
        while(head!=null){
            if(head.val < x){
                left.next = head;
                left = left.next;
            }else{
                right.next =head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }
    //142. Linked List Cycle II
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                while(slow!=entry){
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }
    //328. Odd Even Linked List
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode odd = oddDummy;
        ListNode even = evenDummy;
        int counter = 1;
        while(head!=null){
            if(counter%2==0){
                even.next = head;
                even = even.next;
            }else{
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
            counter++;
        }
        even.next = null;
        odd.next = evenDummy.next;
        return oddDummy.next;
    }
	// add two list not reverseed
	public ListNode addTwoNumberInorder(ListNode head1, ListNode head2){
		int size1 = getSize(head1);
		int size2 = getSize(head2);

		ListNode res= null;
		List<Integer> carry = new ArrayList<Integer>();

		if(size1 < size2){
			ListNode tmp = head1.next;
			head1.next = head2.next;
			head2.next = tmp;
			int s = size1;
			size1 = size2;
			size2 = s;
		}
		//pedding zero
		for(int i=0;i<size1-size2; i++){
			ListNode tmp = new ListNode(0);
			tmp.next = head2;
			head2 = tmp;
		}
		res	= addSameSizeList(head1, head2, carry);
		if(carry.size()>0){
			ListNode newHead = new ListNode(carry.get(0));
			newHead.next = res;
			res = newHead;
		}
		return res;

	}
	private int getSize(ListNode h){
		int result = 0;
		while(h!=null){
			result++;
			h = h.next;
		}
		return result;
	}
	private ListNode addSameSizeList(ListNode h1, ListNode h2, List<Integer> carry){
		if(h1==null||h2==null){
			return null;
		}
		ListNode res = new ListNode(0);
		res.next = addSameSizeList(h1.next, h2.next, carry);
		int sum = 0;
		if(carry.size()!=0){
			sum = h1.val+h2.val+carry.get(0);
			carry.remove(0);
		}else{
			sum = h1.val+h2.val;
		}
		if(sum>=10){
			carry.add(sum/10);
			sum = sum%10;
		}
		res.val = sum;
		return res;
	}
}
