package CO3408;

/**
 * @author Heshan Wickramaratne
 * Uclan ID: G20863503
 */
public class Sack
{
    private final int id;
    private final Present[] accumulation;
    private final int capacity;
    private final String ageRange;
    private int count = 0;
    
    public Sack(int id, int capacity, String ageRange){
        accumulation = new Present[capacity];
        this.capacity = capacity;
        this.id = id;
        this.ageRange = ageRange;
    }

    // Adding Presents to the Sack.
    ////////////////////////////////
    public synchronized void add(Present p) {
        accumulation[count] = p;
        count++;

        if(isFull()){
            System.out.println("==========[SACK " + id + " is now FULL]===========");
        }
    }

    // Method for checking whether the Sack is full or not
    ////////////////////////////////////////////////////////
    public synchronized boolean isFull(){
        return count == capacity;
    }

    // Getters
    ////////////
    public int getCount(){
        return count;
    }

    public int getSackId(){
        return id;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public int getCapacity() {
        return capacity;
    }

    public Present[] getAccumulation() {
        return accumulation;
    }
}