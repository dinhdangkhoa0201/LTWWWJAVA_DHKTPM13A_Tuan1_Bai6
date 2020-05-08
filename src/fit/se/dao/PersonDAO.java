package fit.se.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fit.se.beans.Person;

public class PersonDAO {
	private EntityManager em;
	public PersonDAO() {
		em = PersonEntityManager.getInstance().getEntityManager();
	}
	
	public boolean addPerson(Person person) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(person);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	public void updatePerson(Person person) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(person);
			tr.commit();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}
	
	public boolean deletePerson(Person person) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(Person.class, person.getId()));
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Person> getPeople(){
		List<Person> people = new ArrayList<Person>();
		List<?> temp = em.createNativeQuery("db.people.find({})", Person.class).getResultList();
		temp.forEach(x -> {
			Person person = (Person) x;
			people.add(person);
		});
		return people;
	}
}
