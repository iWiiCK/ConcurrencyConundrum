package CO3408;

public class Utils
{
    public synchronized <T> T[] popFirstAndReArrange(T[] collection){
        for (int i = 0; i < collection.length -1 ; i++){
            collection[i] = collection[i+1];
        }
        collection[collection.length -1] = null;
        return collection;
    }

    //Return the count of Gifts in Sacks
    /////////////////////////////////////////////
    public synchronized static int countGiftsIn(Sack[] sacks){
        int giftsInSacks = 0;
        for (Sack sack : sacks) {
            giftsInSacks += sack.getCount();
        }

        return giftsInSacks;
    }

    //Return the count of Gifts in Hoppers
    /////////////////////////////////////////////
    public synchronized static int countGiftsIn(Hopper[] hoppers){
        int giftsInHoppers = 0;
        for(Hopper hopper : hoppers){
            giftsInHoppers += hopper.getCount();
        }

        return giftsInHoppers;
    }

    //Return the count of Gifts in Belts
    /////////////////////////////////////////////
    public synchronized static int countGiftsIn(Conveyor[] belts){
        int giftsOnBelts = 0;
        for(Conveyor belt : belts){
            giftsOnBelts += belt.getCount();
        }

        return giftsOnBelts;
    }

    //Return the count of Gifts in Turntables
    /////////////////////////////////////////////
    public synchronized static int countGiftsIn(Turntable[] tables){
        int giftsOnBelts = 0;
        for(Turntable table : tables){
            giftsOnBelts += table.getCount();
        }

        return giftsOnBelts;
    }

    //Return the count of Gifts in Hoppers
    /////////////////////////////////////////
    public synchronized static int countGiftsDeposited(Hopper[] hoppers){
        int giftsDeposited = 0;
        for(Hopper hopper : hoppers){
            giftsDeposited += hopper.getDepositCount();
        }

        return giftsDeposited;
    }

    //Method for Displaying final Report (Extended Report or the default one)
    ///////////////////////////////////////////////////////////////////////////
    public synchronized static void displayReport(boolean isExtednedReport, Long endTime, Hopper[] hoppers, Sack[] sacks, Turntable[] tables, Conveyor[] belts, OrphanedPresentCollector orphanedPresentCollector){
        int giftsDeposited = countGiftsDeposited(hoppers);

        for (Hopper hopper : hoppers){
            System.out.println("Hopper " + hopper.getHopperId() + " deposited " + hopper.getDepositCount() + " presents and waited " + (endTime - hopper.getHopperEmptiedTimestamp())/1000 + "s.");
        }

        if(isExtednedReport){
            for (Sack sack : sacks){
                System.out.println("Sack " + sack.getSackId() + "(Age Range: [" + sack.getAgeRange() + "]) is " + sack.getCount() + "/" + sack.getCapacity() + " Filled with Presents");
                if(sack.getCount() > 0 ){
                    for (Present present : sack.getAccumulation()){
                        if(present != null)
                            System.out.println(present.getAgeRange());
                    }
                }
            }

            for (Turntable table : tables){
                System.out.println("Table " + table.getTableId() + " has " + table.getCount() + " Presents on it");

                if(table.getCount() > 0){
                    for (Present present : table.getAccumulation()){
                        if(present != null)
                            System.out.println(present.getAgeRange());
                    }
                }
            }

            for (Conveyor belt : belts){
                System.out.println("Belt " + belt.getId() + " has " + belt.getCount() + " Presents on it");

                if(belt.getCount() > 0){
                    for (Present present : belt.getPresents()){
                        if(present != null)
                            System.out.println(present.getAgeRange());
                    }
                }
            }

            System.out.println("Orphanded Presents: " + orphanedPresentCollector.getCount());
            for (Present present: orphanedPresentCollector.getOrphanPresents()){
                if(present != null){
                    System.out.println(present.getAgeRange());
                }
            }
        }

        System.out.println();

        int giftsOnMachine = countGiftsIn(tables) + countGiftsIn(belts) + orphanedPresentCollector.getCount();
        int giftsInSacks = countGiftsIn(sacks);

        System.out.print("\nOut of " + giftsDeposited + " gifts deposited, ");
        System.out.print(giftsOnMachine + " are still on the machine, and ");
        System.out.println(giftsInSacks + " made it into the sacks");

        int missing = giftsDeposited - giftsInSacks - giftsOnMachine;
        System.out.println(missing + " gifts went missing.");
    }
}
