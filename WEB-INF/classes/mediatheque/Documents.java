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

	public Documents(int numDoc, int type, String auteur, String titre, boolean estLibre) {
		this.auteur = auteur;
		this.titre = titre;
		this.numDoc = numDoc;
		this.type = type;
		this.estLibre = estLibre;
		this.emprunteur = null;
	}

	@Override
	public Object[] data() {
		Object[] doc = { this.numDoc, this.getTypeDoc(), this.titre, this.auteur, this.getEstLibre() };
		return doc;
	}

	@Override
	public void emprunter(Utilisateur arg0) throws EmpruntException {

		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "alexis");

			PreparedStatement req1 = connect
					.prepareStatement("Update Document set estLibre=0 where numDoc=" + this.numDoc);
			req1.executeUpdate();

			PreparedStatement req2 = connect.prepareStatement("UPDATE Document set login = ? where nunmDoc = " + this.numDoc);
			req2.setString(1, arg0.name());
			req2.execute();
			
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
					.prepareStatement("Update Document set estLibre=1 where numDoc=" + this.numDoc);
			req1.executeUpdate();

			PreparedStatement req2 = connect.prepareStatement("DELETE Emprunt where login=? and numdoc=?");
			req2.setInt(2, this.numDoc);
			req2.setString(1, arg0.name());
			req2.execute();
			
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
