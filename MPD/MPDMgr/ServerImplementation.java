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
import java.rmi.server.*;
import java.io.IOException;
import java.io.File;
import java.util.*;

public class ServerImplementation extends UnicastRemoteObject 
    implements ServerInterface {
    MPDManager mgr = null;

    public ServerImplementation(MPDManager m) throws RemoteException {
        super( );
        mgr = m;
    }

    public int getNumHosts() throws RemoteException {
        return mgr.getNumHosts();
    }

    public int exec(ClientInterface client, int nCPU, String[] cmd,
            Map<String, String> env, File dir) throws RemoteException {

        CallbackIOInterface callback = new ServerCallback(client);

        InvokeMPICommand icmd = new InvokeMPICommand(mgr, callback, env, dir);
        int ret = 0;
        try {
            ret = icmd.exec(nCPU, cmd);
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return ret;
    }

    private class ServerCallback implements CallbackIOInterface {
        ClientInterface client = null;

        ServerCallback(ClientInterface c) {
            client = c;
        }

        public void stdOut(String message) {
            try {
                client.remoteStdOut(message);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void stdErr(String message) {
            try {
                client.remoteStdErr(message);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        public boolean isReady() {
            boolean ret = false;
            try {
                ret = client.remoteIsReady();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return ret;
        }

        public String readLine() {
            String ret = null;
            try {
                ret = client.remoteReadLine();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return ret;
        }
    }
}

