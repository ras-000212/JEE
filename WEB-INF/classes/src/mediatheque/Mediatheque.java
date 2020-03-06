package mediatheque;

import mediatek2020.items.Document;

public class Mediatheque {
	
	private PersistentMediatheque data; 
	
	public void setData(PersistentMediatheque data) {
		if (this.data == null) this.data = data;  
		} 
	 
	// exemple de m�thode qui agit sur le document 
	public void emprunt(Document d, Utilisateur u) throws EmpruntException {   
		d.emprunter(u);  
	} 
	 
	// exemple de m�thode qui d�l�gue � data
	public Utilisateur getUser (String login, String password) {   
		return data.getUser(login, password);  
	}  
}
