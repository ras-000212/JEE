package mediatheque;

import java.util.List;

public interface PersistentMediatheque {
	// Jean-Fran�ois Brette 01/01/2018    
	List<Documents> tousLesDocuments();  
	Documents getDocument(int numDocument);  
	Utilisateur getUser(String login, String password);  
	void nouveauDocument(int type, Object... args );  
	 
	}