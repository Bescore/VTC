package dao;

import java.util.ArrayList;

public interface IDAO<T> {

	
	public boolean add(T object);
	public ArrayList<T> read();
	public boolean update(T object);
	public boolean delete(T object);

}
