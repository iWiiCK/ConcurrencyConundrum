package CO3408;
/**
 *  @author Heshan Wickramaratne.
 *
 *  The 'OrphanedPresentCollector' class is used to collect all Orphaned presents.
 *  - Orphanced presents in this context are Presents that are in the machine but where the destination sack is FULL!.
 *  - This is used so that the Turntable does not get filled with these presents.
 *  - The MAX size is 'set' by using the 'Presents Count' from the Configuration Files.
 *  - 'OrphanCollectors' are connected with Turntables because a Present can become orphaned while it is on a belt
 *      when another present before that fills up the destination sack.
 *  - Because of this, the filtering does not happen while putting a present from the Hopper to a belt.
 * */
public class OrphanedPresentCollector
{
    private final Sack[] sacks;
    private Present[] presents;
    private int count = 0;

    public OrphanedPresentCollector(Sack[] sacks) {
        this.sacks = sacks;
    }

    // Method to see wheter a Sack is Empty or not given the SackId
    ///////////////////////////////////////////////////////////////////
    public synchronized boolean isSackFull(int sackId){
        for (Sack sack: sacks){
            if(sack.getSackId() == sackId){
                return sack.isFull();
            }
        }
        return false;
    }

    // Adding presents to the Orphan Collector
    ////////////////////////////////////////////
    public synchronized void add(Present present){
        presents[count] = present;
        count++;
    }

    // Getters and Setters
    //////////////////////////
    public synchronized Present[] getOrphanPresents(){
        return presents;
    }

    public int getCount() {
        return count;
    }

    public void setMaxAccumulation(int max){
        presents = new Present[max];
    }
}
