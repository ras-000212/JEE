package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mediatheque.Mediatheque;
import persistantdata.MediathequeData;

@WebServlet (urlPatterns="/connexion")
public class AuthentificationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");

		out.println("<title> Authentification </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<form method=\"post\">\r\n" + 
				"  <label>Login:</label><br>\r\n" + 
				"  <input type=\"text\" name=\"login\"><br>\r\n" +
				"  <label>Password:</label><br>\r\n" + 
				"  <input type=\"text\" name=\"pwd\"><br>\r\n" +
				" <input type=\"submit\" method=\"POST\" value=\"Connexion\" " +
				"</form>");

		out.println("</body>");
		out.println("</html>");
	}
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 Mediatheque.getUser(request.getParameter("login"),request.getParameter("pwd"));
	 }
	
}
