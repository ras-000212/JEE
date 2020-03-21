package mediatheque;

import mediatek2020.items.Document;
import mediatek2020.items.EmpruntException;
import mediatek2020.items.ReservationException;
import mediatek2020.items.RetourException;
import mediatek2020.items.Utilisateur;

public abstract class Documents implements Document {
	
	private static int NUM_DOC = 0;
	private String auteur;
	private String titre;
	
	public Documents(String auteur, String titre) {
		this.auteur = auteur;
		this.titre = titre;
		this.NUM_DOC++;
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
	
	public abstract String getClassName ();

}
