package info.kapable.app.ComptesPerso.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.kapable.app.ComptesPerso.pojo.Foyer;

@Repository
public class FoyerDAOImpl extends AbstractDAO<Foyer> implements FoyerDAO {

	@Override
	@Transactional
	public Foyer get(Long id) {
		return this.sessionFactory.getCurrentSession().load(Foyer.class, id);
	}
}
