package com.zzzzzyx.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Session Bean implementation class SumTool
 */
@Stateless
@LocalBean
public class SumTool implements SumToolLocal {

//	@EJB
//	StudentDaoLocal studentDao;
    /**
     * Default constructor. 
     */
    public SumTool() {
        // TODO Auto-generated constructor stub
    }
    
    public float add(float f1, float f2) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");
        EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("from Student s order by id asc");
		java.util.List l = query.getResultList();
		Student s = (Student)l.get(0) ;
		
        return Float.parseFloat(s.getPassword());
//    	return 0;
  }

}
