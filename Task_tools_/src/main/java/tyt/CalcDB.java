package tyt;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
@Stateless

public class CalcDB {
	
	@PersistenceContext
	private EntityManager em;
	
	    public CalcDB() {
	    }

	    public void insert(Calculation calculation) {
	        em.persist(calculation);
	    }

	    public List<Calculation> SelectAll() {
	    	
	    	TypedQuery<Calculation> query=em.createQuery("SELECT p FROM Calculation p",Calculation.class);
	    	
	        return query.getResultList();
	    }

}
