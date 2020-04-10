package MPDMgr;

import java.io.IOException;
import java.io.File;
import java.util.*;

public class InvokeMPICommand extends InvokeCommand {
    private MPDManager mgr = null;

    public InvokeMPICommand(MPDManager m, CallbackIOInterface c, Map<String, String> e, File d) {
        super(c, e, d);
        mgr = m;
    }

    public int exec(int nCPU, String[] cmd) throws IOException {
        String[] command = new String[cmd.length + 2];
        command[0] = "prunjava";
        command[1] = String.valueOf(nCPU);
        for (int i = 0; i < cmd.length; i++) {
            command[i + 2] = cmd[i];
        }
        String[] hosts;
        // This portion should be synchronized, otherwise another thread would
        // modify the mpd.hosts file before executing the command.
        synchronized (mgr) {
            hosts = mgr.registerProcess(nCPU);
            super.exec1(command);
        }
        int ret = super.exec2();
        mgr.unregisterProcess(hosts);   
        return ret;
    } 
}
