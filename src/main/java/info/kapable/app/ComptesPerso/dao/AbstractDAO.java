package info.kapable.app.ComptesPerso.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import info.kapable.app.ComptesPerso.pojo.Pojo;

public abstract class AbstractDAO<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    public void save(Pojo o) {
    	Session session = this.sessionFactory.getCurrentSession();
    	Transaction t = session.beginTransaction();
    	if(o.getId() != null) {
    		session.evict(o);
    		session.update(o);
    	} else {
    		session.persist(o);
    	}
    	t.commit();
    }
}
