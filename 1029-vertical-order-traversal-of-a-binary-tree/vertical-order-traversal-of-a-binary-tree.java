import java.util.*;

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // col -> list of {row, value}
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        dfs(root, 0, 0, map);

        List<List<Integer>> ans = new ArrayList<>();

        for (List<int[]> list : map.values()) {

            // Sort by row, then by value
            Collections.sort(list, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });

            List<Integer> temp = new ArrayList<>();

            for (int[] x : list) {
                temp.add(x[1]);
            }

            ans.add(temp);
        }

        return ans;
    }

    public void dfs(TreeNode root, int row, int col,
                    TreeMap<Integer, List<int[]>> map) {

        if (root == null) {
            return;
        }

        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new int[]{row, root.val});

        // Left child
        dfs(root.left, row + 1, col - 1, map);

        // Right child
        dfs(root.right, row + 1, col + 1, map);
    }
}