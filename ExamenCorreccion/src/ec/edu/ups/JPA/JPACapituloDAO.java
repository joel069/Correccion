package ec.edu.ups.JPA;

import ec.edu.ups.Dao.CapituloDAO;
import ec.edu.ups.Modelo.Capitulo;

public class JPACapituloDAO extends JPAGenericDAO<Capitulo, Integer> implements CapituloDAO{
	public JPACapituloDAO() {
		super(Capitulo.class);
	}
}
