
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
    
    public Sack(int id, int capacity){
        accumulation = new Present[capacity];
        this.capacity = capacity;
        this.id = id;
    }

    //TODO - Add more methods
    public synchronized boolean isFull(){
        return count == capacity;
    }

    //Adding Presents to the Sack.
    public synchronized void add(Present p){
        if(!isFull()){
            accumulation[count] = p;
            count++;
        }
        else{
            System.out.println("SACK " + id + " is FULL");
        }
    }

    public int getCount(){
        return count;
    }

    public int getSackId(){
        return id;
    }
}
