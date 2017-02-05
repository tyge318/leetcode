class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* current = head;
        while( current && current->next ) {
            if( current->val == current->next->val ) {
                auto next = current->next;
                current->next = next->next;
                delete next;
                continue;
            }
            current = current->next;
        }
        return head;
    }
};