class UndergroundSystem {

    HashMap<Integer, String> station;
    HashMap<Integer, Integer> time;

    HashMap<String, Integer> totalTime;
    HashMap<String, Integer> count;

    public UndergroundSystem() {
        station = new HashMap<>();
        time = new HashMap<>();

        totalTime = new HashMap<>();
        count = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        station.put(id, stationName);
        time.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {

        String start = station.get(id);
        int startTime = time.get(id);

        int travelTime = t - startTime;

        String route = start + "#" + stationName;

        totalTime.put(route,
                totalTime.getOrDefault(route, 0) + travelTime);

        count.put(route,
                count.getOrDefault(route, 0) + 1);

        station.remove(id);
        time.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "#" + endStation;

        return (double) totalTime.get(route) / count.get(route);
    }
}