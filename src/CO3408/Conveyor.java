package CO3408;

import java.util.HashSet;
/**
 *
 * @author Heshan Wickramaratne
 */
public class Conveyor
{
    int id;
    private Present[] presents; // The requirements say this must be a fixed size array
    public  HashSet<Integer> destinations = new HashSet();
    
    // TODO - add more members?
    
    public Conveyor(int id, int size){
        this.id = id;
        presents = new Present[size];
        
        //TODO - more construction likely!
    }

    public void addDestination(int hopperID){
        destinations.add(hopperID);
    }

    // TODO - add more functions
    
}
