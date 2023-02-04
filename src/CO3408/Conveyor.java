package CO3408;

import java.util.HashSet;
/**
 *
 * @author Heshan Wickramaratne
 */
public class Conveyor
{
    private final int id;
    private final Present[] presents; // The requirements say this must be a fixed size array
    private final HashSet<Integer> destinations = new HashSet();
    
    // TODO - add more members?
    private final int size;
    private int count = 0;
    
    public Conveyor(int id, int size){
        this.id = id;
        this.presents = new Present[size];
        
        //TODO - more construction likely!
        this.size = size;
    }

    public void addDestination(int hopperID){
        destinations.add(hopperID);
    }

    // TODO - add more functions
    public boolean isFull(){
        return count == size;
    }

    public void add(Present p ){
        if(!isFull()){
            presents[count] = p;
            count++;
        }
        else{
            System.out.println("Conveyor " + id + " is FULL");
        }
    }

    public HashSet<Integer> getDestinations() {
        return destinations;
    }
}
