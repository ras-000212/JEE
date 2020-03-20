package mediatheque;

public class DVD extends Documents {

	private String genre;
	private float duree;
	
	public DVD(String auteur, String titre, String genre, float duree) {
		super(auteur, titre);
		this.genre=genre;
		this.duree=duree;		
	}

}
