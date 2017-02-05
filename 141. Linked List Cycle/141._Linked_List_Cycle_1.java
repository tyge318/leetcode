class Solution {
    public boolean hasCycle(ListNode head) {
        if( head == null || head.next == null )
            return false;
        ListNode fast = head, slow = head;
        while( fast != null) {
            fast = (fast.next == null) ? null : fast.next.next;
            slow = slow.next;
            if( fast == slow )
                return true;
        }
        return false;
    }
}