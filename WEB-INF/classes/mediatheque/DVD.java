package mediatheque;

public class DVD extends Documents {
	
	public DVD(String auteur, String titre) {
		super(auteur, titre);	
	}

	@Override
	public String getClassName() {
		return "DVD";
	}

}
