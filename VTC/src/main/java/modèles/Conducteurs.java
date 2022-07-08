package modèles;

public class Conducteurs {
	private int id;
	private String nom;
	private String prenom;

	public Conducteurs(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Conducteurs(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Conducteurs(int id) {
		super();
		this.id = id;
	}

	public Conducteurs() {
		// TODO Auto-generated constructor stub
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "conducteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
