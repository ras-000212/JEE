package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns="/erreur")
public class ErrorServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
  
		out.println("<title> ERREUR </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<h1>Erreur</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	
}
