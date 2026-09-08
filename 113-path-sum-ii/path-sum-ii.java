import java.util.*;

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, ans);

        return ans;
    }

    public void dfs(TreeNode root, int targetSum,
                    List<Integer> path,
                    List<List<Integer>> ans) {

        if (root == null) {
            return;
        }

        // Add current node
        path.add(root.val);

        // Check if it is a leaf
        if (root.left == null && root.right == null) {

            if (root.val == targetSum) {
                ans.add(new ArrayList<>(path));
            }

        } else {

            // Go to left and right
            dfs(root.left, targetSum - root.val, path, ans);
            dfs(root.right, targetSum - root.val, path, ans);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }
}