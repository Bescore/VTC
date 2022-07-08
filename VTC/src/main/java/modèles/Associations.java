package modèles;

public class Associations {
	private int id_association;
	private Vehicules vehicule;
	private Conducteurs asso_conducteur;

	public Associations(int id_association, Vehicules vehicule, Conducteurs asso_conducteur) {
		super();
		this.id_association = id_association;
		this.vehicule = vehicule;
		this.asso_conducteur = asso_conducteur;
	}

	public Associations(Conducteurs asso_conducteur, Vehicules vehicule) {
		super();
		this.vehicule = vehicule;
		this.asso_conducteur = asso_conducteur;
	}

	public int getId_association() {
		return id_association;
	}

	public void setId_association(int id_association) {
		this.id_association = id_association;
	}

	public Vehicules getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicules vehicule) {
		this.vehicule = vehicule;
	}

	public Conducteurs getAsso_conducteur() {
		return asso_conducteur;
	}

	public void setAsso_conducteur(Conducteurs asso_conducteur) {
		this.asso_conducteur = asso_conducteur;
	}

	@Override
	public String toString() {
		return "Association [id_association=" + id_association + ", vehicule=" + vehicule + ", asso_conducteur="
				+ asso_conducteur + "]";
	}

}
