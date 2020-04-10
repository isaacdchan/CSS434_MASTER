/*
 * CSS 543 - Program 4: Multitier Server Application
 * December 14, 2009
 * @author Fumitaka Kawasaki
 */

import javax.swing.JApplet;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.net.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

// This is the java applet class, which provides an ordinary terminal 
// window function on web browsers. 
public class TCPClientApplet extends JApplet {
    private String host;              // code base
    private Socket socket = null;     // a socket to the code base
    private DataInputStream input = null;
    private DataOutputStream output = null;
    private TextArea messageArea;    // input field for message
    private int port;

    public void init() {
        // get the port number used for TCP/IP connection
        port = Integer.parseInt(getParameter("port"));

        // thread for data read
        Runnable readThread = new Runnable() {
            public void run() {
                host = getCodeBase().getHost();
                try {
                    // connect to the server
                    socket = new Socket(host, port);
                    input = new DataInputStream(socket.getInputStream());
                    output = new DataOutputStream(socket.getOutputStream());
                    String line;

                    // read message from the server and display it
                    while ((line = input.readUTF()) != null) {
                        messageArea.append(line);
                    }

                    // close the input/output streams
                    if (input != null) {
                        input.close();
                    } 
                    if (output != null) {
                        output.close();
                    }

                    // close the socket.
                    if (socket != null) {
                        socket.close();
                    }
                } 
                catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        };
        Thread readRun = new Thread(readThread);

        // set up the GUI
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                    public void run() {
                        createGUI();
                    }
                });
        } catch (InvocationTargetException rite) {
            rite.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        // set up the keyboard handler
        messageArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                char ch = e.getKeyChar();
                if (e.CHAR_UNDEFINED != ch) {
                    messageArea.append("" + ch);
                    try {
                        output.writeUTF("" + ch);
                    }
                    catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
               }
            }
        });

        readRun.start();
    }

    // create the GUI window with TextArea
    private void createGUI() {
        // set up the GUI window
        setSize( 1000, 500 ); 
        setLayout(new java.awt.GridLayout(1, 1));
        // Create the text field
        messageArea = new TextArea();
        messageArea.setEditable(false);
        add( messageArea );
    }
}

