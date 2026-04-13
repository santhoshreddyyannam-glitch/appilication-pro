import java.util.*;

class UndergroundSystem {

    // Store check-in: id -> (station, time)
    Map<Integer, Pair> checkInMap;

    // Store route data: "start-end" -> (totalTime, count)
    Map<String, int[]> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair p = checkInMap.get(id);
        checkInMap.remove(id);
        
        String key = p.station + "-" + stationName;
        int time = t - p.time;
        
        routeMap.putIfAbsent(key, new int[2]);
        routeMap.get(key)[0] += time;   // total time
        routeMap.get(key)[1] += 1;      // count
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        int[] data = routeMap.get(key);
        return (double) data[0] / data[1];
    }
}

// Helper class
class Pair {
    String station;
    int time;
    
    Pair(String station, int time) {
        this.station = station;
        this.time = time;
    }
}