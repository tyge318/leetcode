class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head, last = null, next;
        while( current != null) {
            next = current.next;
            current.next = last;
            last = current;
            current = next;
        }
        return last;
    }
}