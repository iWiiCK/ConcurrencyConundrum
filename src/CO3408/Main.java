package CO3408;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Thread.sleep;
import java.util.Scanner;

/**
 *
 * @author Heshan Wickramaratne
 */
public class Main
{
    public static void main(String[] args) throws InterruptedException {

        // These variables will store the configuration of the Present sorting machine

        final String FILE_NAME = "scenario3.txt";
        
        int numBelts;
        Conveyor[] belts;

        int numHoppers;
        Hopper[] hoppers;

        int numSacks;
        Sack[] sacks;

        int numTurntables;
        Turntable[] tables;

        int timerLength;

        ////////////////////////////////////////////////////////////////////////
        
        // READ FILE
        // =========
        Scanner inputStream = null;
        try{
            inputStream = new Scanner(new File("src/Scenarios/" + FILE_NAME));
        }
        catch (FileNotFoundException ex){
            System.out.println("Error opening file");
            System.exit(0);
        }

        String line = "";

        // READ BELTS
        // ----------
        // Skip though any blank lines to start
        while (!line.startsWith("BELTS") && inputStream.hasNextLine()){
            line = inputStream.nextLine();
        }

        numBelts = inputStream.nextInt();
        inputStream.nextLine();

        belts = new Conveyor[numBelts];

        for (int b = 0; b < numBelts; b++){
            line = inputStream.nextLine(); // e.g. 1 length 5 destinations 1 2

            Scanner beltStream = new Scanner(line);
            int id = beltStream.nextInt();
            beltStream.next(); // skip "length"

            int length = beltStream.nextInt();
            belts[b] = new Conveyor(id, length);
            beltStream.next(); // skip "destinations"

            while (beltStream.hasNextInt()){
                int dest = beltStream.nextInt();
                belts[b].addDestination(dest);
            }
        } // end of reading belt lines

        // READ HOPPERS
        // ------------
        // Skip though any blank lines
        while (!line.startsWith("HOPPERS") && inputStream.hasNextLine()){
            line = inputStream.nextLine();
        }

        numHoppers = inputStream.nextInt();
        inputStream.nextLine();

        hoppers = new Hopper[numHoppers];

        for (int h = 0; h < numHoppers; h++){
            // Each hopper line will look like this:
            // e.g. 1 belt 1 capacity 10 speed 1

            int id = inputStream.nextInt();
            inputStream.next(); // skip "belt"

            int belt = inputStream.nextInt();
            inputStream.next(); // skip "capacity"

            int capacity = inputStream.nextInt();
            inputStream.next(); // skip "speed"

            int speed = inputStream.nextInt();
            line = inputStream.nextLine(); // skip rest of line

            hoppers[h] = new Hopper(id, belts[belt - 1], capacity, speed);
        } // end of reading hopper lines

        // READ SACKS
        // ------------
        // Skip though any blank lines
        while (!line.startsWith("SACKS") && inputStream.hasNextLine()){
            line = inputStream.nextLine();
        }

        numSacks = inputStream.nextInt();
        inputStream.nextLine();

        sacks = new Sack[numSacks];

        for (int s = 0; s < numSacks; s++){
            // Each sack line will look like this:
            // e.g. 1 capacity 20 age 0-3

            int id = inputStream.nextInt();
            inputStream.next(); // skip "capacity"

            int capacity = inputStream.nextInt();
            inputStream.next(); // skip "age"

            String age = inputStream.next();
            line = inputStream.nextLine(); // skip rest of line

            sacks[s] = new Sack(id, capacity, age);
            Turntable.destinations.put(age, id);
        } // end of reading sack lines

        // READ TURNTABLES
        // ---------------
        // Skip though any blank lines
        while (!line.startsWith("TURNTABLES") && inputStream.hasNextLine()){
            line = inputStream.nextLine();
        }

        numTurntables = inputStream.nextInt();
        inputStream.nextLine();

        tables = new Turntable[numTurntables];

        for (int t = 0; t < numTurntables; t++){
            // Each turntable line will look like this:
            // A N ib 1 E null S os 1 W null

            String tableId = inputStream.next();
            tables[t] = new Turntable(tableId);

            int connId;

            inputStream.next(); // skip "N"
            Connection north = null;
            String Ntype = inputStream.next();
            if (!"null".equals(Ntype)){
                connId = inputStream.nextInt();

                if (null != Ntype){
                    switch (Ntype) {
                        case "os" -> north = new Connection(ConnectionType.OutputSack, null, sacks[connId - 1]);
                        case "ib" -> north = new Connection(ConnectionType.InputBelt, belts[connId - 1], null);
                        case "ob" -> north = new Connection(ConnectionType.OutputBelt, belts[connId - 1], null);
                    }
                    tables[t].addConnection(Turntable.N, north);                    
                }
            }

            inputStream.next(); // skip "E"
            Connection east;
            String Etype = inputStream.next();

            if (!"null".equals(Etype)){
                connId = inputStream.nextInt();

                if (null != Etype){
                    east = switch (Etype) {
                        case "os" -> new Connection(ConnectionType.OutputSack, null, sacks[connId - 1]);
                        case "ib" -> new Connection(ConnectionType.InputBelt, belts[connId - 1], null);
                        default -> new Connection(ConnectionType.OutputBelt, belts[connId - 1], null);
                    };
                    tables[t].addConnection(Turntable.E, east);
                }
            }

            inputStream.next(); // skip "S"
            Connection south;
            String Stype = inputStream.next();

            if (!"null".equals(Stype)){
                connId = inputStream.nextInt();

                if (null != Stype){
                    south = switch (Stype) {
                        case "os" -> new Connection(ConnectionType.OutputSack, null, sacks[connId - 1]);
                        case "ib" -> new Connection(ConnectionType.InputBelt, belts[connId - 1], null);
                        default -> new Connection(ConnectionType.OutputBelt, belts[connId - 1], null);
                    };
                    tables[t].addConnection(Turntable.S, south);
                }
            }

            inputStream.next(); // skip "W"
            Connection west;
            String Wtype = inputStream.next();

            if (!"null".equals(Wtype)){
                connId = inputStream.nextInt();

                if (null != Wtype){
                    west = switch (Wtype) {
                        case "os" -> new Connection(ConnectionType.OutputSack, null, sacks[connId - 1]);
                        case "ib" -> new Connection(ConnectionType.InputBelt, belts[connId - 1], null);
                        default -> new Connection(ConnectionType.OutputBelt, belts[connId - 1], null);
                    };
                    tables[t].addConnection(Turntable.W, west);
                }
            }

            line = inputStream.nextLine(); // skip rest of line
        } // end of reading turntable lines

        // FILL THE HOPPERS
        // ----------------
        for (int i = 0; i < numHoppers; i++){
            // Skip though any blank lines
            while (!line.startsWith("PRESENTS") && inputStream.hasNextLine()){
                line = inputStream.nextLine();
            }

            int numPresents = inputStream.nextInt();
            inputStream.nextLine();

            for (int p = 0; p < numPresents; p++){
                hoppers[i].fill(new Present(inputStream.next()));
                line = inputStream.nextLine();
            }
        }

        // READ TIMER LENGTH
        // -----------------
        // Skip though any blank lines
        while (!line.startsWith("TIMER") && inputStream.hasNextLine()){
            line = inputStream.nextLine();
        }

        Scanner timerStream = new Scanner(line);
        timerStream.next(); // skip "length"
        timerLength = timerStream.nextInt();

        System.out.println("\nMachine will run for " + timerLength + "s.");
        System.out.println("-----------------------------------------------------\n");

        ///////////////////////////////////////////////////////////////////////
        // END OF SETUP ///////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////
        
        
        // START the hoppers!
        for (int h = 0; h < numHoppers; h++){
            hoppers[h].start();
        }

        // START the turntables!
        for (int t = 0; t < numTurntables; t++){
            tables[t].start();
        }

        long time = 0;
        long currentTime;
        long startTime = System.currentTimeMillis();

        System.out.println("/////////////////////////////////////////////////////");
        System.out.println("*** Machine Started ***");
        System.out.println("/////////////////////////////////////////////////////\n");

        while (time < timerLength){
            // sleep in 10 second bursts
            try{
                sleep(10000);
            }
            catch (InterruptedException ex){
                System.out.println("ERROR :: " + ex);
            }

            currentTime = System.currentTimeMillis();
            time = (currentTime - startTime) / 1000;
            System.out.println("\n=====================================================");
            System.out.println("Interim Report @ " + time + "s:");

            int giftsInSacks = Utils.countGiftsIn(sacks);
            int giftsInHoppers = Utils.countGiftsIn(hoppers);
            
            System.out.println(giftsInHoppers + " presents remaining in hoppers;\n" + giftsInSacks + " presents sorted into sacks.");
            System.out.println("=====================================================\n");

        }
        long endTime = System.currentTimeMillis();
        System.out.println("/////////////////////////////////////////////////////");
        System.out.println("*** Input Stopped after " + (endTime - startTime) / 1000 + "s. ***");
        System.out.println("/////////////////////////////////////////////////////");

        // Stop the hoppers!
        for(Hopper hopper : hoppers){
            hopper.stopHopper();
        }
        // Stop the tables!
        for(Turntable table : tables){
            table.stopTurntable();
        }

        // Wait for everything to finish...
        System.out.println();
        for(Hopper hopper : hoppers){
            hopper.join();
        }
        for(Turntable table : tables){
            table.join();
        }
        System.out.println();

        endTime = System.currentTimeMillis();
        System.out.println("/////////////////////////////////////////////////////");
        System.out.println("*** Machine completed shutdown after " + (endTime - startTime) / 1000 + "s. ***");
        System.out.println("/////////////////////////////////////////////////////");
        
        // FINAL REPORTING
        ////////////////////////////////////////////////////////////////////////

        System.out.println("\nFINAL REPORT");
        System.out.println("-----------------------------------------\n");
        System.out.println("Configuration: " + FILE_NAME);
        System.out.println("Total Run Time: " + (endTime - startTime) / 1000 + "s.");
        
        int giftsDeposited = Utils.countGiftsDeposited(hoppers);
        
        for (int h = 0; h < numHoppers; h++){
            System.out.println("Hopper " + hoppers[h].getHopperId() + " deposited " +giftsDeposited + " presents and waited " + (endTime - hoppers[h].getHopperEmptiedTimestamp())/1000 + "s.");
        }

        System.out.println();

        int giftsOnMachine = Utils.countGiftsIn(tables) + Utils.countGiftsIn(belts);
        int giftsInSacks = Utils.countGiftsIn(sacks);
        
        System.out.print("\nOut of " + giftsDeposited + " gifts deposited, ");
        System.out.print(giftsOnMachine + " are still on the machine, and ");
        System.out.println(giftsInSacks + " made it into the sacks");

        int missing = giftsDeposited - giftsInSacks - giftsOnMachine;
        System.out.println(missing + " gifts went missing.");
    }
}
