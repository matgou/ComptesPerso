package info.kapable.app.ComptesPerso.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import info.kapable.app.ComptesPerso.dao.ThirdPartyDAO;
import info.kapable.app.ComptesPerso.pojo.ThirdParty;

@Service
public class ThirdPartyServiceImpl extends ThirdPartyService {

	@Autowired
	protected ThirdPartyDAO thirdPartyDAO;

	@Override
	public Page<ThirdParty> getAll() {
		return this.getAll(0, 10);
	}
	
	public Page<ThirdParty> getAll(int pageNumber, int pageSize) {
		PageRequest page = new PageRequest(pageNumber, pageSize);
		Page<ThirdParty> t = this.thirdPartyDAO.findAll(page);
		return t;
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

	@Override
	public Page<ThirdParty> find(int pageSize, int pageNumber, Map<String, Object> criterias) {
		// TODO Auto-generated method stub
		return null;
	}
}
