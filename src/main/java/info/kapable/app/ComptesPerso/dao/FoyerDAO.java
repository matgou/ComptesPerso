package info.kapable.app.ComptesPerso.dao;

import info.kapable.app.ComptesPerso.pojo.Foyer;
import info.kapable.app.ComptesPerso.pojo.Pojo;

public interface FoyerDAO {

	void save(Pojo o);

	Foyer get(Long id);
	
}
