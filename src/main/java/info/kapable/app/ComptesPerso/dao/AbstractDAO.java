package info.kapable.app.ComptesPerso.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDAO<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    @Transactional
    public void save(Object o) {
    	this.sessionFactory.getCurrentSession().save(o);
    }
}
