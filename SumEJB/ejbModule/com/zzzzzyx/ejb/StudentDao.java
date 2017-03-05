package com.zzzzzyx.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Stateless
@LocalBean
public class StudentDao implements StudentDaoLocal{


	public Student findByName(String username) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");
        EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("from student s where username = " + username);
		Student s = (Student) query.getSingleResult();
		return s;
	}
	
}
