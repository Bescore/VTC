package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modèles.test;

public class testDao implements IDAO <test> {

	@Override
	public boolean add(test object) {
		// TODO Auto-generated method stub
		Connection connect = new Connection_to_sql().getConnection();
		try {
			PreparedStatement sql = connect
					.prepareStatement("INSERT INTO test(test) VALUES(?)");

			sql.setString(1, object.getTest());
			

			sql.executeUpdate();
			System.out.println("test inséré en base de donnée");
			connect.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	@Override
	public ArrayList<test> read() {
		// TODO Auto-generated method stub
		ArrayList<test> tab_test = new ArrayList<>();
		// TODO Auto-generated method stub
		Connection connect = new Connection_to_sql().getConnection();
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT*FROM test");

			ResultSet rs = sql.executeQuery();

			while (rs.next()) {

				test test=new test();
				test.setTest(rs.getString("test"));
				tab_test.add(test);
			}
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return tab_test;
	}

	@Override
	public boolean update(test object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(test object) {
		// TODO Auto-generated method stub
		return false;
	}

}
