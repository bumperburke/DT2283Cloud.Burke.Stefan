package ie.mydit.burke.stefan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class LabServlet4_1Servlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world");
		
		DisplayTxtFile(resp);
		
	}
	
	public int DisplayTxtFile(HttpServletResponse resp) {
		//PrintWriter writer = null;
		String s = null;	
		BufferedReader input = null;
		
		try {
			File TextFile = new File("sample.txt");
			input = new BufferedReader(new FileReader(TextFile));
			
			while (( s = input.readLine()) != null)
			resp.getWriter().println("\t"+s);
			input.close();
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return 0;
	}


}
