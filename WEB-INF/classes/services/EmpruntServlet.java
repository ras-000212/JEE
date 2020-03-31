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
import mediatek2020.items.EmpruntException;
import mediatek2020.items.Utilisateur;

@WebServlet(urlPatterns = "/emprunt")
public class EmpruntServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Document> documents = mediatek2020.Mediatheque.getInstance().tousLesDocuments();

		out.println("<html>");
		out.println("<head>");

		out.println("<title> Bibliothèque </title>");
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
		out.println("<input type=\"submit\" value=\"Emprunter\">");

		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int numDoc = Character.getNumericValue(request.getParameter("document").charAt(0));
		String login = (String) session.getAttribute("Login");
		String pwd = (String) session.getAttribute("Password");
		Document doc = mediatek2020.Mediatheque.getInstance().getDocument(numDoc);
		Utilisateur user = mediatek2020.Mediatheque.getInstance().getUser(login, pwd);
		
		try {
			mediatek2020.Mediatheque.getInstance().emprunter(doc, user);
		} catch (EmpruntException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
