package Context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class DBContext
 *
 */
public class DBContext implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DBContext() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("Destroyed");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ComMet obj=new ComMet();
        ServletContext context=sce.getServletContext();
        context.setAttribute("dB", obj);
    	System.out.println("Initialized");

    }
	
}
