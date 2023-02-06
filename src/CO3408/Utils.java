package CO3408;

public class Utils
{
    public <T> T[] popFirstAndReArrange(T[] collection){
        for (int i = 0; i < collection.length -1 ; i++){
            collection[i] = collection[i+1];
        }

        return collection;
    }

    //Return the count of Gifts in Sacks
    /////////////////////////////////////////////
    public static int countGiftsIn(Sack[] sacks){
        int giftsInSacks = 0;
        for (Sack sack : sacks) {
            giftsInSacks += sack.getCount();
        }

        return giftsInSacks;
    }

    //Return the count of Gifts in Hoppers
    /////////////////////////////////////////////
    public static int countGiftsIn(Hopper[] hoppers){
        int giftsInHoppers = 0;
        for(Hopper hopper : hoppers){
            giftsInHoppers += hopper.getCount();
        }

        return giftsInHoppers;
    }

    //Return the count of Gifts in Belts
    /////////////////////////////////////////////
    public static int countGiftsIn(Conveyor[] belts){
        int giftsOnBelts = 0;
        for(Conveyor belt : belts){
            giftsOnBelts += belt.getCount();
        }

        return giftsOnBelts;
    }

    //Return the count of Gifts in Turntables
    /////////////////////////////////////////////
    public static int countGiftsIn(Turntable[] tables){
        int giftsOnBelts = 0;
        for(Turntable table : tables){
            giftsOnBelts += table.getCount();
        }

        return giftsOnBelts;
    }

    //Return the count of Gifts in Hoppers
    /////////////////////////////////////////
    public static int countGiftsDeposited(Hopper[] hoppers){
        int giftsDeposited = 0;
        for(Hopper hopper : hoppers){
            giftsDeposited += hopper.getDepositCount();
        }

        return giftsDeposited;
    }
}
