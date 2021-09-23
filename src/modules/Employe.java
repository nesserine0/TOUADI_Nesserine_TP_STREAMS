package modules;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Employe {

	private int Id;
	private String Nom;
	private String Prenom;
	private Date DateDeNaissance;
	private char sexe;
	private boolean marie;
	private double salaire;
	private int IdDepartement;
	
	
	public Employe(int id, String nom, String prenom, Date dateDeNaissance, char sexe, boolean marie, double salaire,
			int idDepartement) {
		super();
		Id = id;
		Nom = nom;
		Prenom = prenom;
		DateDeNaissance = dateDeNaissance;
		this.sexe = sexe;
		this.marie = marie;
		this.salaire = salaire;
		IdDepartement = idDepartement;
	}
	
	
	public Employe() {
		super();
		
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public String getPrenom() {
		return Prenom;
	}


	public void setPrenom(String prenom) {
		Prenom = prenom;
	}


	public Date getDateDeNaissance() {
		return DateDeNaissance;
	}


	public void setDateDeNaissance(Date dateDeNaissance) {
		DateDeNaissance = dateDeNaissance;
	}


	public char getSexe() {
		return sexe;
	}


	public void setSexe(char sexe) {
		this.sexe = sexe;
	}


	public boolean isMarie() {
		return marie;
	}


	public void setMarie(boolean marie) {
		this.marie = marie;
	}


	public double getSalaire() {
		return salaire;
	}


	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}


	public int getIdDepartement() {
		return IdDepartement;
	}


	public void setIdDepartement(int idDepartement) {
		IdDepartement = idDepartement;
	}
	
	
	
	public int getAge() {
		  LocalDate current_date = LocalDate.now();
		  
		return  current_date.getYear()-(this.DateDeNaissance.getYear()+1900);
	}
	
	
}
