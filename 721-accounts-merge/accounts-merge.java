import java.util.*;

class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        int index = 0;

        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, index++);
                    emailToName.put(email, name);
                }
            }
        }

        int[] parent = new int[index];
        for (int i = 0; i < index; i++) parent[i] = i;

        for (List<String> acc : accounts) {
            int firstIndex = emailToIndex.get(acc.get(1));
            for (int i = 2; i < acc.size(); i++) {
                union(parent, firstIndex, emailToIndex.get(acc.get(i)));
            }
        }

        Map<Integer, List<String>> groups = new HashMap<>();

        for (String email : emailToIndex.keySet()) {
            int root = find(parent, emailToIndex.get(email));
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> emails : groups.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));

            List<String> merged = new ArrayList<>();
            merged.add(name);
            merged.addAll(emails);

            result.add(merged);
        }

        return result;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); 
        }
        return parent[x];
    }

    private void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}