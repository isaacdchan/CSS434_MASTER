package MPDMgr;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fumitakakawasaki
 */
import java.rmi.*;
import java.rmi.registry.*;
import java.io.File;

public class Server {
    public static void main( String args[] ) {
        // verify arguments
        int port = 0;
        try {
            if ( args.length == 1 ) {
                port = Integer.parseInt( args[0] );
                if ( port < 5001 || port > 65535 )
                    throw new Exception( );
            }
            else
                throw new Exception( );
        } catch ( Exception e ) {
            System.err.println( "usage: java Server port" );
            System.exit( -1 );
        }

        MPDManager mgr = null;
        try {
            //startRegistry( port );

            // Create a MPD manager object
            File mdir = new File("./MPD");
            mgr = new MPDManager(mdir);

            // Initialize the MPD hosts table, and create a mpd.hosts file
            mgr.initHostsTable();

            // Start the MPD daemon
            mgr.startDaemon();

            // Create a server object
            ServerImplementation serverObject = new ServerImplementation(mgr);
            Naming.rebind( "rmi://localhost:" + port + "/server",
                           serverObject );
            System.out.println( "Server ready." );
        } 
        catch ( Exception e ) {
            e.printStackTrace( );
            System.exit( -1 );
        }
    }

    private static void startRegistry( int port ) throws RemoteException {
        try {
            Registry registry =
                LocateRegistry.getRegistry( port );
            registry.list( );
        }
        catch ( RemoteException e ) {
            Registry registry =
                LocateRegistry.createRegistry( port );
        }
    }
}
