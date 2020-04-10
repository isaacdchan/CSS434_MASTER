/*
 * CSS 543 - Program 4: Multitier Server Application
 * December 14, 2009
 * @author Fumitaka Kawasaki
 */

package css543_program4_multitier_server_application;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Upload;
import javax.faces.FacesException;
import java.util.Vector;
import java.util.StringTokenizer;
import com.sun.webui.jsf.model.UploadedFile;
import javax.faces.context.FacesContext;
import javax.faces.convert.NumberConverter;
import javax.faces.event.ValueChangeEvent;
import javax.faces.application.FacesMessage;
import java.rmi.*;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version InvokePage.java
 * @version Created on 2009/11/28, 15:02:09
 * @author fumitakakawasaki
 */

//public class InvokePage extends AbstractPageBean implements InvokeCallback {
public class InvokePage extends AbstractPageBean {
    private String command;
    private String numCPU;
    private UploadedFile jarFile;
    private Upload upload;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        numberConverter1.setMinIntegerDigits(1);
        numberConverter1.setMaxIntegerDigits(3);
        numberConverter1.setMaxFractionDigits(3);
        numberConverter1.setLocale(new java.util.Locale("en", "", ""));
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
    public InvokePage() {
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
            log("invokePage Initialization Failure", e);
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
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
     * Construct parameters for exec() method, and set them to the User object.
     * @return "success"
     */
    public String exec() {
        FacesContext facesContext = getFacesContext();

        // Construct parameters for exec() method
        int nCPU = Integer.parseInt(getNumCPU());
        int maxCPU = 0;
        try {
            maxCPU = getSessionBean1().getServerObject().getNumHosts();
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }
        if (nCPU < 1 || nCPU > maxCPU) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Number of CPU must be less than " + (maxCPU + 1), ""));
            return "failure";
        }

        String str = getCommand();

        Vector<String> vapps = new Vector<String>();

        StringTokenizer st1 = new StringTokenizer(str);
        while(st1.hasMoreTokens()) {
            vapps.add(st1.nextToken());
        }
        String[] apps = new String[vapps.size()];
        vapps.toArray(apps);

        // Set invoking parameter to the user object
        getSessionBean1().getUser().setnCPU(nCPU);
        getSessionBean1().getUser().setCmd(apps);

        return "success";
    }

    /**
     * @return the numCPU
     */
    public String getNumCPU() {
        return numCPU;
    }

    /**
     * @param numCPU the numCPU to set
     */
    public void setNumCPU(String numCPU) {
        this.numCPU = numCPU;
    }

    /**
     * @return the jarFile
     */
    public UploadedFile getJarFile() {
        return jarFile;
    }

    /**
     * @param jarFile the jarFile to set
     */
    public void setJarFile(UploadedFile jarFile) {
        this.jarFile = jarFile;
    }

    /**
     * @return the upload
     */
    public Upload getUpload() {
        return upload;
    }

    /**
     * @param upload the upload to set
     */
    public void setUpload(Upload upload) {
        this.upload = upload;
    }

    public void fileUpload1_processValueChange(ValueChangeEvent event) {
    }

    /**
     * @return the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * @param command the command to set
     */
    public void setCommand(String command) {
        this.command = command;
    }
}