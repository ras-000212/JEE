package mediatheque;

import mediatek2020.items.Utilisateur;

public class Utilisateurs implements Utilisateur  {
	private String login;
	private String password;
	private Boolean isBibliothecaire;
	

	
	public Utilisateurs(String login, String password) {
		this.login = login;
		this.password = password;
		this.isBibliothecaire = false;
	}
	
	public Utilisateurs(String login, String password, Boolean isAdmin) {
		this.login = login;
		this.password = password;
		this.isBibliothecaire = true;
	}

	@Override
	public Object[] data() {
		return null;
	}


	@Override
	public boolean isBibliothecaire() {
		return this.isBibliothecaire;
	}


	@Override
	public String name() {
		return this.login;
	}
	

}
