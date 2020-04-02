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
import mediatek2020.items.RetourException;
import mediatek2020.items.Utilisateur;

@WebServlet(urlPatterns = "/rendre")
public class RenduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		List<Document> documents = mediatek2020.Mediatheque.getInstance().tousLesDocuments();
		
		out.println("<html>");
		out.println("<head>");

		out.println("<title>Rendre un document </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<form method=\"post\">" + "<select name=\"document\">");
		
		for (Document d : documents) {
			Object[] doc = d.data();
			System.out.println(doc[0]);
			if (((String) doc[5]).equals((String) session.getAttribute("Login"))) {
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
		
		
		out.println("<html>");
		out.println("<head>");
		
		out.println("<title>Rendre un document</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");

		int numDoc = Character.getNumericValue(request.getParameter("document").charAt(0));
		String login = (String) session.getAttribute("Login");
		String pwd = (String) session.getAttribute("Password");
		Document doc = mediatek2020.Mediatheque.getInstance().getDocument(numDoc);
		Utilisateur user = mediatek2020.Mediatheque.getInstance().getUser(login, pwd);
		
		try {
			mediatek2020.Mediatheque.getInstance().rendre(doc, user);
			out.println("<p>Le document a bien été remis</p><br><br>");
			out.println("<a href=\"accueil\"> Retour à l'accueil </a>");
		} catch (RetourException e) {
			out.println("<p>Échec, le document n'a pas été remis</p>");
			e.printStackTrace();
		}

		out.println("</body>");
		out.println("</html>");	
		
	}
	

}
