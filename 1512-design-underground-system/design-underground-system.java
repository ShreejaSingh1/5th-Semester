import java.util.*;

class UndergroundSystem {
    private Map<Integer, CheckInData> checkIns;
    
    private Map<String, TravelData> travelTimes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        travelTimes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData checkInData = checkIns.get(id);
        checkIns.remove(id);

        String routeKey = checkInData.station + "->" + stationName;
        int travelTime = t - checkInData.time;

        TravelData data = travelTimes.getOrDefault(routeKey, new TravelData(0, 0));
        data.totalTime += travelTime;
        data.count += 1;
        travelTimes.put(routeKey, data);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        TravelData data = travelTimes.get(routeKey);
        return (double) data.totalTime / data.count;
    }
    private static class CheckInData {
        String station;
        int time;

        CheckInData(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
    private static class TravelData {
        int totalTime;
        int count;

        TravelData(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */