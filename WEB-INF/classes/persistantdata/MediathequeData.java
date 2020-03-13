package persistantdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import mediatek2020.*;
import mediatek2020.items.Document;
import mediatek2020.items.Utilisateur;

// classe mono-instance  dont l'unique instance est connue de la bibliotheque
// via une auto-d�claration dans son bloc static

public class MediathequeData extends HttpServlet implements PersistentMediatheque  {
// Jean-Fran�ois Brette 01/01/2018
	
	private Connection connect;
	
	public void init(ServletConfig config) throws ServletException{
		try {
			super.init(config);
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ETUDIANT","ETUDIANT");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static {
		Mediatheque.getInstance().setData(new MediathequeData());
	}

	private MediathequeData() {
	}

	// renvoie la liste de tous les documents de la biblioth�que
	@Override
	public List<Document> tousLesDocuments() {
		return null;
	}

	// va r�cup�rer le User dans la BD et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) {
		try {
			this.init();
			PreparedStatement req1 = connect.prepareStatement("Select login from Utilisateur where login = ? and Mdp = ?");
			req1.setString(1,login);
			req1.setString(1,password);
			
			ResultSet res1 = req1.executeQuery();
			
			while(res1.next()) {
				System.out.println(res1.getString(1));
			}
			
		} catch (ServletException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// va r�cup�rer le document de num�ro numDocument dans la BD
	// et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Document getDocument(int numDocument) {
		return null;
	}

	@Override
	public void nouveauDocument(int type, Object... args) {
		// args[0] -> le titre
		// args [1] --> l'auteur
		// etc...
	}

}
