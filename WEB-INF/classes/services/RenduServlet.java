package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2020.items.Document;
import mediatek2020.items.EmpruntException;
import mediatek2020.items.Utilisateur;
import mediatheque.Documents;
import mediatheque.Utilisateurs;

@WebServlet(urlPatterns = "/rendu")
public class RenduServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Document> documents = mediatek2020.Mediatheque.getInstance().tousLesDocuments();

		out.println("<html>");
		out.println("<head>");

		out.println("<title> Biblioth�que </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<form method=\"post\">" + "<select name=\"document\">");
		for (Document d : documents) {
			Object[] doc = d.data();
			if (doc[4] == "oui") {
				out.println("<option>" + (int) doc[0] + " - " + // numDOC
						(String) doc[1] + " - " + // TypeDoc
						(String) doc[2] + " - " + // titre
						(String) doc[3] + // auteur
						"</option>");
			}
		}
		out.println("</select>");
		out.println("<input type=\"submit\" value=\"Rendre\">");

		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		Utilisateurs u = new Utilisateurs("2","3");
		u.
		
		out.println("<html>");
		out.println("<head>");
		
		out.println("<title> Rendre </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");

		int numDoc = Character.getNumericValue(request.getParameter("document").charAt(0));
		String login = (String) session.getAttribute("Login");
		String pwd = (String) session.getAttribute("Password");
		Document doc = mediatek2020.Mediatheque.getInstance().getDocument(numDoc);
		Utilisateur user = mediatek2020.Mediatheque.getInstance().getUser(login, pwd);
		
		try {
			mediatek2020.Mediatheque.getInstance().emprunter(doc, user);
			out.println("<p>Emprunt pris en compte</p><br><br>");
			out.println("<a href=\"accueil\"> Retour � l'accueil </a>");
		} catch (EmpruntException e) {
			out.println("<p>�chec de l'ajout. Un ou des champ(s) dans le formulaire de saisi est / sont invalide(s)</p>");
			e.printStackTrace();
		}

		out.println("</body>");
		out.println("</html>");	
		
	}
	

}
