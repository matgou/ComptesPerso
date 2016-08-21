package info.kapable.app.ComptesPerso.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.kapable.app.ComptesPerso.pojo.ThirdParty;

@RequestMapping("/thirdParty")
@RestController
public class ThirdPartyController extends CrudController<ThirdParty> {

	private static Logger logger = Logger.getLogger(ThirdPartyController.class);
	
	
	@Override
    @RequestMapping(value="/thirdParties", method = RequestMethod.GET)
	public List<ThirdParty> list() {
		return null;
	}

	@Override
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ThirdParty get(@PathVariable("id") Long id) {
		return null;
	}

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public ThirdParty save(@Valid @RequestBody ThirdParty o) {
		return null;
	}
}
