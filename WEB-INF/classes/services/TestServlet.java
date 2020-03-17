package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns="/test")
public class TestServlet extends HttpServlet{

	
	/**
	 * 
	 */


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
  
		out.println("<title> Authentification </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<h1>Test Réussi !!</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");

		out.println("<title> Authentification </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<h1>Test Réussi !!</h1>");
		out.println("</body>");
		out.println("</html>");
		 
	 }
	
}
