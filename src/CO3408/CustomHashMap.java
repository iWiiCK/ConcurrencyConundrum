package CO3408;
import java.util.Arrays;

/**
 * @author Heshan Wickramaratne.
 * Uclan ID: G20863503
 *
 * This class represets a Custom hashmap I created for keeping track of Presents on belts and Turntables.
 * This is because the assignment has specified that we are not allowed to use Data structures other than arrays.
 * */
public class CustomHashMap <K, V>
{
    private final K[] keys;
    private final V[] values;
    private final int max;
    private int count = 0;
    
    public CustomHashMap(int max) {
        keys = initializeKeys(max);
        values = initializeValues(max);
        this.max = max;
    }

    //Custom put method
    ///////////////////////////////////////////////////
    public synchronized void put(K key, V value){
        Integer index =  findIndexOf(key);

        //If the Key exists, add new value to the same index
        if(index != null){
            keys[index] = key;
            values[index] = value;
            count++;
        }

        //Else check of the array has enough space before allocating a new index.
        else if(!isFull()){
            Integer freeIndex = findEmptySpace();
            if(freeIndex != null){
                keys[freeIndex] = key;
                values[freeIndex] = value;
                count++;
            }
        }
    }

    //This method checks whether there are Integer values higher a given Integer parameter
    ////////////////////////////////////////////////////////////////////////////////////////
    public synchronized boolean hasIntValsHigherThan(Integer limit){
        for(V value: values){
            if(value != null && (Integer)value > limit){
                return true;
            }
        }

        return false;
    }

    //Return the index of a Key
    ////////////////////////////////////
    private Integer findIndexOf(K key){
        for(int i = 0; i < keys.length; i++){
            if(key == keys[i]) return i;
        }

        return null;
    }

    //Check whether the Array has empty spaces (Null) to add a new Key
    ////////////////////////////////////////////////////////////////////
    private Integer findEmptySpace(){
        if(!isFull()){
            for(int i = 0; i < keys.length; i++){
                if(keys[i] == null) return i;
            }
        }

        return null;
    }

    //Returns whether the array is full or not
    ////////////////////////////////////////////
    public boolean isFull(){
        return count == max-1;
    }

    @SafeVarargs
    private K[] initializeKeys(int size, K... arr){
        return Arrays.copyOf(arr, size);
    }

    @SafeVarargs
    private V[] initializeValues(int size, V... arr){
        return Arrays.copyOf(arr, size);
    }
}