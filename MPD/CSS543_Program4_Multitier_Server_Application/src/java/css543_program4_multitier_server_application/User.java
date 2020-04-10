/*
 * CSS 543 - Program 4: Multitier Server Application
 * December 14, 2009
 * @author Fumitaka Kawasaki
 */

package css543_program4_multitier_server_application;

import java.io.*;

/*
 * CSS 543 - Program 4: Multitier Server Application
 * December 14, 2009
 * @author Fumitaka Kawasaki
 */

public class User implements Serializable {
    String name = null;             // user name
    String id = null;               // student Id
    File udir = null;               // user's working directory
    private int nCPU = 0;           // number of CPUs entered in invoke page
    private String[] cmd = null;    // command and argument entered in invoke page

    public User(String n, String i, File u) {
        name = n;
        id = i;
        udir = u;
    }

    public int getPort() {
        String str = "00000" + id;
        return Integer.parseInt(str.substring(str.length() - 5));
    }

    public File getUserDir() {
        return udir;
    }

    /**
     * @return the nCPU
     */
    public int getnCPU() {
        return nCPU;
    }

    /**
     * @param nCPU the nCPU to set
     */
    public void setnCPU(int nCPU) {
        this.nCPU = nCPU;
    }

    /**
     * @return the cmd
     */
    public String[] getCmd() {
        return cmd;
    }

    /**
     * @param cmd the cmd to set
     */
    public void setCmd(String[] cmd) {
        this.cmd = cmd;
    }
}
