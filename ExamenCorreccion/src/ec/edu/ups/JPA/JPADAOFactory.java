package ec.edu.ups.JPA;

import  ec.edu.ups.Dao.AutorDAO;
import  ec.edu.ups.Dao.CapituloDAO;
import  ec.edu.ups.Dao.DAOFactory;
import  ec.edu.ups.Dao.LibroDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public LibroDAO getLibroDAO() {
		return new JPALibroDAO();
	}

	@Override
	public CapituloDAO getCapituloDAO() {
		// TODO Auto-generated method stub
		return new JPACapituloDAO();
	}

	@Override
	public AutorDAO getAutorDAO() {
		// TODO Auto-generated method stub
		return new JPAAutorDAO();
	}
	
	
	
}
