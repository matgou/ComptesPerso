package info.kapable.app.ComptesPerso.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.kapable.app.ComptesPerso.pojo.Foyer;

@Repository
@Transactional
public class FoyerDAOImpl extends AbstractDAO<Foyer> implements FoyerDAO {
}
