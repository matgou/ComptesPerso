package info.kapable.app.ComptesPerso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.kapable.app.ComptesPerso.dao.ThirdPartyDAO;
import info.kapable.app.ComptesPerso.pojo.ThirdParty;

@Service
@Transactional(rollbackFor = {RuntimeException.class})
public class ThirdPartyServiceImpl implements ThirdPartyService {

	@Autowired
	protected ThirdPartyDAO thirdPartyDAO;

	@Override
	public ThirdParty getThirdParty(Long id) {
		return this.thirdPartyDAO.findOne(id);
	}

	@Override
	public void updateThirdParty(ThirdParty thirdParty) {
		this.thirdPartyDAO.save(thirdParty);
	}

	@Override
	public ThirdParty save(ThirdParty t) {
		return this.thirdPartyDAO.save(t);
	}

	@Override
	public List<ThirdParty> getThirdParties() {
		return this.thirdPartyDAO.findAll();
	}

	@Override
	public ThirdParty get(Long id) {
		return this.thirdPartyDAO.findOne(id);
	}
	
}
