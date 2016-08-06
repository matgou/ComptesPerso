package info.kapable.app.ComptesPerso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.kapable.app.ComptesPerso.dao.FoyerDAO;
import info.kapable.app.ComptesPerso.pojo.Foyer;

@Service
public class FoyerServiceImpl implements FoyerService {

	@Autowired
	protected FoyerDAO foyerDAO;

	public Foyer newFoyer(String name) {
		Foyer foyer = new Foyer(name);
		this.foyerDAO.save(foyer);
		return foyer;
	}

	@Override
	public Foyer getFoyer(Long id) {

		return this.foyerDAO.get(id);
	}

	@Override
	public void updateFoyer(Foyer foyer) {
		this.foyerDAO.save(foyer);

	}
}
