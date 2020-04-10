/*
 * CSS 543 - Program 4: Multitier Server Application
 * December 14, 2009
 * @author Fumitaka Kawasaki
 */

package css543_program4_multitier_server_application;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import java.rmi.*;
import StubMPDMgr.*;
import javax.faces.convert.NumberConverter;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version LoginPage.java
 * @version Created on 2009/11/28, 14:42:06
 * @author fumitakakawasaki
 */

public class LoginPage extends AbstractPageBean {
    private String userName;
    private String studentID;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        numberConverter1.setPattern("######");
        numberConverter1.setIntegerOnly(true);
        numberConverter1.setLocale(new java.util.Locale("en", "", ""));
        numberConverter1.setMaxIntegerDigits(40);
        numberConverter1.setMinIntegerDigits(1);
        numberConverter1.setMaxFractionDigits(3);
    }
    private NumberConverter numberConverter1 = new NumberConverter();

    public NumberConverter getNumberConverter1() {
        return numberConverter1;
    }

    public void setNumberConverter1(NumberConverter nc) {
        this.numberConverter1 = nc;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LoginPage() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
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
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * Handle login page. If a user is successfully logged in, a RMI connection is
     * established, and server and client objects are created.
     * A TCP server, which will connect to a java applet, is also invoked.
     * @return "success"
     */
    public String login() {
        User newUser = null;

        FacesContext facesContext = getFacesContext();

        try {
            newUser = getApplicationBean1().createUser(userName, studentID);
        }
        catch (Exception e) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Incorrect user name or student ID.", ""));
            return "failure";
        }
        
        // Setup RMI objects
        int port = ApplicationBean1.getPort();
        String serverIp = ApplicationBean1.getServerIp();

        try {
            // Get a RMI server object, and create a RMI client object.
            ServerInterface serverObject =  ( ServerInterface )
                Naming.lookup( "rmi://" + serverIp + ":" + port + "/server" );
            CallbackImplementation callback = new CallbackImplementation(getSessionBean1());

            // start TCP server for java applet with an unique port number for the user
            callback.init(newUser.getPort());
            ClientInterface clientObject = new ClientImplementation(callback);

            // Then save them to the Session object.
            getSessionBean1().setServerObject(serverObject);
            getSessionBean1().setClientObject(clientObject);
            getSessionBean1().setCallback(callback);
        } catch ( Exception e ) {
            e.printStackTrace( );
            System.exit( -1 );
        }

        getSessionBean1().setUser(newUser);
        return "success";
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

}

