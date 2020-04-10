package MPDMgr;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fumitakakawasaki
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.File;
import java.util.*;

public class InvokeCommand {
    private InputStream in = null;
    private InputStream ein = null;
    private OutputStream out = null;
    private BufferedReader br = null;
    private BufferedReader ebr = null;
    private BufferedWriter bw = null;
    private Process process = null;
    private Thread stdRun = null;
    private Thread errRun = null;
    private Thread outRun = null;
    private CallbackIOInterface callback = null;
    private Map<String, String> environment = null;
    private File directory = null;
    private boolean isEnd = false;

    public InvokeCommand(CallbackIOInterface c, Map<String, String> e, File d) {
        this.callback = c;
        this.environment = e;
        this.directory = d;
    }

    public int exec(String[] command) throws IOException {
        exec1(command);
        return exec2();
    }

    protected  void exec1(String[] command) throws IOException {
        // Instanciate a ProcessBuilder with command
	ProcessBuilder pb = new ProcessBuilder(command);

        // Set up environment and working direcory
        if (environment != null) {
            Map<String, String> env = pb.environment();
            env.clear();
            env.putAll(environment);
        }
        if (directory != null) {
            pb.directory(directory);
        }

        // Start a new process
        isEnd = false;
        process = pb.start();
    }


    protected  int exec2() throws IOException {
        // Get streams of the process
        in = process.getInputStream();
        ein = process.getErrorStream();
        out = process.getOutputStream();

        int ret = 0;
        try {
            // Handle StdOut, StdErr, and StdIn in sub threads, otherwise
            // the sub-process may be blocke or deadlock.

            // Thread for redirect StdOut
            Runnable inputStreamThread = new Runnable() {
                public void run() {
                    char[] cbuf = new char[1024];
                    int len;
                    try {
                        br = new BufferedReader(new InputStreamReader(in));
                        while ((len = br.read(cbuf, 0, cbuf.length)) != -1) {
                            // Redirect the stdOut to the callback
                            callback.stdOut(new String(cbuf, 0, len));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            // Thread for redirect StdErr
            Runnable errStreamThread = new Runnable() {
                public void run() {
                    char[] cbuf = new char[1024]; 
                    int len;
                    try {
                        ebr = new BufferedReader(new InputStreamReader(ein));
                        while ((len = ebr.read(cbuf, 0, cbuf.length)) != -1) {
                            // Redirect the stdErr to the callback
                            callback.stdErr(new String(cbuf, 0, len));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            };

            // Thread for redirect StdIn
            Runnable outputStreamThread = new Runnable() {
                public void run() {
                    try {
                        bw = new BufferedWriter((new OutputStreamWriter(out)));
                        String line;
                        char[] cbuf;
                        while(!isEnd){
                            if (callback.isReady()) {
                                line = callback.readLine();
                                cbuf = line.toCharArray();
                                bw.write(cbuf, 0, cbuf.length);
                                bw.flush();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            // Create and start sub threads
            stdRun = new Thread(inputStreamThread);
            errRun = new Thread(errStreamThread);
            outRun = new Thread(outputStreamThread);

            stdRun.start();
            errRun.start();
            outRun.start();

            // Wait until the process terminates
            ret = process.waitFor();
            isEnd = true;

            // Wait until the sub threads terminate
            stdRun.join();
            errRun.join();
            outRun.join();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                br.close();
            if (ebr != null)
                ebr.close();
            if (bw != null)
                bw.close();
            if (in != null)
                in.close();
            if (ein != null)
                ein.close();
            if (out != null)
                out.close();
        }

        // Return the process teminate code
        return ret;
    }
}

