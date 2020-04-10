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
import java.io.*;
import java.util.*;

public class Client implements CallbackIOInterface {
    public static void main( String args[] ) {
        int nCPU = 0;
        int port = 0;

        // verify arguments
        try {
            if ( args.length >= 4 ) {
                port = Integer.parseInt( args[0] );
                nCPU = Integer.parseInt( args[2] );
                if ( port < 5001 || port > 65535 )
                    throw new Exception( );
            }
            else
                throw new Exception( );
        } catch ( Exception e ) {
            System.err.println( "usage: java Client port serverIp nCPU command <args>" );
            System.exit( -1 );
        }
        String serverIp = args[1];

        try {
            ServerInterface serverObject =  ( ServerInterface )
                Naming.lookup( "rmi://" + serverIp + ":" + port + "/server" );

            CallbackIOInterface callback = new Client();
            ClientInterface clientObject = new ClientImplementation(callback);

            String[] cmd = new String[args.length - 3];

            for (int i = 0; i < cmd.length; i++) {
                cmd[i] = args[i + 3];
            }

            // Get the client environment and working directory
            Map<String, String> env = System.getenv();

            // Make the map serializable
            HashMap<String, String> map = new HashMap<String, String>();
            map.putAll(env);
            File dir = new File("./MPI");
            dir = dir.getCanonicalFile();

            // Invoke a MPI program with the client environment and working directory
            serverObject.exec(clientObject, nCPU, cmd, map, dir);

            System.exit(0);
        }
        catch ( Exception e ) {
            e.printStackTrace( );
            System.exit( -1 );
        }
    }

    BufferedReader dataIn = null;

    public Client() {
        dataIn = new BufferedReader(new InputStreamReader(System.in));
    }

    public void stdOut(String message) {
        System.out.println(message);
    }

    public void stdErr(String message) {
        System.err.println(message);
    }

    public boolean isReady() {
        boolean ret = false;
        try {
            ret = dataIn.ready();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public String readLine() {
        String ret = null;
        try {
            ret = dataIn.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}


