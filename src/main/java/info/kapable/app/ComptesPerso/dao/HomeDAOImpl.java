package info.kapable.app.ComptesPerso.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.kapable.app.ComptesPerso.pojo.Home;

@Repository
public class HomeDAOImpl extends AbstractDAO<Home> implements HomeDAO {

	@Override
	@Transactional
	public Home get(Long id) {
		return this.sessionFactory.getCurrentSession().load(Home.class, id);
	}
}
