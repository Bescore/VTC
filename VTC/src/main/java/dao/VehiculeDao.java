package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modèles.Conducteurs;
import modèles.Vehicules;

public class VehiculeDao implements IDAO<Vehicules> {

	Connection connect = new Connection_to_sql().getConnection();

	@Override
	public boolean add(Vehicules object) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement sql = connect
					.prepareStatement("INSERT INTO vehicule(marque,modele,couleur,immatriculation) VALUES(?,?,?,?)");

			sql.setString(1, object.getMarque());
			sql.setString(2, object.getModele());
			sql.setString(3, object.getCouleur());
			sql.setString(4, object.getImmatriculation());

			sql.executeUpdate();
			System.out.println("inséré dans vehicule");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	@Override
	public ArrayList<Vehicules> read() {
		ArrayList<Vehicules> tab_vehicule = new ArrayList<>();
		// TODO Auto-generated method stub

		try {
			PreparedStatement sql = connect.prepareStatement("SELECT*FROM vehicule");

			ResultSet rs = sql.executeQuery();

			while (rs.next()) {

				Vehicules vehicule = new Vehicules(rs.getInt("idvehicule"), rs.getString("marque"),
						rs.getString("modele"), rs.getString("couleur"), rs.getString("immatriculation"));
				tab_vehicule.add(vehicule);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return tab_vehicule;
	}

	@Override
	public boolean update(Vehicules object) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement sql=connect.prepareStatement("SELECT * FROM vehicule WHERE idvehicule=?");
			
			sql.setInt(1, object.getId_vehicule());
			
			ResultSet rs=sql.executeQuery();
			if(rs.next()) {
				
				
				try {
					PreparedStatement sqll=connect.prepareStatement("UPDATE vehicule set marque=?,modele=?,couleur=?,immatriculation=? WHERE idvehicule=?");
					
					sqll.setString(1, object.getMarque());
					sqll.setString(2, object.getModele());
					sqll.setString(3, object.getCouleur());
					sqll.setString(4, object.getImmatriculation());
					sqll.setInt(5, object.getId_vehicule());
					
					sqll.executeUpdate();
					System.out.println("conducteur modifié !");
					return true;
				} catch (Exception e) {
					// TODO: handle exception
					e.getMessage();
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	
		return false;	
	}

	@Override
	public boolean delete(Vehicules object) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement sqll=connect.prepareStatement("DELETE FROM vehicule  WHERE idvehicule=?");
			
			sqll.setInt(1, object.getId_vehicule());
			
			
			sqll.executeUpdate();
			System.out.println("vehicule supprimé !");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
		return false;
	}
	
	public Vehicules findby(Vehicules object) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement sqll=connect.prepareStatement("SELECT * FROM vehicule  WHERE idvehicule=?");
			
			sqll.setInt(1, object.getId_vehicule());
			
			ResultSet rs=sqll.executeQuery();
			
			if(rs.next()) {
				Vehicules vehicule=new Vehicules(rs.getInt("idvehicule"),rs.getString("marque"),rs.getString("modele"),
						rs.getString("couleur"),rs.getString("immatriculation"));
				return vehicule;
			}
			
			
			System.out.println("vehicule trouvé !");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
		return null;
	}
	
	
	public ArrayList<Vehicules> read_vehicule_no_cond() {
		ArrayList<Vehicules> tab_vehicule = new ArrayList<>();
		// TODO Auto-generated method stub

		try {
			PreparedStatement sql = connect.prepareStatement("SELECT*FROM vehicule LEFT JOIN association ON vehicule.idvehicule= association.asso_vehicule WHERE idassociation is null");

			ResultSet rs = sql.executeQuery();

			while (rs.next()) {

				Vehicules vehicule = new Vehicules(rs.getInt("idvehicule"), rs.getString("marque"),
						rs.getString("modele"), rs.getString("couleur"), rs.getString("immatriculation"));
				tab_vehicule.add(vehicule);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return tab_vehicule;
	}

}
