import java.util.*;

class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> fromCities = new HashSet<>();
        for (List<String> path : paths) {
            fromCities.add(path.get(0));
        }
        for (List<String> path : paths) {
            String city = path.get(1);
            if (!fromCities.contains(city)) {
                return city;
            }
        }
        return "";
    }
}
