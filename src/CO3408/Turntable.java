
package CO3408;

import java.util.HashMap;
import java.util.*;

/**
 *
 * @author Heshan Wickramaratne
 */
public class Turntable extends Thread
{
    private final String id;
    static int N = 0;
    static int E = 1;
    static int S = 2;
    static int W = 3;
    
    private final Connection[] connections = new Connection[4];

    // global lookup: age-range -> SackID
    static HashMap<String, Integer> destinations = new HashMap<>();

    // this individual table's lookup: SackID -> output port
    private final HashMap<Integer, Integer> outputMap = new HashMap<>();
    private int count = 0;
    private volatile boolean isRunning = true;
    private boolean itemsRemainingInBelt = false;

    public Turntable (String ID){
        id = ID;
    }

    public void addConnection(int port, Connection conn){
        connections[port] = conn;
        
        if(conn != null){
            if(conn.getConnType() == ConnectionType.OutputBelt){
                Iterator<Integer> it = conn.getBelt().getDestinations().iterator();

                while(it.hasNext()){
                    outputMap.put(it.next(), port);
                }
            }
            else if(conn.getConnType() == ConnectionType.OutputSack){
                outputMap.put(conn.getSack().getSackId(), port);
            }
        }
    }

    //Adding a present from the turntable to a Sack
    //////////////////////////////////////////////////////
    private synchronized void addToSack(Sack sack, Present present) throws InterruptedException {
        if(!sack.isFull()){
            System.out.println("Adding to Sack " + sack.getSackId());
            sack.add(present);
            count--;
        }
        else{
            System.out.println("*** Sack " + sack.getSackId() + " is FULL :: Locking Sack " + sack.getSackId() + " ***");
            sack.getSackLock().lock();
        }
    }

    //Adding a present from the turntable to another Belt
    //////////////////////////////////////////////////////
    private synchronized void addToBelt(Conveyor belt, Present present) throws InterruptedException {
        if(!belt.isFull() && !belt.getConveyorLock().isLocked()){
            System.out.println("Adding to Belt " + belt.getId());
            belt.add(present);
            count--;
        }
        else{
            System.out.println("*** Belt " + belt.getId() + " is FULL :: Locking belt " + belt.getId() + " ***");
            belt.getConveyorLock().lock();
        }
    }

    //Driver method for the Turntable from inside the Run method
    ///////////////////////////////////////////////////////////////
    private synchronized boolean runTurntable() throws InterruptedException {
        Connection currentConnection, outputConnection;
        // Polling all connected input conveyor belts in turn
        for (int port = 0; port < 4; port++) {
            currentConnection = connections[port];

            if (currentConnection != null && currentConnection.getConnType() == ConnectionType.InputBelt) {
                if (currentConnection.getBelt().getCount() > 0 ) {
                    System.out.println("Turntable " + id + " requested Present");
                    Present currentPresent = currentConnection.getBelt().requestPresent();
                    count++;
                    //Simulating Present getting on the Turntable
                    long presentHandlingDelay = (long) (0.75 * 1000);
                    Thread.sleep(presentHandlingDelay);

                    //Using the Hashmaps for destination and port lookups.
                    String ageRange = currentPresent.getAgeRange();
                    int sackId = destinations.get(ageRange);
                    int outputPort = outputMap.get(sackId);

                    //Simulating time taken for the Turntable to rotate.
                    long rotationDelay = (long) (0.5 * 1000);
                    long totalRotationDelay =  (Math.abs(outputPort - port) * rotationDelay);
                    Thread.sleep(totalRotationDelay);

                    outputConnection = connections[outputPort];
                    //Simulating Present getting off the Turntable and into Sacks
                    if(outputConnection.getConnType() == ConnectionType.OutputSack){
                        addToSack(outputConnection.getSack(), currentPresent);
                        Thread.sleep(presentHandlingDelay);
                    }
                    //Simulating Present getting off the Turntable and into another belt
                    else if(outputConnection.getConnType() == ConnectionType.OutputBelt){
                        addToBelt(outputConnection.getBelt(), currentPresent);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /**
     * Thread Run Method
     * ////////////////////////////////////////////////
     * */
    public void run(){
        synchronized (this){
            while(isRunning || itemsRemainingInBelt){
                try {
                    itemsRemainingInBelt = runTurntable();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("***  Turntable " + id + " STOPPED :: [Present Remaining :: " + count + "] ***");
        }
    }

    //Used to Stop the Thread ones the Time is up for the Simulation
    ////////////////////////////////////////////////////////////////////
    public void stopTurntable(){
        isRunning = false;
    }

    public int getCount() {
        return count;
    }
}
