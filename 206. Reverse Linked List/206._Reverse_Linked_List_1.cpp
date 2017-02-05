class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        return recursive(head);
    }
    ListNode* recursive(ListNode* head) {
        if( !head || !(head->next) )    return head;
        ListNode* ans = recursive(head->next);
        head->next->next = head;
        head->next = NULL;
        return ans;
    }
};