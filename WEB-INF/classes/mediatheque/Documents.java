package mediatheque;

import mediatek2020.items.Document;
import mediatek2020.items.EmpruntException;
import mediatek2020.items.ReservationException;
import mediatek2020.items.RetourException;
import mediatek2020.items.Utilisateur;

public class Documents implements Document {
	
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

}
