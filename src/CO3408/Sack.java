
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
    private final CustomLock sackLock = new CustomLock("sackLock");
    
    public Sack(int id, int capacity){
        accumulation = new Present[capacity];
        this.capacity = capacity;
        this.id = id;
    }

    public synchronized boolean isFull(){
        return count == capacity;
    }

    //Adding Presents to the Sack.
    public synchronized void add(Present p) throws InterruptedException {
        accumulation[count] = p;
        count++;

        if(isFull()){
            System.out.println("SACK " + id + " is FULL");
            sackLock.lock();
        }
    }

    public int getCount(){
        return count;
    }

    public int getSackId(){
        return id;
    }

    public CustomLock getSackLock() {
        return sackLock;
    }
}
