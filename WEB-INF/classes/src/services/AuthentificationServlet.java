package services;

import javax.servlet.http.*;


public class AuthentificationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpSession session = request.getSession(true);

		String u_name = request.getParameter("u_name");
		User user = new User(u_name);
		session.setAttribute("user", user);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");

		out.println("<title> Authentification </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");

		out.println("<h1>" + "Bien enregistré " + u_name + "</h1>");

		out.println("<a href='verif'>Vérification</a>");

		out.println("</body>");
		out.println("</html>");
	}
}
