package info.kapable.app.ComptesPerso.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.kapable.app.ComptesPerso.pojo.ThirdParty;
import info.kapable.app.ComptesPerso.service.CategoryService;
import info.kapable.app.ComptesPerso.service.ThirdPartyService;

@RequestMapping("/thirdParty")
@RestController
public class ThirdPartyController extends CrudController<ThirdParty> {

	private static Logger logger = Logger.getLogger(ThirdPartyController.class);

	@Autowired
	private ThirdPartyService thirdPartyService;
	
	@Override
    @RequestMapping(value="/thirdParties", method = RequestMethod.GET)
	public List<ThirdParty> list() {
		logger.debug("Get all thirdParties");
		return thirdPartyService.getAll();
	}

	@Override
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ThirdParty get(@PathVariable("id") Long id) {
		logger.debug("Get thirdParties id=" + id );
		return thirdPartyService.get(id);
	}

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public ThirdParty save(@Valid @RequestBody ThirdParty o) {
		logger.debug("Save thirdParties id=" + o.getId() );
		return thirdPartyService.save(o);
	}


	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		logger.debug("Delete thirdParties id=" + id);
		thirdPartyService.remove(this.get(id));
	}
}
