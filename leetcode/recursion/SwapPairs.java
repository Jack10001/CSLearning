package recursion;


// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class SwapPairs {
	   public ListNode swapPairs(ListNode head) {
	       if (head==null || head.next==null) return head;
	       
	       ListNode first=head;
	       ListNode second=head.next;
	       ListNode newHead=second;
	       ListNode temp=second.next;
	       second.next=first;
	       first.next=swapPairs(temp);
	       return newHead;
	   	}
	} 