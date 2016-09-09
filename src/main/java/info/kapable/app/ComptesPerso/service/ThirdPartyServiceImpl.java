package info.kapable.app.ComptesPerso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.kapable.app.ComptesPerso.dao.ThirdPartyDAO;
import info.kapable.app.ComptesPerso.pojo.ThirdParty;

@Service
public class ThirdPartyServiceImpl extends ThirdPartyService {

	@Autowired
	protected ThirdPartyDAO thirdPartyDAO;

	@Override
	public List<ThirdParty> getAll() {
		return this.thirdPartyDAO.findAll();
	}

	@Override
	public ThirdParty get(Long id) {
		return this.thirdPartyDAO.findOne(id);
	}

	@Override
	public ThirdParty save(ThirdParty o) {
		return this.thirdPartyDAO.save(o);
	}

	@Override
	public void remove(ThirdParty o) {
		this.thirdPartyDAO.delete(o);
	}
}
