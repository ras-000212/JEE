package mediatheque;

public class Livre extends Documents {
	
	public Livre(String auteur, String titre) {
		super(auteur, titre);
	}

	@Override
	public String getClassName() {
		return "Livre";
	}
	
}
