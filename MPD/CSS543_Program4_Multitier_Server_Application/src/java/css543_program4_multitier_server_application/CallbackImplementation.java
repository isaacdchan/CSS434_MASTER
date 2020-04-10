/*
 * CSS 543 - Program 4: Multitier Server Application
 * December 14, 2009
 * @author Fumitaka Kawasaki
 */

package css543_program4_multitier_server_application;

import MPDMgr.*;
import java.net.*;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.Serializable;
import java.rmi.*;

/**
 *
 * @author fumitakakawasaki
 */
public class CallbackImplementation implements CallbackIOInterface, Serializable {
    private int port;
    private Socket socket = null;
    private Thread serverRun = null;;
    private DataOutputStream output = null;
    private BufferedReader input = null;
    private SessionBean1 session = null;

    public CallbackImplementation(SessionBean1 s) {
        session = s;
    }

    public void init(int p) {
        port = p;
        Runnable serverThread = new Runnable() {
            public void run() {
                try {
                    ServerSocket server = new ServerSocket(port);
                    socket = server.accept();
                    output = new DataOutputStream(socket.getOutputStream());
                    input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                // Get RMI server and client object
                ServerInterface serverObject = session.getServerObject();
                ClientInterface clientObject = session.getClientObject();

                // Get invoking parameters
                int nCPU = session.getUser().getnCPU();
                String[] cmd = session.getUser().getCmd();

                // Get the working directory of the user
                File udir = session.getUser().getUserDir();

                // Call invoke() in RMI server
                try {
                    serverObject.exec(clientObject, nCPU, cmd, null, udir);
                } catch (RemoteException e) {
                    e.printStackTrace( );
                }
            }
        };

        serverRun = new Thread(serverThread);
        serverRun.start();
    }

    public void close() {
        try {
            if (output != null) {
                output.close();
            }
            if (input != null) {
                input.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stdOut(String message) {
        if (output != null) {
            try {
                output.writeUTF(message);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stdErr(String message) {
        if (output != null) {
            try {
                output.writeUTF(message);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isReady() {
        boolean  ret = false;
        try {
            ret = input.ready();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public String readLine() {
        char[] cbuf = new char[1024];
        int len;
        String line = null;
        try {
            len = input.read(cbuf, 0, cbuf.length);
            line = new String(cbuf, 0, len);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
