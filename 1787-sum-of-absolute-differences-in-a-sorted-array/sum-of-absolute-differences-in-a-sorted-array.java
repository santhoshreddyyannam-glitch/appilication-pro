class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
     
        int[] ans = new int[nums.length];
        int totalsum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalsum = totalsum + nums[i];
        }
        int leftsum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightsum = totalsum - leftsum - nums[i];
            ans[i] = nums[i] * i - leftsum + rightsum - nums[i] * (nums.length - i - 1);
            leftsum += nums[i];

        }
        return ans;
    }
}
    
