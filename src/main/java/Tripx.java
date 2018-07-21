public class Tripx {
    Integer startTime;
    Integer cost;
    Integer duration;
    Tripx(Integer[] input){
        startTime = input[0];
        duration = input[2];
        cost = input[1];
    }
    @Override
    public String toString(){
        return startTime + " " + cost + " " + duration;
    }
}
