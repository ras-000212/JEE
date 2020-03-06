package persistantdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import mediatek2020.*;
import mediatek2020.items.Document;
import mediatek2020.items.Utilisateur;

// classe mono-instance  dont l'unique instance est connue de la bibliotheque
// via une auto-déclaration dans son bloc static

public class MediathequeData extends HttpServlet implements PersistentMediatheque  {
// Jean-François Brette 01/01/2018
	
 private Connection connect;
	
	public void init(ServletConfig config) throws ServletException{
		try {
			super.init(config);
			Class.forName("oracle.jdbc.OracleDriver");
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

	// renvoie la liste de tous les documents de la bibliothèque
	@Override
	public List<Document> tousLesDocuments() {
		return null;
	}

	// va récupérer le User dans la BD et le renvoie
	// si pas trouvé, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) {
		return null;
	}

	// va récupérer le document de numéro numDocument dans la BD
	// et le renvoie
	// si pas trouvé, renvoie null
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
