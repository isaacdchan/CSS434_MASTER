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

public interface ClientInterface extends Remote {
    public void remoteStdOut(String message) throws RemoteException;
    public void remoteStdErr(String message) throws RemoteException;
    public boolean remoteIsReady() throws RemoteException;
    public String remoteReadLine() throws RemoteException;
}

