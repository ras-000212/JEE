package mediatheque;

public class Utilisateur {
	private String login;
	private String password;
	

	
	public Utilisateur(String login, String password) {
		this.login = login;
		this.password = password;
	}


	public String toString() {
		return this.login;
	}
	

}
