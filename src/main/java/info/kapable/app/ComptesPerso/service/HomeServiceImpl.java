package info.kapable.app.ComptesPerso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.kapable.app.ComptesPerso.dao.HomeDAO;
import info.kapable.app.ComptesPerso.pojo.Home;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	protected HomeDAO foyerDAO;

	public Home newFoyer(String name) {
		Home foyer = new Home(name);
		this.foyerDAO.save(foyer);
		return foyer;
	}

	@Override
	public Home getFoyer(Long id) {

		return this.foyerDAO.findOne(id);
	}

	@Override
	public void updateFoyer(Home foyer) {
		this.foyerDAO.save(foyer);

	}
}
