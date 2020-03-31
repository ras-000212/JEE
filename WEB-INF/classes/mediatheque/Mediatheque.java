package mediatheque;

import java.util.List;

import mediatek2020.items.Document;
import mediatek2020.items.EmpruntException;
import mediatek2020.items.Utilisateur;

public class Mediatheque {
	
	private PersistentMediatheque data; 
	
	public void setData(PersistentMediatheque data) {
		if (this.data == null) this.data = data;  
	} 
	 
	// exemple de méthode qui agit sur le document 
	public void emprunt(Document d, Utilisateur u) throws EmpruntException {   
		d.emprunter(u);  
	} 
	 
	// exemple de méthode qui délègue à data
	public Utilisateur getUser (String login, String password) {   
		return data.getUser(login, password);  
	}  
	
	public void nouveauDocument(int type, Object... args) {
		data.nouveauDocument(type, args);
	}
	
	public Object[] tousLesDocuments() {
		List<Document> documents =data.tousLesDocuments();
		
		return null;
		
	}
}
