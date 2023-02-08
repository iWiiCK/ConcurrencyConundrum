
package CO3408;

/**
 *
 * @author Heshan Wickramaratne
 */
public class Sack
{
    private final int id;
    private final Present[] accumulation;
    private final int capacity;
    private int count = 0;

    private final String ageRange;
    
    public Sack(int id, int capacity, String ageRange){
        accumulation = new Present[capacity];
        this.capacity = capacity;
        this.id = id;
        this.ageRange = ageRange;
    }

    public synchronized boolean isFull(){
        return count == capacity;
    }

    //Adding Presents to the Sack.
    public synchronized void add(Present p) {
        accumulation[count] = p;
        count++;

        if(isFull()){
            System.out.println("==========[SACK " + id + " is now FULL]===========");
        }
    }

    public int getCount(){
        return count;
    }

    public int getSackId(){
        return id;
    }

    public String getAgeRange() {
        return ageRange;
    }
}
