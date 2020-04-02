package mediatheque;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mediatek2020.items.Document;
import mediatek2020.items.EmpruntException;
import mediatek2020.items.ReservationException;
import mediatek2020.items.RetourException;
import mediatek2020.items.Utilisateur;

public class Documents implements Document {

	private int numDoc;
	private String auteur;
	private String titre;
	private int type;
	private boolean estLibre;
	private String emprunteur;

	public Documents(int numDoc, int type, String auteur, String titre, boolean estLibre,String emprunteur) {
		this.auteur = auteur;
		this.titre = titre;
		this.numDoc = numDoc;
		this.type = type;
		this.estLibre = estLibre;
		this.emprunteur = emprunteur;
	}
	public Documents(int numDoc, int type, String auteur, String titre,boolean estLibre) {
		this.auteur = auteur;
		this.titre = titre;
		this.numDoc = numDoc;
		this.type = type;
		this.estLibre = estLibre;
		this.emprunteur = null;
	}

	@Override
	public Object[] data() {
		Object[] doc = { this.numDoc, this.getTypeDoc(), this.titre, this.auteur, this.getEstLibre(),this.emprunteur };
		return doc;
	}

	@Override
	public void emprunter(Utilisateur arg0) throws EmpruntException {

		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "alexis");

			PreparedStatement req1 = connect
					.prepareStatement("Update Document set estLibre=? , login=? where numDoc=?");
			req1.setInt(1, 0);
			req1.setString(2, arg0.name());
			req1.setInt(3, this.numDoc);
			req1.executeUpdate();
			
			this.emprunteur = arg0.name();
			
			connect.commit();


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void rendre(Utilisateur arg0) throws RetourException {
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "alexis");

			PreparedStatement req1 = connect
					.prepareStatement("Update Document set estLibre=? , Login=? where numDoc=?");
			req1.setInt(1, 1);
			req1.setString(2,null);
			req1.setInt(3, this.numDoc);
			req1.executeUpdate();
			
			connect.commit();


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void reserver(Utilisateur arg0) throws ReservationException {

	}

	public String getTypeDoc() {
		switch (this.type) {
		case (1):
			return "Livre";
		case (2):
			return "CD";
		case (3):
			return "DVD";
		}
		return "";
	}

	public String getEstLibre() {
		if (this.estLibre)
			return "oui";
		else
			return "non";
	}

}
