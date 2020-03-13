package mediatheque;

import mediatek2020.items.Utilisateur;

public class Utilisateurs implements Utilisateur  {
	private String login;
	private String password;
	

	
	public Utilisateurs(String login, String password) {
		this.login = login;
		this.password = password;
	}


	public String toString() {
		return this.login;
	}


	@Override
	public Object[] data() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isBibliothecaire() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
