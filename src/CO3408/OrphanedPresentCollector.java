package CO3408;

public class OrphanedPresentCollector
{
    private final Sack[] sacks;
    private Present[] presents;
    private int count = 0;

    public OrphanedPresentCollector(Sack[] sacks) {
        this.sacks = sacks;
    }

    public synchronized boolean isSackFull(int sackId){
        for (Sack sack: sacks){
            if(sack.getSackId() == sackId){
                return sack.isFull();
            }
        }
        return false;
    }

    public synchronized void add(Present present){
        presents[count] = present;
        count++;
    }

    public synchronized Present[] getOrphanPresents(){
        return presents;
    }

    public void setMaxAccumulation(int max){
        presents = new Present[max];
    }

    public int getCount() {
        return count;
    }
}
