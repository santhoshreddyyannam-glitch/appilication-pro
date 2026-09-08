import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {

            pq.offer(n);

            // Keep only k elements
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}