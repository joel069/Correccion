package ec.edu.ups.Dao;

import ec.edu.ups.JPA.JPADAOFactory;

public abstract class DAOFactory {

	protected static DAOFactory factory = new JPADAOFactory();
	
	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract LibroDAO getLibroDAO();
	public abstract CapituloDAO getCapituloDAO();
	public abstract AutorDAO getAutorDAO();
	
}
