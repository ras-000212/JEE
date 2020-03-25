package mediatheque;

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
	
	public Documents(int numDoc,int type,String auteur, String titre) {
		this.auteur = auteur;
		this.titre = titre;
		this.numDoc=numDoc;
		this.type = type;
	}
	
	@Override
	public Object[] data() {
		
		return null;
	}

	@Override
	public void emprunter(Utilisateur arg0) throws EmpruntException {
		
	}

	@Override
	public void rendre(Utilisateur arg0) throws RetourException {
		
	}

	@Override
	public void reserver(Utilisateur arg0) throws ReservationException {
		
	}
	
	public String getTypeDoc () {
		switch (this.type) {
		case (1):
			return "Livre";
		case (2):
			return "CD";
		case(3):
			return "DVD";
		}
		return "";	
	}

}
