package Model;

public class Doctor {
	private int id;
	private String nom_complet;
	private String spesialite;
	private String age;
	private String ville;
	public Doctor() {
		super();
	}
	public Doctor(int id, String nom_complet, String spesialite, String age, String ville) {
		super();
		this.id = id;
		this.nom_complet = nom_complet;
		this.spesialite = spesialite;
		this.age = age;
		this.ville = ville;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_complet() {
		return nom_complet;
	}
	public void setNom_complet(String nom_complet) {
		this.nom_complet = nom_complet;
	}
	public String getSpesialite() {
		return spesialite;
	}
	public void setSpesialite(String spesialite) {
		this.spesialite = spesialite;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	 

}
