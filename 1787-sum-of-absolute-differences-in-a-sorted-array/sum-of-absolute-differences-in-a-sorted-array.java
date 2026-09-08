class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Total sum of all elements
        int total = 0;
        for (int x : nums) {
            total += x;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            // Elements on the left
            int left = x * i - leftSum;

            // Elements on the right
            int right = (total - leftSum - x) - x * (n - i - 1);

            ans[i] = left + right;

            leftSum += x;
        }

        return ans;
    }
}