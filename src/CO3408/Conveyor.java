package CO3408;

import java.util.HashSet;
/**
 *
 * @author Heshan Wickramaratne
 */
public class Conveyor
{
    private final int id;
    private Present[] presents; // The requirements say this must be a fixed size array
    private final HashSet<Integer> destinations = new HashSet<>();
    private final int size;
    private int count = 0;
    private final CustomLock conveyorLock;
    private final Utils utils = new Utils();
    
    public Conveyor(int id, int size){
        this.id = id;
        this.presents = new Present[size];
        this.size = size;
        this.conveyorLock = new CustomLock("BELT_" + id + "_LOCK");
    }

    public void addDestination(int hopperID){
        destinations.add(hopperID);
    }

    public synchronized boolean isFull(){
        return count >= size;
    }

    //Adding presents to the Belt
    public synchronized void add(Present p ) throws InterruptedException {
        presents[count] = p;
        count++;
        System.out.println("Presents on Belt " + id + " :: "+ count);

        if(count == size){
            conveyorLock.lock();
        }
    }

    //Give the present added earliest to the Turntable.
    public synchronized Present requestPresent(){
        Present earliestPresent = presents[0];
        presents = utils.popFirstAndReArrange(presents);
        count--;
        conveyorLock.unlock();
        return earliestPresent;
    }

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
}
