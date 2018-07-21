import java.io.File;
import java.util.*;


public class Main {
    static class Route {
        Integer total;
        Integer endTime;
        List<Trip> trips = new ArrayList();

        public Route(Trip trip) {
            trips.add(trip);
            endTime = trip.startTime + trip.duration;
            total = trip.cost;
        }

        public boolean insertRoute(Trip trip) {
            if (endTime > trip.startTime)
                return false;
            trips.add(trip);
            endTime += trip.duration;
            total += trip.cost;
            return true;
        }
    }
    static public class Trip {
        Integer startTime;
        Integer cost;
        Integer duration;

        Trip(Integer[] input) {
            startTime = input[0];
            duration = input[2];
            cost = input[1];
        }
    }
    public static void main(String args[]){
        List<Route> routes = new ArrayList<>();

        try {
            Scanner input = new Scanner(new File("input.txt"));
            int m = input.nextInt();
            int n = 3;
            Integer[][] a = new Integer[m][n];
            while (input.hasNextLine()) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        try{
                            a[i][j] = input.nextInt();

                        }
                        catch (java.util.NoSuchElementException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            List<Trip> trips = new ArrayList<>();
            for (Integer[] src: a) {
                trips.add(new Trip(src));
            }
            Collections.sort(trips, Comparator.comparingInt(x -> x.startTime));
            Integer maxProfit = 0;
            int i, j;
            for(i = 0; i < trips.size(); ++i){
                routes.add(new Route(trips.get(i)));
                j = 0;
                while(j < trips.size()) {
                    if(i == j) {
                        j++;
                        continue;
                    }
                    if(!routes.get(i).insertRoute(trips.get(j)))
                        break;
                    j++;
                }
                maxProfit = Math.max(maxProfit,routes.get(i).total);
            }
            System.out.println(maxProfit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
