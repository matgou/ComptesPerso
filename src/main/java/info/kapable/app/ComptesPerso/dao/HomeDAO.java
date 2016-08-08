package info.kapable.app.ComptesPerso.dao;

import info.kapable.app.ComptesPerso.pojo.Home;
import info.kapable.app.ComptesPerso.pojo.Pojo;

public interface HomeDAO {

	void save(Pojo o);

	Home get(Long id);
	
}
