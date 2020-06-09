package ec.edu.ups.JPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


import ec.edu.ups.Dao.LibroDAO;
import ec.edu.ups.Modelo.Autor;
import ec.edu.ups.Modelo.Capitulo;
import ec.edu.ups.Modelo.Libro;



public class JPALibroDAO extends JPAGenericDAO<Libro, Integer> implements LibroDAO{

	private EntityManager entityManager;
	
	public JPALibroDAO() {
		super(Libro.class);
		entityManager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	}

	@Override
	public List<Libro> getLibrosAutorCapitulo(Autor autor, Capitulo capitulo) {
		

		return null;
		}
				
		
}

	/**
	 
	 select * from libro, capitulo where
	 capitulo.id = libro.id 
	 and capitulo.autor = ?;
	 
	 */
	
	

