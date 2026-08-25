import java.util.*;

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        // Store inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1, 
                     0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder,
                          int inStart, int inEnd,
                          int postStart, int postEnd) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        
        int rootIndex = map.get(rootValue);

        
        int leftSize = rootIndex - inStart;

       
        root.left = build(inorder, postorder,
                inStart, rootIndex - 1,
                postStart, postStart + leftSize - 1);

       
        root.right = build(inorder, postorder,
                rootIndex + 1, inEnd,
                postStart + leftSize, postEnd - 1);

        return root;
    }
}