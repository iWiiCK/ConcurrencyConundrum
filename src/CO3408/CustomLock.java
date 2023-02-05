package CO3408;

public class CustomLock
{
    private String id;
    private boolean locked = false;
    private final Object lock = new Object();

    public CustomLock(String id) {
        this.id = id;
    }

    public synchronized void lock() throws InterruptedException {
        System.out.println(id + " :: LOCKED");
        while (locked) {
            wait();
        }
        locked = true;
    }

    public synchronized void unlock() {
        if(locked){
            System.out.println(id + " :: UNLOCKED");
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
