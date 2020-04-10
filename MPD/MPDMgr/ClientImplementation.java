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

public class ClientImplementation extends UnicastRemoteObject
    implements ClientInterface {
    private CallbackIOInterface callback = null;

    public ClientImplementation(CallbackIOInterface c) throws RemoteException {
        super( );
        callback = c;
    }

    public void remoteStdOut(String message) throws RemoteException {
        callback.stdOut(message);
    }

    public void remoteStdErr(String message) throws RemoteException {
        callback.stdErr(message);
    }

    public boolean remoteIsReady() throws RemoteException {
        return callback.isReady();
    }

    public String remoteReadLine() throws RemoteException {
        return callback.readLine();
    }
}

