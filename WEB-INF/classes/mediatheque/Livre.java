package mediatheque;

public class Livre extends Documents {

	private String editeur;
	private int nbrPages;


	public Livre(String auteur, String titre,String editeur, int nbrPages) {
		super(auteur, titre);
		this.editeur=editeur;
		this.nbrPages=nbrPages;
	}


	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}

}