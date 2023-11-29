package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Task;
import dto.Userdto;

public class Userdao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("villain");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public void addUser(Userdto u) {
		entityManager.getTransaction().begin();
		entityManager.persist(u);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public Userdto findBYEmail(String email) {
		Query query = entityManager.createQuery("select x from Userdto x where email=?1").setParameter(1, email);
		List<Userdto> list = query.getResultList();
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	public void saveTask(Task task) {
		entityManager.getTransaction().begin();
		entityManager.persist(task);
		entityManager.getTransaction().commit();
	}
	
	public void updateUser(Userdto dto) {
		entityManager.getTransaction().begin();
		entityManager.merge(dto);
		entityManager.getTransaction().commit();
	}
}
