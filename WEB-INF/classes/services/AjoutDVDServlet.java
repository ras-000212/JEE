package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ajout_DVD")
public class AjoutDVDServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");

		out.println("<title> Ajouter un DVD </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<form method=\"post\" action=\"ajout_DVD\">\r\n" + "  <label>Réalisateur : </label><br>\r\n"
				+ "  <input type=\"text\" name=\"auteur\"><br><br>\r\n" + "  <label>Titre du film : </label><br>\r\n"
				+ "  <input type=\"text\" name=\"titre\"><br><br>\r\n" + "  <label>Genre : </label><br>\r\n"
				+ "  <input type=\"text\" name=\"genre\"><br><br>\r\n" + "  <label>Durée en minute : </label><br>\r\n"
				+ "  <input type=\"text\" name=\"duree\"><br><br><br>\r\n"
				+ " <input type=\"submit\" value=\"Ajouter le DVD\"> " + "</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String auteur = request.getParameter("auteur");
		String titre = request.getParameter("titre");
		String genre = request.getParameter("genre");
		String duree = request.getParameter("duree");

		out.println("<html>");
		out.println("<head>");
		
		out.println("<title> Ajouter un DVD </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		
		if (auteur != null && titre != null && genre != null && duree.matches("-?(0|[1-9]\\d*)")) {
			//code ajout 
			out.println("<p>Ajout réussi !</p>");
		}
		else {
			out.println("<p>Échec de l'ajout. Un ou des champ(s) dans le formulaire de saisi est / sont invalide(s)</p>");
		}
		
		
		
		out.println("</body>");
		out.println("</html>");		
	}

}
