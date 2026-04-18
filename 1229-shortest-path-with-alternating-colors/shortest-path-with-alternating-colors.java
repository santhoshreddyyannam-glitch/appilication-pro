import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        List<List<Integer>> redGraph = new ArrayList<>();
        List<List<Integer>> blueGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            redGraph.add(new ArrayList<>());
            blueGraph.add(new ArrayList<>());
        }

        for (int[] e : redEdges) {
            redGraph.get(e[0]).add(e[1]);
        }

        for (int[] e : blueEdges) {
            blueGraph.get(e[0]).add(e[1]);
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);

        boolean[][] visited = new boolean[n][2];

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0}); 
        queue.add(new int[]{0, 1}); 

        visited[0][0] = true;
        visited[0][1] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int color = curr[1];

                if (result[node] == -1) {
                    result[node] = steps;
                }

                if (color == 0) { 
                    for (int next : blueGraph.get(node)) {
                        if (!visited[next][1]) {
                            visited[next][1] = true;
                            queue.add(new int[]{next, 1});
                        }
                    }
                } else { 
                    for (int next : redGraph.get(node)) {
                        if (!visited[next][0]) {
                            visited[next][0] = true;
                            queue.add(new int[]{next, 0});
                        }
                    }
                }
            }

            steps++;
        }

        return result;
    }
}