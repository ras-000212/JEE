package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ajout_doc")
public class AjoutDocServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");

		out.println("<title> Ajouter un document </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<form method=\"post\" action=\"ajout_doc\">\r\n" + "  <label>Auteur : </label><br>\r\n"
				+ "  <input type=\"text\" name=\"auteur\"><br><br>\r\n" + "  <label>Titre : </label><br>\r\n"
				+ "  <input type=\"text\" name=\"titre\"><br><br>\r\n" + "  <label>Type du document : </label><br>\r\n"
				+ "  <input type=\"text\" name=\"type\">\r\n" + "<p>(\"Livre\" / \"CD\" / \"DVD\")</p><br>" +
				" <input type=\"submit\" value=\"Ajouter le document\"> "
				+ "</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String auteur = request.getParameter("auteur");
		String titre = request.getParameter("titre");
		int type = 0;
		
		if(request.getParameter("type")!="") {
			switch (request.getParameter("type")) {
				case ("Livre"):
					type = 1;
					break;
				case ("CD"):
					type = 2;
					break;
				case("DVD"):
					type = 3;
					break;
			}
		}
		
		Object args[]= {titre, auteur};
		out.println("<html>");
		out.println("<head>");
		
		out.println("<title> Ajouter un document </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		
		if (auteur != null && titre != null && type!=0) {
			
			mediatek2020.Mediatheque.getInstance().nouveauDocument(type,args);
			out.println("<p>Ajout réussi !</p><br><br>");
			out.println("<a href=\"accueil\"> Retour à l'accueil </a>");
		}
		else {
			out.println("<p>Échec de l'ajout. Un ou des champ(s) dans le formulaire de saisi est / sont invalide(s)</p>");
		}
		
		
		
		out.println("</body>");
		out.println("</html>");		
	}

}
