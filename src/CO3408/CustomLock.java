package CO3408;

/**
 * @author Heshan Wickramaratne.
 * Uclan ID: G20863503
 *
 * This class represets a simple Custom Lock created for Synchronization.
 * */
public class CustomLock
{
    private final String id;
    private boolean locked = false;
    public CustomLock(String id) {
        this.id = id;
    }

    // Custom lock method
    ///////////////////////////
    public synchronized void lock() throws InterruptedException {
        if(!locked){
            System.out.println("-----------------------------------------\n--------  " +
                    id + " :: LOCKED  --------\n-----------------------------------------");
            while (locked) {
                wait();
            }
            locked = true;
        }
    }

    // Custom Unlock method
    ///////////////////////////
    public synchronized void unlock() {
        if(locked){
            System.out.println("-----------------------------------------\n-------- " +
                    id + " :: UNLOCKED --------\n-----------------------------------------");
            locked = false;
            notifyAll();
        }
    }

    public boolean isLocked() {
        return locked;
    }
}