package CO3408;

/**
 * @author Heshan Wickramaratne
 * Uclan ID: G20863503
 */
public class Hopper extends Thread
{
    // Volatile variable for storing the Hopper 'isRunning' state.
    private volatile boolean isRunning = true;
    private final int id;
    private final Conveyor belt;
    private final int speed;
    private final int capacity;
    private final Utils utils = new Utils();
    private long hopperEmptiedTimestamp = System.currentTimeMillis();
    private Present[] collection;
    // Total number of Presents in the Hopper
    private int count = 0;
    // Total Number of Presents Deposited from the Hopper.
    private int depositCount = 0;
    
    public Hopper(int id, Conveyor con, int capacity, int speed){
        collection = new Present[capacity];
        this.id = id;
        belt = con;
        this.speed = speed;
        this.capacity = capacity;
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
            System.out.println("### Hopper " + id + " STOPPED :: [Present Remaining :: " + count + "] ###");
        }
    }

    // Fill the hopper at the setup of the program
    //////////////////////////////////////////////
    public void fill(Present p){
        if(!isFull()){
            collection[count] = p;
            count++;
        }
        else{
            System.out.println("===========[Hopper " + id + " is FULL]============");
        }
    }

    // Depositing presents to the belt.
    ////////////////////////////////////////////
    public synchronized void deposit() throws InterruptedException {
        while(count < 1){
            if(isRunning){
                // Sleep thread if the Hopper becomes empty during Runtime.
                System.out.println("===========[Hopper " + id + " is EMPTY]===========");
                hopperEmptiedTimestamp = System.currentTimeMillis();
                wait();
            }else{
                // If not break from the loop.
                break;
            }
        }

        if(!belt.isFull() && isRunning){
            System.out.println("::: Hopper "+ id + " DEPOSITING :: Remaining [" + count + "]");
            belt.add(collection[0]);
            depositCount++;
            count--;
            collection = utils.popFirstAndReArrange(collection);
        }
        // Sleep time based on Hopper Speed.
        sleep(1000L/speed);
    }

    // Used to Stop the Thread once the Time is up for the Simulation
    ////////////////////////////////////////////////////////////////////
    public void stopHopper(){
        isRunning = false;
        // Wake all sleeping threads.
        // E.g. Hopper thread sleeps if the Hopper becomes empty during Runtime.
        synchronized (this){
            notifyAll();
        }
    }

    // Method to see whether the Hopper is Full or not
    ///////////////////////////////////////////////////
    public boolean isFull(){
        return count == capacity;
    }

    // Getters
    /////////////////
    public int getCount(){
        return count;
    }

    public int getHopperId(){
        return id;
    }

    public int getDepositCount() {
        return depositCount;
    }

    public long getHopperEmptiedTimestamp() {
        return count > 0 ? System.currentTimeMillis() : hopperEmptiedTimestamp;
    }
}