package mediatheque;

import java.util.List;

import mediatek2020.items.Utilisateur;

public interface PersistentMediatheque {
	// Jean-François Brette 01/01/2018    
	List<Documents> tousLesDocuments();  
	Documents getDocument(int numDocument);  
	Utilisateur getUser(String login, String password);  
	void nouveauDocument(int type, Object... args );  
	 
	}
