package mediatheque;

public class CD extends Documents {
	private String maisonDisque;
	private int nbrMorceau;

	public CD(String auteur,String titre, String maisonDisque, int nbrMorceau) {
		super(auteur, titre);
		this.maisonDisque=maisonDisque;
		this.nbrMorceau=nbrMorceau;
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}



}
