package ie.mydit.burke.stefan.LabServlet5_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

import org.objectweb.asm.Type;

@SuppressWarnings("serial")
public class Multiplication extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		PrintWriter writer = resp.getWriter();
		writer.println("Hello, I'm the multiplication servlet.");
		
		String AString = new String();
		String BString = new String();
		int result, a = 0, b = 0;
		
		if(req.getParameter("A") != null)
		{
			AString = "A";
		}
		else
		{
			AString = getServletConfig().getInitParameter("A");
		}
		if(req.getParameter("B") != null)
		{
			BString = "B";
		}
		else
		{
			BString = getServletConfig().getInitParameter("B");
		}
	
		a = Integer.parseInt(AString);
		b = Integer.parseInt(BString);
	
		writer.println("Values passed: " +AString+ " and " +BString);
		result = a * b;
		writer.println(AString + " x " + BString + " = " +result);
	}
}
