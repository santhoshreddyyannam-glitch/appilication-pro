import java.util.HashMap;

class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store inorder values and their indexes
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int left, int right) {

        // No elements
        if (left > right) {
            return null;
        }

        // First element in preorder is the root
        int value = preorder[index++];
        TreeNode root = new TreeNode(value);

        // Find root position in inorder
        int mid = map.get(value);

        // Build left subtree
        root.left = build(preorder, left, mid - 1);

        // Build right subtree
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}