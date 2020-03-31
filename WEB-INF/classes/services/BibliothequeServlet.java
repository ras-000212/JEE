package services;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mediatek2020.items.Document;
import mediatheque.Documents;

@WebServlet(urlPatterns = "/bibliotheque")
public class BibliothequeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Document> documents = mediatek2020.Mediatheque.getInstance().tousLesDocuments();
		

		out.println("<html>");
		out.println("<head>");

		out.println("<title> Bibliothèque </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<table>"+
					"<tr>" +
						"<th>Numéro Document</th>" +
						"<th>Type de Document</th>"+
						"<th>Titre</th>"+
						"<th>Auteur</th>"+
						"<th>Disponible</th>"+
					"</tr>"
				);
		for (Document d : documents) {
			Object[] doc = d.data();
			out.println(
					"<tr>" +
						"<th>"+ (int) doc[0] +"</th>" + //numDOC
						"<th>"+(String) doc[1]+"</th>"+ //TypeDoc
						"<th>"+ (String) doc[2]+"</th>"+ //titre
						"<th>"+(String) doc[3] +"</th>"+ // auteur
						"<th>"+(String) doc[4]+"</th>"+ // estLibre
					"</tr>"
				);
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
