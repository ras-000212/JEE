package persistantdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;

import mediatek2020.*;
import mediatek2020.items.Document;
import mediatek2020.items.Utilisateur;
import mediatheque.CD;
import mediatheque.DVD;
import mediatheque.Livre;
import mediatheque.Utilisateurs;

// classe mono-instance  dont l'unique instance est connue de la bibliotheque
// via une auto-déclaration dans son bloc static

public class MediathequeData extends HttpServlet implements PersistentMediatheque  {
// Jean-François Brette 01/01/2018
	
	
	private static final long serialVersionUID = 1L;
	private Connection connect;
	
	static {
		Mediatheque.getInstance().setData(new MediathequeData());
	}

	private MediathequeData() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","IUT","1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		try {			
			
			PreparedStatement req1 = connect.prepareStatement("Select * from Utilisateur where LOGIN = ? and MDP = ?");
			req1.setString(1,login);
			req1.setString(2,password);
			
			ResultSet res1 = req1.executeQuery();
			
			if (res1.next()) {
				String strNom = res1.getString(1);
				String strMdp = res1.getString(2);
				Boolean isAdmin;
				if (res1.getInt(3) == 1) {
					isAdmin = true;
				}
				else {
					isAdmin = false;
				}
				res1.close();
				return new Utilisateurs(strNom, strMdp, isAdmin);
			}
			else {
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
	public Document getDocument(int numDocument) {
		try {
			PreparedStatement req1 = connect.prepareStatement("Select * from Document where numDocument = ?");
			req1.setInt(1, numDocument);
			
			ResultSet res1 = req1.executeQuery();
			
			if(res1.next()) {
				return null;//modifier
			}else {
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
		switch((String)args[0]){
			case("Livre"):
				Livre doc= new Livre((String) args[1],(String) args[2],(String) args[3],(int) args[4]);
			case("CD"):
				CD doc= new CD((String) args[1],(String) args[2],(String) args[3],(int) args[4]);
			case("DVD"):
				DVD doc = new DVD ((String) args[1],(String) args[2],(String) args[3],(float) args[4]);
		
		}
		
		try {
			PreparedStatement statement = connect.prepareStatement("insert into Document (titre, auteur) values (?,?)");
			statement.setString(1, (String) args[0]);
		    statement.setString(2, (String) args[1]);
		    statement.executeUpdate();
		    
		    connect.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
	}

}
