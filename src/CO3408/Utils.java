package CO3408;

public class Utils
{
    public <T> T[] popFirstAndReArrange(T[] collection){
        for (int i = 0; i < collection.length -1 ; i++){
            collection[i] = collection[i+1];
        }

        return collection;
    }
}
