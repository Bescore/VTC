package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modèles.Associations;
import modèles.Conducteurs;
import modèles.Vehicules;

public class AssociationDao implements IDAO<Associations> {
	Connection connect = new Connection_to_sql().getConnection();

	@Override
	public boolean add(Associations object) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement sql = connect
					.prepareStatement("INSERT INTO association(asso_vehicule,asso_conducteur) VALUES(?,?)");

			sql.setInt(1, object.getVehicule().getId_vehicule());
			sql.setInt(2, object.getAsso_conducteur().getId());

			sql.executeUpdate();
			System.out.println("inséré dans conducteur");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	@Override
	public ArrayList<Associations> read() {
		// TODO Auto-generated method stub
		ArrayList<Associations> tab_asso = new ArrayList<>();
		// TODO Auto-generated method stub

		try {
			PreparedStatement sql = connect.prepareStatement("SELECT*FROM conducteur "
					+ "INNER JOIN association ON conducteur.idconducteur= association.asso_conducteur "
					+ "INNER JOIN vehicule ON vehicule.idvehicule=association.asso_vehicule");

			ResultSet rs = sql.executeQuery();

			while (rs.next()) {
				Vehicules new_vehi = new Vehicules(rs.getInt("idvehicule"), rs.getString("marque"),
						rs.getString("modele"), rs.getString("couleur"), rs.getString("immatriculation"));
				Conducteurs new_cond = new Conducteurs(rs.getInt("idconducteur"), rs.getString("nom"),
						rs.getString("prenom"));
				/***********************************************************************************************************/
				Associations asso = new Associations(rs.getInt("idassociation"), new_vehi, new_cond);
				tab_asso.add(asso);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return tab_asso;
	}

	@Override
	public boolean update(Associations object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Associations object) {
		// TODO Auto-generated method stub
		return false;
	}

}
