package info.kapable.app.ComptesPerso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import info.kapable.app.ComptesPerso.pojo.ThirdParty;

@Repository
public interface ThirdPartyDAO extends JpaRepository<ThirdParty, Long> {

	@Query(value="SELECT COUNT(*) FROM ThirdParty t")
	public int getNbThirdParty();
}
