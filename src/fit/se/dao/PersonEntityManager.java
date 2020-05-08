package fit.se.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class PersonEntityManager {
	private static PersonEntityManager instance = null;
	private EntityManager em;
	
	public PersonEntityManager() {
		em = Persistence.createEntityManagerFactory("LTWWWJAVA_DHKTPM13A_TUAN01_DINHDANGKHOA_Bai6").createEntityManager();
	}
	
	public synchronized static PersonEntityManager getInstance() {
		if(instance == null)
			instance = new PersonEntityManager();
		return instance;
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	public static void main(String[] args) {
		new PersonEntityManager();
	}
}
