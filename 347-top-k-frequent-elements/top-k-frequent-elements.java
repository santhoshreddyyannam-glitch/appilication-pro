import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Min heap based on frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        // Add elements to heap
        for (int n : map.keySet()) {
            pq.offer(n);

            // Keep only k elements
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Store answer
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}