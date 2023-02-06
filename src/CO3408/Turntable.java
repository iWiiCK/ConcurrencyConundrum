
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
    private final Sack[] sacks;
    private int count = 0;
    private boolean isRunning = true;

    private boolean isIdle = true;

    private boolean spinned = false;

    public Turntable (String ID, Sack[] sacks){
        id = ID;
        this.sacks = sacks;
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
    private synchronized void addToSack(int sackId, Present present){
        System.out.println("Adding to Sack " + sackId);
        for(Sack sack : sacks){
            //Add only if the sack has space.
            if(sack.getSackId() == sackId){
                if(!sack.isFull()){
                    sack.add(present);
                    break;
                }else{
                    System.out.println("Sack " + id + " is FULL");
                }
            }
        }
    }

    //Driver method for the Turntable from inside the Run method
    ///////////////////////////////////////////////////////////////
    private synchronized void runTurntable() throws InterruptedException {
        // Polling all connected input conveyor belts in turn
        for (int port = 0; port < 4; port++) {
            Connection currentConnection = connections[port];

            if (currentConnection != null && currentConnection.getConnType() == ConnectionType.InputBelt) {
                if (currentConnection.getBelt().getCount() > 0) {
                    isIdle = false;
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

                    //Simulating Present getting off the Turntable and into Sacks
                    addToSack(sackId, currentPresent);
                    count--;
                    Thread.sleep(presentHandlingDelay);
                }
                else{
                    isIdle = true;
                }
            }
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
                    if(!isIdle) spinned = true;
                    if(spinned && isIdle){
                        break;
                    }
                    runTurntable();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("\n=====================================================");
            System.out.println("Turntable " + id + " STOPPED");
            System.out.println("[Present Remaining :: " + count + "]");
            System.out.println("=====================================================\n");
        }
    }

    //Used to Stop the Thread ones the Time is up for the Simulation
    ////////////////////////////////////////////////////////////////////
    public synchronized void stopTurntable(){
        isRunning = false;
        notifyAll();
    }

    public int getCount() {
        return count;
    }
}
