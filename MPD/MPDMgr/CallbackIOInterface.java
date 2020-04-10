package MPDMgr;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fumitakakawasaki
 */

public interface CallbackIOInterface {
    public void stdOut(String message);
    public void stdErr(String message);
    public boolean isReady();
    public String readLine();
}

