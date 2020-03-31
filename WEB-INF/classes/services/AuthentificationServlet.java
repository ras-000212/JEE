package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2020.items.Utilisateur;

@WebServlet(urlPatterns = "/connexion")
public class AuthentificationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");

		out.println("<title> Authentification </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<form method=\"post\" action=\"connexion\">\r\n" + "  <label>Nom d'utilisateur : </label><br>\r\n"
				+ "  <input type=\"text\" name=\"login\"><br><br>\r\n" + "  <label>Mot de passe : </label><br>\r\n"
				+ "  <input type=\"password\" name=\"pwd\"><br><br><br>\r\n"
				+ " <input type=\"submit\" value=\"Connexion\"> " + "</form>");
		out.println("</body>");
		out.println("</html>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		Utilisateur utest = mediatek2020.Mediatheque.getInstance().getUser(login, pwd);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");

		out.println("<title> Authentification </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");

		if (utest != null) {
			HttpSession session = request.getSession();
			session.setAttribute("Login", login);
			session.setAttribute("Password", pwd);
			session.setAttribute("Admin", utest.isBibliothecaire());
			response.sendRedirect("accueil");
		} 
		
		else {
			out.println("<h1>" + "Connexion échouée" + "</h1> <br>");
			
			out.println("<title> Authentification </title>");
			out.println("</head>");
			out.println("<body bgcolor=\"white\">");
			out.println("<form method=\"post\" action=\"connexion\">\r\n" + "  <label>Nom d'utilisateur : </label><br>\r\n"
					+ "  <input type=\"text\" name=\"login\"><br><br>\r\n" + "  <label>Mot de passe : </label><br>\r\n"
					+ "  <input type=\"text\" name=\"pwd\"><br><br><br>\r\n"
					+ " <input type=\"submit\" value=\"Connexion\"> " + "</form>");
			out.println("</body>");
			out.println("</html>");
		}

		out.println("</body>");
		out.println("</html>");

	}

}
