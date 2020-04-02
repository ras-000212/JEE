package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2020.items.Document;

@WebServlet(urlPatterns = "/accueil")
public class AccueilServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		out.println("<html>");
		out.println("<head>");

		out.println("<title> Accueil </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");

		out.println("<h1>Accueil</h1>");
		out.println("<h2>" + "Bonjour " + (String) session.getAttribute("Login") + "</h2>");
		if ((boolean) session.getAttribute("Admin")) {
			out.println("<p>Session bibliothécaire</p><br><br>");
			out.println("<a href=\"ajout_doc\"> Ajouter un document à la liste des documents </a><br><br>");
			out.println("<a href=\"bibliotheque\"> Voir la liste des documents de la médiathèque </a>");
		} else {
			List<Document> documents = mediatek2020.Mediatheque.getInstance().tousLesDocuments();
			out.println("<p>Session adhérent</p><br><br>");
			out.println("<a href=\"emprunt\"> Emprunter un document </a><br><br>");
			out.println("<a href=\"rendre\"> Rendre un document emrpunté </a><br><br>");
			out.println("<h1>Mes documents</h1>");
			out.println("<table border=\"1\">" + "<tr>" + "<th>Numéro Document</th>" + "<th>Type de Document</th>" + "<th>Titre</th>"
					+ "<th>Auteur</th>" + "</tr>");
			for (Document d : documents) {
				Object[] doc = d.data();
				if (((String) doc[5]).equals((String) session.getAttribute("Login"))) {
					out.println("<tr>" + "<th>" + (int) doc[0] + "</th>" + // numDOC
							"<th>" + (String) doc[1] + "</th>" + // TypeDoc
							"<th>" + (String) doc[2] + "</th>" + // titre
							"<th>" + (String) doc[3] + "</th>" + // auteur
							"</tr>");
				}
			}
			out.println("</table>");
		}
		out.println("<form method=\"post\">" + "<button type=\"submit\" value=\"LogOut\"> Se déconnecter</button>"
				+ "</form>");

		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("connexion");
	}

}
