
package CO3408;

/**
 *
 * @author Heshan Wickramaratne
 */
public class Hopper extends Thread
{
    private final int id;
    private final Conveyor belt;
    private final int speed;
    private final Present[] collection;

    private int count = 0;

    private final int capacity;
    private boolean isRunning = true;
    
    public Hopper(int id, Conveyor con, int capacity, int speed){
        collection = new Present[capacity];
        this.id = id;
        belt = con;
        this.speed = speed;
        this.capacity = capacity;
    }
    
    public void fill(Present p){
        // TODO
        if(!isFull()){
            collection[count] = p;
            count++;
        }
        else{
            System.out.println("Hopper " + id + " is FULL");
        }
    }

    public void run(){
        // TODO
        synchronized (this){
            while(isRunning){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Hopper " + id + " STOPPED");
        }
    }
    
    // TODO Add more methods?
    public boolean isFull(){
        return count == capacity;
    }

    public int getCount(){
        return count;
    }

    public int getHopperId(){
        return id;
    }

    public synchronized void stopHopper(){
        isRunning = false;
        notifyAll();
    }
}
