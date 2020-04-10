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
import java.io.File;
import java.util.*;

public interface ServerInterface extends Remote {
    public int getNumHosts() throws RemoteException;
    public int exec( ClientInterface client, int nCPU, String[] cmd,
            Map<String, String> env, File dir ) throws RemoteException;
}

