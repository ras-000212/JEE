package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ajout_CD")
public class AjoutCDServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");

		out.println("<title> Ajouter un CD </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<form method=\"post\" action=\"ajout_CD\">\r\n" + "  <label>Artiste : </label><br>\r\n"
				+ "  <input type=\"text\" name=\"auteur\"><br><br>\r\n" + "  <label>Titre de l'album : </label><br>\r\n"
				+ "  <input type=\"text\" name=\"titre\"><br><br>\r\n" + "  <label>Genre musical : </label><br>\r\n"
				+ "  <input type=\"text\" name=\"genre\"><br><br>\r\n" + "  <label>Nombre de morceaux : </label><br>\r\n"
				+ "  <input type=\"text\" name=\"nbMorceaux\"><br><br><br>\r\n"
				+ " <input type=\"submit\" value=\"Ajouter le CD\"> " + "</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String auteur = request.getParameter("auteur");
		String titre = request.getParameter("titre");
		String genre = request.getParameter("genre");
		String nbMorceaux = request.getParameter("nbMorceaux");

		out.println("<html>");
		out.println("<head>");
		
		out.println("<title> Ajouter un CD </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		
		if (auteur != null && titre != null && genre != null && nbMorceaux.matches("-?(0|[1-9]\\d*)")) {
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
