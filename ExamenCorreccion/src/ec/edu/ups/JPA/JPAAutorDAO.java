package ec.edu.ups.JPA;

import ec.edu.ups.Dao.AutorDAO;
import ec.edu.ups.Modelo.Autor;

public class JPAAutorDAO extends JPAGenericDAO<Autor, Integer> implements AutorDAO{

	public JPAAutorDAO() {
		super(Autor.class);
	}
	
}
