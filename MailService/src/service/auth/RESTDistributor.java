package service.auth;

import org.restlet.Component;
import org.restlet.data.Protocol;
import service.mail.*;
 
public class RESTDistributor {
 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
				// Create a new Restlet component and add a HTTP server connector to it  
			     Component component = new Component();
		             // if you have an HTTP connector listening on the same port (i.e. 8182), you will get an error
		             // in this case change the port number (e.g. 8183)
			     component.getServers().add(Protocol.HTTP, 8087);
			     // Then attach it to the local host  
			     component.getDefaultHost().attach("/users", authservice.class);  
		 
			     // Now, let's start the component!  
			     // Note that the HTTP server connector is also automatically started.  
			     component.start();  
			   
	}	 
 
}