
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
    //Max accumulation can be 4 for the 4 ports
    private Present[] accumulation = new Present[4];
    private final Utils utils = new Utils();
    private final OrphanedPresentCollector orphanedPresentCollector;

    public Turntable (String ID, OrphanedPresentCollector orphanedPresentCollector){
        id = ID;
        this.orphanedPresentCollector = orphanedPresentCollector;
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
    private void addToSack(Sack sack, Present present, int outputPort) throws InterruptedException {
        if(!sack.isFull()){
            System.out.println("--> Table " + id + " Adding [" + present.getAgeRange() + "] Present to Sack " + sack.getSackId() + " (Age Range: [" + sack.getAgeRange() + "])");
            sack.add(present);
            accumulation[outputPort] = null;
            count--;
        }
        else{
            System.out.println("*** Sack " + sack.getSackId() + " is FULL :: Cannot Add Present ***");
        }
    }

    //Adding a present from the turntable to another Belt
    //////////////////////////////////////////////////////
    private void addToBelt(Conveyor belt, Present present, int outputPort) throws InterruptedException {
        if(!belt.isFull() && !belt.getConveyorLock().isLocked()){
            System.out.println("--> Table " + id + " Adding to Belt " + belt.getId());
            belt.add(present);
            accumulation[outputPort] = null;
            count--;
        }
        else{
            System.out.println("*** Belt " + belt.getId() + " is FULL :: cannot Add Present ***");
            belt.getConveyorLock().lock();
        }
    }

    private void cleanOrphanPresents(Present present, int port){
        orphanedPresentCollector.add(present);
        accumulation[port] = null;
        count--;
    }

    //Driver method for the Turntable from inside the Run method
    ///////////////////////////////////////////////////////////////
    private synchronized boolean runTurntable() throws InterruptedException {
        Connection currentConnection, outputConnection;
        Present currentPresent;
        int sackId;
        int outputPort;
        long presentHandlingDelay = (long) (0.75 * 1000);
        // Polling all connected input conveyor belts in turn
        for (int port = 0; port < 4; port++) {
            currentConnection = connections[port];

            if (currentConnection != null && currentConnection.getConnType() == ConnectionType.InputBelt) {
                if (currentConnection.getBelt().getCount() > 0 && accumulation[port] == null) {
                    currentPresent = currentConnection.getBelt().requestPresent(id);
                    accumulation[port] = currentPresent;
                    count++;
                    //Simulating Present getting on the Turntable
                    Thread.sleep(presentHandlingDelay);

                    //Using the Hashmaps for destination and port lookups.
                    String ageRange = currentPresent.getAgeRange();
                    sackId = destinations.get(ageRange);
                    outputPort = outputMap.get(sackId);

                    //Orphan Gift Check
                    if(orphanedPresentCollector.isSackFull(sackId)){
                        cleanOrphanPresents(currentPresent, port);
                    }
                    else if(accumulation[outputPort] == null){
                        //Simulating time taken for the Turntable to rotate.
                        long rotationDelay = (long) (0.5 * 1000);
                        long totalRotationDelay =  (Math.abs(outputPort - port) * rotationDelay);
                        accumulation[port] = null;
                        accumulation[outputPort] = currentPresent;
                        Thread.sleep(totalRotationDelay);

                        outputConnection = connections[outputPort];
                        //Simulating Present getting off the Turntable and into Sacks
                        if(outputConnection.getConnType() == ConnectionType.OutputSack){
                            addToSack(outputConnection.getSack(), currentPresent, outputPort);
                            Thread.sleep(presentHandlingDelay);
                        }
                        //Simulating Present getting off the Turntable and into another belt
                        else if(outputConnection.getConnType() == ConnectionType.OutputBelt){
                            addToBelt(outputConnection.getBelt(), currentPresent, outputPort);
                            Thread.sleep(presentHandlingDelay);
                        }
                    }
                    return true;
                }
                return false;
            }
            else if (currentConnection != null && currentConnection.getConnType() == ConnectionType.OutputBelt){
                currentPresent = accumulation[port];

                if(currentPresent != null){
                    sackId = destinations.get(currentPresent.getAgeRange());
                    if(orphanedPresentCollector.isSackFull(sackId)){
                        cleanOrphanPresents(currentPresent, port);
                    }
                    else{
                        addToBelt(currentConnection.getBelt(), currentPresent, port);
                        Thread.sleep(presentHandlingDelay);
                    }
                }
            }
            else if (currentConnection != null && currentConnection.getConnType() == ConnectionType.OutputSack){
                currentPresent = accumulation[port];

                if(currentPresent != null){
                    sackId = currentConnection.getSack().getSackId();
                    if(orphanedPresentCollector.isSackFull(sackId)){
                        cleanOrphanPresents(currentPresent, port);
                    }
                    else{
                        addToBelt(currentConnection.getBelt(), currentPresent, port);
                        Thread.sleep(presentHandlingDelay);
                    }
                }
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
            System.out.println("### Turntable " + id + " STOPPED :: [Present Remaining :: " + count + "] ###");
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

    public String getTableId() {
        return id;
    }

    public Present[] getAccumulation() {
        return accumulation;
    }
}
