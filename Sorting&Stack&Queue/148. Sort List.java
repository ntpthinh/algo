
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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode middle = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode head = null, tail = null;
        while (left != null && right != null) {
            if (left.val < right.val) {
                if (head == null) {
                    head = left;
                    tail = left;
                } else {
                    tail.next = left;
                    tail = tail.next;
                }
                left = left.next;
            } else {
                if (head == null) {
                    head = right;
                    tail = right;
                } else {
                    tail.next = right;
                    tail = tail.next;
                }
                right = right.next;
            }
        }
        if (left != null) {
            tail.next = left;
        } else
            tail.next = right;
        return head;

    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode middle = slow.next;
        slow.next = null;
        return middle;
    }
}