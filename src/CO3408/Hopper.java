
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
    private Present[] collection;
    private int count = 0;
    private int depositCount = 0;
    private final int capacity;
    private boolean isRunning = true;
    private long hopperEmptiedTimestamp = System.currentTimeMillis();
    private final Utils utils = new Utils();
    
    public Hopper(int id, Conveyor con, int capacity, int speed){
        collection = new Present[capacity];
        this.id = id;
        belt = con;
        this.speed = speed;
        this.capacity = capacity;
    }

    //Fill the hopper at the setup of the program
    //////////////////////////////////////////////
    public void fill(Present p){
        if(!isFull()){
            collection[count] = p;
            count++;
        }
        else{
            System.out.println("Hopper " + id + " is FULL");
        }
    }

    /**
     * Thread Run Method
     * ////////////////////////////////////////////////
     * */
    public void run(){
        synchronized (this){
            while(isRunning){
                try {
                    deposit();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("\n=====================================================");
            System.out.println("*** Hopper " + id + " STOPPED ***");
            System.out.println("[Present Remaining :: " + count + "]");
            System.out.println("=====================================================\n");
        }
    }

    //Depositing presents to the belt.
    ////////////////////////////////////////////
    public synchronized void deposit() throws InterruptedException {
        while(count < 1){
            System.out.println("Hopper " + id + " is EMPTY");
            hopperEmptiedTimestamp = System.currentTimeMillis();

            if(isRunning)
                wait();
            break;
        }
        if(!belt.isFull() && isRunning){
            System.out.println("Hopper "+ id + " DEPOSITING");
            //Assuming speed is the deposit speed in seconds.
            // Ex: Speed 1 = presents are deposited every 1 second.
            sleep(speed * 1000L);

            belt.add(collection[0]);
            depositCount++;
            count--;
            collection = utils.popFirstAndReArrange(collection);
        }
    }

    public boolean isFull(){
        return count == capacity;
    }

    public int getCount(){
        return count;
    }

    public int getHopperId(){
        return id;
    }

    //Used to Stop the Thread ones the Time is up for the Simulation
    ////////////////////////////////////////////////////////////////////
    public synchronized void stopHopper(){
        isRunning = false;
        belt.getConveyorLock().unlock();
        notifyAll();
    }

    public int getDepositCount() {
        return depositCount;
    }

    public long getHopperEmptiedTimestamp() {
        return count > 0 ? System.currentTimeMillis() : hopperEmptiedTimestamp;
    }
}
