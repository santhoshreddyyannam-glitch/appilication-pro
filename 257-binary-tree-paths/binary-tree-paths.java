import java.util.*;

class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();

        dfs(root, "", ans);

        return ans;
    }

    public void dfs(TreeNode root, String path, List<String> ans) {

        if (root == null) {
            return;
        }

        // Add current node to path
        if (path.equals("")) {
            path = "" + root.val;
        } else {
            path = path + "->" + root.val;
        }

        // If leaf, add the complete path
        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }

        // Explore left and right
        dfs(root.left, path, ans);
        dfs(root.right, path, ans);
    }
}