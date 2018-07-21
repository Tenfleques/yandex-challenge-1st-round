import java.util.ArrayList;
import java.util.List;

public class Routex {
    Integer total;
    Integer endTime;
    List<Tripx> trips = new ArrayList();
    public Routex(Tripx trip){
        trips.add(trip);
        endTime = trip.startTime + trip.duration;
        total = trip.cost;
    }
    public boolean insertRoute(Tripx trip){
        //System.out.println(endTime + " => " + trip.startTime);
        if(endTime > trip.startTime)
            return false;
        trips.add(trip);
        endTime += trip.duration;
        total += trip.cost;
        return true;
    }
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Tripx t : trips){
            s.append(t);
            s.append("\n\t");
        }
        return s.toString();
    }
}
