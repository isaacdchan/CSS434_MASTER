/*
 * CSS 543 - Program 4: Multitier Server Application 
 * December 14, 2009
 * @author Fumitaka Kawasaki
 */

package css543_program4_multitier_server_application;

import com.sun.rave.web.ui.appbase.AbstractApplicationBean;
import javax.faces.FacesException;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <p>Application scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available to all users
 *  and pages in the application.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version ApplicationBean1.java
 * @version Created on 2009/11/28, 14:42:05
 * @author fumitakakawasaki
 */

public class ApplicationBean1 extends AbstractApplicationBean {
    private static int port = 12345;                // port number used in RMI
    private static String serverIp = "localHost";   // server IP used in RMI
    private String dir = null;                      // root working directory for the application
    private HashMap<String, String> userMap = null; // userName, studentId mapping table
    
    /**
     * @return the port
     */
    public static int getPort() {
        return port;
    }

    /**
     * @return the serverIp
     */
    public static String getServerIp() {
        return serverIp;
    }

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    /**
     * <p>Construct a new application data bean instance.</p>
     */
    public ApplicationBean1() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * application scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * application scope.</p>
     * 
     * <p>You may customize this method to initialize and cache application wide
     * data values (such as the lists of valid options for dropdown list
     * components), or to allocate resources that are required for the
     * lifetime of the application.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("ApplicationBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        
        // Initialize the user mapping table
        dir = new String("/Users/fumitakakawasaki/MPI");
        userMap = new HashMap<String, String>();
        try {
            FileInputStream file = new FileInputStream(dir + "/userFile");
            BufferedReader br = new BufferedReader(new InputStreamReader(file));
            String inline;
            while ((inline = br.readLine()) != null) {
                StringTokenizer st1 = new StringTokenizer(inline);
                String name = st1.nextToken();
                String id = st1.nextToken();
                userMap.put(name, id);
            }
            br.close();
            file.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>This method is called when this bean is removed from
     * application scope.  Typically, this occurs as a result of
     * the application being shut down by its owning container.</p>
     * 
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return an appropriate character encoding based on the
     * <code>Locale</code> defined for the current JavaServer Faces
     * view.  If no more suitable encoding can be found, return
     * "UTF-8" as a general purpose default.</p>
     *
     * <p>The default implementation uses the implementation from
     * our superclass, <code>AbstractApplicationBean</code>.</p>
     */
    @Override
    public String getLocaleCharacterEncoding() {
        return super.getLocaleCharacterEncoding();
    }

    /**
     * Create a user object, and create a sub directory for the user
     * if the (name, id) is contained in the map table.
     *
     * @param name
     *  user name
     * @param id
     *  student id
     * @return
     *  User class object if success
     * @throws Exception
     */
    public User createUser(String name, String id) throws Exception {
        User user = null;
        boolean success = false;

        if (userMap.containsKey(name)) {
            success = (userMap.get(name).compareTo(id) == 0);
        }

        // create a user's directory under the root working directory
        File udir = null;
        if (success) {
            udir = new File(dir + "/" + name);
            if (!udir.isDirectory()) {
                success = (udir.mkdir());
            }
        }

        // create a User object
        if (success) {
            user = new User(name, id, udir);
        }
        else {
            throw new Exception();
        }
        return user;
    }
}
