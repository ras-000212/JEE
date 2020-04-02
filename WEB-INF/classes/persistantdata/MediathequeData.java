package persistantdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import mediatek2020.*;
import mediatek2020.items.Document;
import mediatek2020.items.Utilisateur;
import mediatheque.Documents;
import mediatheque.PersistentMediatheque;
import mediatheque.Utilisateurs;

// classe mono-instance  dont l'unique instance est connue de la bibliotheque
// via une auto-déclaration dans son bloc static

public class MediathequeData extends HttpServlet implements PersistentMediatheque, mediatek2020.PersistentMediatheque {
// Jean-François Brette 01/01/2018

	private static final long serialVersionUID = 1L;
	private Connection connect;

	static {
		Mediatheque.getInstance().setData(new MediathequeData());
	}

	private MediathequeData() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "alexis");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// renvoie la liste de tous les documents de la bibliothèque
	@Override
	public List<Document> tousLesDocuments() {
		List<Document> documents = new ArrayList<>();
		try {
				PreparedStatement req1 = connect.prepareStatement("Select * from Document ORDER BY 2,3");
				ResultSet res1 = req1.executeQuery();
				
				while(res1.next()) {
					int numDoc = res1.getInt("NumDoc");
					int typeDoc =res1.getInt("TypeDoc");
					String strTitre = res1.getString("Titre");
					String strAuteur = res1.getString("Auteur");
					boolean estLibre;
					String emprunteur = res1.getString("Login");
					if(res1.getInt("estLibre") == 0) {
						estLibre = false;
					}
					else {
						estLibre = true;
					}
					documents.add(new Documents(numDoc, typeDoc, strTitre, strAuteur, estLibre,emprunteur));
				}
				return documents;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return documents;
	}

	// va récupérer le User dans la BD et le renvoie
	// si pas trouvé, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) {
		try {

			PreparedStatement req1 = connect.prepareStatement("Select * from Utilisateur where LOGIN = ? and MDP = ?");
			req1.setString(1, login);
			req1.setString(2, password);

			ResultSet res1 = req1.executeQuery();

			if (res1.next()) {
				String strNom = res1.getString(1);
				String strMdp = res1.getString(2);
				Boolean isAdmin;
				if (res1.getInt(3) == 1) {
					isAdmin = true;
				} else {
					isAdmin = false;
				}
				res1.close();
				return new Utilisateurs(strNom, strMdp, isAdmin);
			} else {
				res1.close();
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// va récupérer le document de numéro numDocument dans la BD
	// et le renvoie
	// si pas trouvé, renvoie null

	@Override
	public Documents getDocument(int numDocument) {
		try {
			PreparedStatement req1 = connect.prepareStatement("Select * from Document where numDoc = ?");
			req1.setInt(1, numDocument);
			System.out.println(numDocument);
			ResultSet res1 = req1.executeQuery();

			if (res1.next()) {

				int numDoc = res1.getInt("numDoc");
				int typeDoc = res1.getInt("TypeDoc");
				String strTitre = res1.getString("Titre");
				String strAuteur = res1.getString("Auteur");
				boolean estLibre;
				String emprunteur = res1.getString("Login");
				
				if(res1.getInt("estLibre") == 0) {
					estLibre = false;
				}
				else {
					estLibre = true;
				}
				Documents doc = new Documents(numDoc, typeDoc, strAuteur, strTitre, estLibre,emprunteur);

				return doc;
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void nouveauDocument(int type, Object... args) {
		// args[0] = titre
		// args[2] = auteur
		try {
			PreparedStatement statement = connect.prepareStatement(
					"insert into Document (numDoc,TypeDoc,Titre, Auteur, estLibre, login) values (seq_document.NextVal,?,?,?,1,null)");
			statement.setInt(1, type);
			statement.setString(2, (String) args[0]);
			statement.setString(3, (String) args[1]);
			statement.executeUpdate();
			connect.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
