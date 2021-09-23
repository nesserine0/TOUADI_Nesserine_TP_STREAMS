package modules;

public class Departement {

	private int Id;
	private String Libelle;
	
	
	public Departement(int id, String libelle) {
		super();
		Id = id;
		Libelle = libelle;
	}
	
	public Departement() {
		super();
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	
	
	
	
}
