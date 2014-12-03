package ie.mydit.burke.stefan.LabServlet5_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class LabServlet5_1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		UserService userService = UserServiceFactory.getUserService(); //Creates instance of a user service
		
		Principal myPrincipal = req.getUserPrincipal(); //Creates instance of Principal which then requests the user from the http req
		String emailAddress = null;
		PrintWriter writer = resp.getWriter();
		
		String thisURL = req.getRequestURI(); //Requests the URL from the req
		String loginURL = userService.createLoginURL(thisURL); //Creates a login using URL from above
		String logoutURL = userService.createLogoutURL(thisURL); //Creates logout using URL from above
		
		resp.setContentType("text/html");
		if(myPrincipal == null) //If no user in principal
		{
			writer.println("<p>You are Not Logged In time</p>");
			writer.println("<p>You can <a href=\""+loginURL+"\">sign in here</a>.</p>");
		}
		
		if(myPrincipal != null) //If user IS in Principal
		{
			emailAddress = myPrincipal.getName();//Gets the name of email address
			writer.println("<p>You are Logged in as (email):"+emailAddress+"</p>");
			writer.println("<p>You can <a href=\""+logoutURL+"\">sign out</a>.</p>");
		}
	}
}
