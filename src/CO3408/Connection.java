package CO3408;

/**
 *
 * @author Heshan Wickramaratne
 */
public class Connection {
    private final ConnectionType connType;
    private final Conveyor belt;
    private final Sack sack;
    
    public Connection(ConnectionType ct, Conveyor c, Sack s){
        connType = ct;
        belt = c;
        sack = s;
    }

    public ConnectionType getConnType() {
        return connType;
    }

    public Conveyor getBelt() {
        return belt;
    }

    public Sack getSack() {
        return sack;
    }
}
