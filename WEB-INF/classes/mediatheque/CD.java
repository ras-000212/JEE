package mediatheque;

public class CD extends Documents {
	
	public CD(String auteur,String titre) {
		super(auteur, titre);
	}

	@Override
	public String getClassName() {
		return "CD";
	}
	
}
