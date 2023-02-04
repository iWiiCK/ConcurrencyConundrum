
package CO3408;

import java.util.HashMap;
import java.util.*;

/**
 *
 * @author Nick
 */
public class Turntable extends Thread
{
    String id;

    static int N = 0;
    static int E = 1;
    static int S = 2;
    static int W = 3;
    
    Connection[] connections = new Connection[4];
        
    // global lookup: age-range -> SackID
    static HashMap<String, Integer> destinations = new HashMap<>();
    
    // this individual table's lookup: SackID -> output port
    HashMap<Integer, Integer> outputMap = new HashMap<>();
    
    public Turntable (String ID)
    {
        id = ID;
    }
    
    public void addConnection(int port, Connection conn)
    {
        connections[port] = conn;
        
        if(conn != null)
        {
            if(conn.connType == ConnectionType.OutputBelt)
            {
                Iterator<Integer> it = conn.belt.destinations.iterator();
                while(it.hasNext())
                {
                    outputMap.put(it.next(), port);
                }
            }
            else if(conn.connType == ConnectionType.OutputSack)
            {
                outputMap.put(conn.sack.id, port);
            }
        }
    }
    
    public void run()
    {
        // TODO
    }
}
