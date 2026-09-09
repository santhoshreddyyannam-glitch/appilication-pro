
class ThroneInheritance {

    String king;
    Map<String, List<String>> family;
    Set<String> dead;

    public ThroneInheritance(String kingName) {
        king = kingName;
        family = new HashMap<>();
        dead = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        family.putIfAbsent(parentName, new ArrayList<>());
        family.get(parentName).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();

        dfs(king, ans);

        return ans;
    }

    public void dfs(String person, List<String> ans) {

        if (!dead.contains(person)) {
            ans.add(person);
        }

        if (!family.containsKey(person)) {
            return;
        }

        for (String child : family.get(person)) {
            dfs(child, ans);
        }
    }
}