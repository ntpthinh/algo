
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

    public ListNode middleNode(ListNode head) {
        // int l = 1;
        // ListNode temp = head;
        // while(temp.next!=null){
        // l++;
        // temp = temp.next;
        // }
        // temp = head;
        // // if(l%2==0)
        // // l = l/2;
        // // else l = l/2+1;
        // for(int i = 0; i<l/2;i++){
        // temp = temp.next;
        // }
        // return temp;
        if (head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}