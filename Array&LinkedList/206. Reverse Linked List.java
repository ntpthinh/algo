class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // iterative
        // ListNode cur = head;
        // ListNode prev = null;
        // while(cur != null){
        // ListNode temp = cur.next;
        // cur.next = prev;
        // prev = cur;
        // cur = temp;
        // }
        // return prev;

        // recursive
        ListNode next = head.next;
        ListNode rest = reverseList(next);
        next.next = head;
        head.next = null;
        return rest;
    }

}