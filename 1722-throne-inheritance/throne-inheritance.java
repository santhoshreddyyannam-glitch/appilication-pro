import java.util.*;

class ThroneInheritance {

    Map<String, List<String>> family;
    Set<String> dead;
    String king;

    public ThroneInheritance(String kingName) {
        king = kingName;
        family = new HashMap<>();
        dead = new HashSet<>();
        family.put(king, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        family.putIfAbsent(parentName, new ArrayList<>());
        family.get(parentName).add(childName);
        family.put(childName, new ArrayList<>());
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        dfs(king, result);
        return result;
    }
    
    private void dfs(String person, List<String> result) {
        if (!dead.contains(person)) {
            result.add(person);
        }
        for (String child : family.get(person)) {
            dfs(child, result);
        }
    }
}