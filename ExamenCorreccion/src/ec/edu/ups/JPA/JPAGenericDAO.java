package ec.edu.ups.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import  ec.edu.ups.Dao.GenericDAO;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID>{

	private final Class<T> persistentClass;
	protected EntityManager entityManager;
	
	public JPAGenericDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		this.entityManager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	}
	
	
	@Override
	public boolean create(T entidad) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(entidad);
			System.out.println(entidad.toString() + "<----");
			entityManager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			System.out.println("ERROR AL CREAR");
			if(entityManager.getTransaction().isActive())
				entityManager.getTransaction().rollback();
			return false;
		}
	}
	
	@Override
	public T findId(ID id) {
		//em.getTransaction().begin();
		return entityManager.find(persistentClass, id);
	}

	@Override
	public T read(ID id) {
		System.out.println("FIND -->" + id);
		return entityManager.find(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> readAll() {
		List<T> list = null;
		
		try {
			@SuppressWarnings("rawtypes")
			javax.persistence.criteria.CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
			criteriaQuery.select(criteriaQuery.from(persistentClass));
			list = entityManager.createQuery(criteriaQuery).getResultList();
		}catch(Exception e) {
			System.out.println("ERROR AL LEER TODOS LOS DATOS");
		}
		
		return list;
	}

	@Override
	public boolean update(T entity) {
		entityManager.getTransaction().begin();
		try {
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			System.out.println("ERROR AL ACTUALIZAR");
			if(entityManager.getTransaction().isActive())
				entityManager.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public boolean delete(T entity) {
		entityManager.getTransaction().begin();
		try {
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		}catch (Exception e) {
			System.out.println("ERROR AL BORRAR");
			if(entityManager.getTransaction().isActive())
				entityManager.getTransaction().rollback();
			return false;
		}
	}
	
	
}
