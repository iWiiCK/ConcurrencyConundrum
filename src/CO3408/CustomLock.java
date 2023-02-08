package CO3408;

public class CustomLock
{
    private final String id;
    private boolean locked = false;
    private final Object lock = new Object();

    public CustomLock(String id) {
        this.id = id;
    }

    public synchronized void lock() throws InterruptedException {
        if(!locked){
            System.out.println("-----------------------------------------\n--------  " + id + " :: LOCKED  --------\n-----------------------------------------");
            while (locked) {
                wait();
            }
            locked = true;
        }
    }

    public synchronized void unlock() {
        if(locked){
            System.out.println("-----------------------------------------\n-------- " + id + " :: UNLOCKED --------\n-----------------------------------------");
            locked = false;
            notifyAll();
        }
    }

    public boolean isLocked() {
        return locked;
    }

    public Object getLock() {
        return lock;
    }
}
