package info.kapable.app.ComptesPerso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.kapable.app.ComptesPerso.dao.HomeDAO;
import info.kapable.app.ComptesPerso.pojo.Home;

@Service
@Transactional(rollbackFor = {RuntimeException.class})
public class HomeServiceImpl implements HomeService {

	@Autowired
	protected HomeDAO foyerDAO;

	@Transactional(rollbackFor = {RuntimeException.class})
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
	@Transactional(rollbackFor = {RuntimeException.class})
	public void updateFoyer(Home foyer) {
		this.foyerDAO.save(foyer);
	}
}
