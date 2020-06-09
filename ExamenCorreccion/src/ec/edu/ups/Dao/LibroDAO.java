package ec.edu.ups.Dao;

import java.util.List;


import ec.edu.ups.Modelo.Autor;
import ec.edu.ups.Modelo.Capitulo;
import ec.edu.ups.Modelo.Libro;



public interface LibroDAO extends GenericDAO<Libro, Integer>{

	public List<Libro> getLibrosAutorCapitulo(Autor autor, Capitulo capitulo);
	
	
}
