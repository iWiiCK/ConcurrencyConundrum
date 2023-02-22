package CO3408;

import java.util.HashMap;
import java.util.HashSet;
/**
 *
 * @author Heshan Wickramaratne
 */
public class Conveyor
{
    private final int id;
    private final HashSet<Integer> destinations = new HashSet<>();
    private final CustomLock conveyorLock;
    private final Utils utils = new Utils();
    private final int size;
    private final CustomHashMap<Integer, Integer> beltPresentCountChecker;
    // Count of presents on the belt
    private int count = 0;
    // The requirements say this must be a fixed size array
    private Present[] presents;
    
    public Conveyor(int id, int size, CustomHashMap<Integer, Integer> beltPresentCountChecker){
        this.id = id;
        this.presents = new Present[size];
        this.size = size;
        this.conveyorLock = new CustomLock("BELT_" + id + "_LOCK");
        this.beltPresentCountChecker = beltPresentCountChecker;
    }

    // Method for adding destinations
    /////////////////////////////////////////
    public void addDestination(int hopperID){
        destinations.add(hopperID);
    }

    //Check whether the belt is Full or not
    //////////////////////////////////////////
    public synchronized boolean isFull(){
        return count >= size;
    }

    // Adding presents to the Belt
    ////////////////////////////////////////
    public synchronized void add(Present p ) throws InterruptedException {
        presents[count] = p;
        count++;
        beltPresentCountChecker.put(id, count);
        System.out.println("Presents on Belt " + id + " :: "+ count);

        if(count == size){
            conveyorLock.lock();
        }
    }

    // Give the present added earliest to the Turntable.
    ///////////////////////////////////////////////////////
    public synchronized Present requestPresent(){
        Present earliestPresent = presents[0];
        presents = utils.popFirstAndReArrange(presents);
        count--;
        beltPresentCountChecker.put(id, count);
        conveyorLock.unlock();
        return earliestPresent;
    }

    // A method for the Turntable to query what the next present inline is for it
    // This allows it to use the 'requestPresent' method ONLY when it's output port is open
    ///////////////////////////////////////////////////////////////////////////////////////////
    public synchronized Present queryPresent(){
        return presents[0];
    }

    // Getters
    /////////////////////
    public HashSet<Integer> getDestinations() {
        return destinations;
    }

    public CustomLock getConveyorLock(){
        return conveyorLock;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public Present[] getPresents() {
        return presents;
    }
}
