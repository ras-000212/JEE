package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mediatek2020.*;
import mediatek2020.items.Utilisateur;

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
		out.println("<form method=\"post\" action=\"connexion\">\r\n" + 
				"  <label>Login:</label><br>\r\n" + 
				"  <input type=\"text\" name=\"login\"><br>\r\n" +
				"  <label>Password:</label><br>\r\n" + 
				"  <input type=\"text\" name=\"pwd\"><br>\r\n" +
				" <input type=\"submit\" value=\"Connexion\"> " +
				"</form>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 
		String login = request.getParameter("login");
		String pwd =  request.getParameter("pwd");
		Utilisateur utest = mediatek2020.Mediatheque.getInstance().getUser(login, pwd);
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");

		out.println("<title> Authentification </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		
		if (utest != null) {
			out.println("<h1>" + "Bonjour, " + utest.toString() + "</h1>");
		}
		else {
			out.println("<h1>" + "Connexion échouée"+ "</h1>");
		}
		
		out.println("</body>");
		out.println("</html>");
		 
	 }
	
}
