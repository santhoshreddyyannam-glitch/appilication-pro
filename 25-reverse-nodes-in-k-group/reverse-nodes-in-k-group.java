class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        // Step 1: check if k nodes exist
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If we have k nodes, reverse them
        if (count == k) {
            curr = reverseKGroup(curr, k); // reverse rest

            // Step 2: reverse current k group
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }
            head = curr;
        }

        return head;
    }
}