class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode a, TreeNode b) {

        // Both nodes are null
        if (a == null && b == null) {
            return true;
        }

        // One node is null
        if (a == null || b == null) {
            return false;
        }

        // Values are different
        if (a.val != b.val) {
            return false;
        }

        // Compare opposite sides
        return check(a.left, b.right) &&
               check(a.right, b.left);
    }
}