package CO3408;

public class CustomLock
{
    private boolean locked = false;
    private Object lock = new Object();

    public synchronized void lock() throws InterruptedException {
        while (locked) {
            wait();
        }
        locked = true;
    }

    public synchronized void unlock() {
        locked = false;
        notifyAll();
    }

    public boolean isLocked() {
        return locked;
    }

    public Object getLock() {
        return lock;
    }
}
