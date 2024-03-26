package Model;

public class Personne {
	
	private String nom;
	private String prenom;
	private String email;
	private String pass;
	
	
	public Personne() {
		super();
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public Personne(String nom, String prenom, String email, String pass) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pass = pass;
	}

}
