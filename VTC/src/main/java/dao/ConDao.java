package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import modèles.Conducteurs;

public class ConDao implements IDAO<Conducteurs> {
	Connection connect=new Connection_to_sql().getConnection();


	@Override
	public boolean add(Conducteurs object) {
		// TODO Auto-generated method stub
		
		
		try {
			PreparedStatement sql=connect.prepareStatement("INSERT INTO conducteur(nom,prenom) VALUES(?,?)");
			
			sql.setString(1, object.getNom());
			sql.setString(2, object.getPrenom());
			
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
	public ArrayList<Conducteurs> read() {
		ArrayList<Conducteurs>tab_cond= new ArrayList<>();
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement sql=connect.prepareStatement("SELECT*FROM conducteur");
			
			ResultSet rs =sql.executeQuery();
			
			while ( rs.next()){
				
				Conducteurs cond= new Conducteurs(rs.getInt("idconducteur"),rs.getString("nom"),rs.getString("prenom"));
				tab_cond.add(cond);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return tab_cond;
	}

	@Override
	public boolean update(Conducteurs object) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement sql=connect.prepareStatement("SELECT * FROM conducteur WHERE idconducteur=?");
			
			sql.setInt(1, object.getId());
			
			ResultSet rs=sql.executeQuery();
			if(rs.next()) {
				
				
				try {
					PreparedStatement sqll=connect.prepareStatement("UPDATE conducteur set nom=?,prenom=? WHERE idconducteur=?");
					
					sqll.setString(1, object.getNom());
					sqll.setString(2, object.getPrenom());
					sqll.setInt(3, object.getId());
					
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
	public boolean delete(Conducteurs object) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement sqll=connect.prepareStatement("DELETE FROM conducteur  WHERE idconducteur=?");
			
			sqll.setInt(1, object.getId());
			
			
			sqll.executeUpdate();
			System.out.println("conducteur supprimé !");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
		return false;
	}
	
	
	public Conducteurs findby(Conducteurs object) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement sqll=connect.prepareStatement("SELECT * FROM conducteur  WHERE idconducteur=?");
			
			sqll.setInt(1, object.getId());
			
			ResultSet rs=sqll.executeQuery();
			
			if(rs.next()) {
				Conducteurs cond=new Conducteurs(rs.getInt("idconducteur"),rs.getString("nom"),rs.getString("prenom"));
				return cond;
			}
			
			
			System.out.println("conducteur trouvé !");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
		return null;
	}

}
