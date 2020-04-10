/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MPDMgr;

import java.util.*;
import java.net.InetAddress;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author fumitakakawasaki
 */
public class MPDManager implements CallbackIOInterface {
    private File dir = null;       // MPD working directory
    private ArrayList<HostItem> hostsTable = null;
    private InvokeCommand icmd = null;
    private static String[] hosts = {   "uw1-320-00.uwb.edu",
                                        "uw1-320-01.uwb.edu",
                                        "uw1-320-02.uwb.edu",
                                        "uw1-320-03.uwb.edu",
                                        "uw1-320-04.uwb.edu",
                                        "uw1-320-06.uwb.edu",
                                        "uw1-320-07.uwb.edu",
                                        "uw1-320-08.uwb.edu",
                                        "uw1-320-09.uwb.edu",
                                        "uw1-320-10.uwb.edu",
                                        "uw1-320-11.uwb.edu",
                                        "uw1-320-12.uwb.edu",
                                        "uw1-320-13.uwb.edu",
                                        "uw1-320-14.uwb.edu",
                                        "uw1-320-15.uwb.edu",
                                        "uw1-320-16.uwb.edu",
                                        "uw1-320-17.uwb.edu",
                                        "uw1-320-18.uwb.edu",
                                        "uw1-320-19.uwb.edu",
                                        "uw1-320-20.uwb.edu",
                                        "uw1-320-21.uwb.edu",
                                        "uw1-320-22.uwb.edu",
                                        "uw1-320-23.uwb.edu",
                                        "uw1-320-24.uwb.edu",
                                        "uw1-320-25.uwb.edu",
                                        "uw1-320-26.uwb.edu",
                                        "uw1-320-27.uwb.edu",
                                        "uw1-320-28.uwb.edu",
                                        "uw1-320-29.uwb.edu",
                                        "uw1-320-30.uwb.edu",
                                        "uw1-320-31.uwb.edu"
                                    };
public MPDManager(File d) {
        // Set the current directory as the MPD working directory
        dir = d;
        hostsTable = new ArrayList<HostItem>();
        icmd = new InvokeCommand(this, null, dir);
    }

    public synchronized void initHostsTable() {
        String localhost = null;
        try {
            localhost = InetAddress.getLocalHost().getHostName();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        int timeOut = 3000;
        for (int i = 0; i < hosts.length; i++) {
            String host = hosts[i];
            if (!host.contains(localhost)) {
                try {
                    boolean status = InetAddress.getByName(host).isReachable(timeOut);
                    if (status) {
                        hostsTable.add(new HostItem(host));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        writeHostsFile();  
    }

    private void sortHostsTable() {
        Collections.sort(hostsTable, new MpdComparator()); 
        //dumpTable();
    }

    private void writeHostsFile() {
        try {
            File file = new File(dir.getCanonicalPath() + "/mpd.hosts");
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            for (HostItem item : hostsTable) {
                String host = item.getHost();
                pw.println(host);
            }
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void startDaemon() {
        try {
            String[] cmd = new String[4];
            cmd[0] = "mpdboot";
            cmd[1] = "-n";
            cmd[2] = String.valueOf(getNumHosts()); 
            cmd[3] = "-v";
            icmd.exec(cmd);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void stopDaemon() {
        try {
            String[] cmd = { "mpdallexit" };
            icmd.exec(cmd);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized int getNumHosts() {
        // Include myself (+1)
        return hostsTable.size() + 1;
    }

    public synchronized String[] registerProcess(int nCPU) {
        // Not include myself
        int nhosts = nCPU - 1;
        String[] hosts = new String[nhosts];
        for (int i = 0; i < nhosts; i++) {
            HostItem item = hostsTable.get(i);
            int count = item.getCount();
            item.setCount(++count);
            hosts[i] = item.getHost();
        }
        sortHostsTable();
        writeHostsFile();
        return hosts;
    }

    public synchronized void unregisterProcess(String[] hosts) {
        for (int i = 0; i < hosts.length; i++) {
            for (HostItem item : hostsTable) {
                if (item.getHost().compareTo(hosts[i]) == 0) {
                    int count = item.getCount();
                    item.setCount(--count);
                    break;
                }
            }
        }
        sortHostsTable();
        writeHostsFile();
    }

    private void dumpTable() {
        for (HostItem item : hostsTable) {
            String host = item.getHost();
            int count = item.getCount();
            System.out.println("host: " + host + " count: " + count);
        }        
        System.out.println("");
    }

    private class HostItem {
        private String host;
        private int count;
 
        public HostItem(String s) {
            host = s;
            count = 0;
        } 

        public String getHost() {
            return host;
        } 

        public int getCount() {
            return count;
        } 

        public void setCount(int c) {
            if (c >= 0)
                count = c;
        }
    };

    private class MpdComparator implements java.util.Comparator {
        public int compare( Object object1, Object object2 ) {
            HostItem h1 = (HostItem)object1;
            HostItem h2 = (HostItem)object2;
            int i1 = h1.getCount();
            int i2 = h2.getCount();
            if (i1 < i2)
                return -1;
            else if (i1 == i2)
                return 0;
            else
                return 1;
        }
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
