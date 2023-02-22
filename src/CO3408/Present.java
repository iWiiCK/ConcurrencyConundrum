package CO3408;

/**
 * @author Heshan Wickramaratne
 * Uclan ID: G20863503
 *
 * NOTE: Assignment Part 01, Page 03, Under Present Class it says... "The class needs to have
 *  attributes which store the type of toy, the age-group of child it is suitable for (i.e. its destination chute)...
 *  Although the configuration file did not have the type of presents in it. So I did not add the Present types here.
 *  left only the 'ageRange' as a property."
 */
public class Present
{
    private final String ageRange;

    public Present(String destination){
        ageRange = destination;
    }
    
    public String getAgeRange(){
        return ageRange;
    }
}
