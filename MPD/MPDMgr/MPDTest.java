package MPDMgr;

import java.lang.String;
import java.io.File;
import java.io.IOException;

public class MPDTest implements CallbackIOInterface {
    public static void main(String args[]) {
        File dir = new File("./MPI");
        MPDManager mgr = new MPDManager(dir);

        mgr.initHostsTable();
        int nHosts = mgr.getNumHosts();
        System.out.println("Number of hosts = " + nHosts);
        mgr.startDaemon();

        MPDTest mtest = new MPDTest();
        InvokeMPICommand icmd = new InvokeMPICommand(mgr, mtest, null, dir);

        try {
            String[] command = { "MatrixMult", "500" };
            icmd.exec(4, command);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        mgr.stopDaemon();
    }

    public void stdOut(String message) {
        System.out.println(message);
    }

    public void stdErr(String message) {
        System.err.println(message);
    }
    
    public boolean isReady() {
        return false;
    }

    public String readLine() {
        return null;
    }
}
