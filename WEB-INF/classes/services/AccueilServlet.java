package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = "/accueil")
public class AccueilServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();

		out.println("<html>");
		out.println("<head>");

		out.println("<title> Accueil </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");

		out.println("<h1>Accueil</h1>");
		out.println("<h2>" + "Bonjour " + (String) session.getAttribute("Login")+ "</h2>");
		if ((boolean) session.getAttribute("Admin")) {
			out.println("<p>Session biblioth�caire</p><br><br>");
			out.println("<a href=\"ajout_livre\"> Ajouter un livre � la liste des documents </a><br>");
			out.println("<a href=\"ajout_CD\"> Ajouter un CD � la liste des documents </a><br>");
			out.println("<a href=\"ajout_DVD\"> Ajouter un DVD � la liste des documents </a><br>");
			out.println("<a href=\"liste\"> Voir la liste des documents de la m�diath�que </a>");
		}
		else {
			out.println("<p>Session adh�rent</p><br><br>");
			out.println("<a href=\"emprunter\"> Emprunter un document </a><br>");
			out.println("<a href=\"rendre\"> Rednre un document emrpunt� </a>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
