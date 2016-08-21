package info.kapable.app.ComptesPerso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.ThirdParty;

@Repository
public interface ThirdPartyDAO extends JpaRepository<ThirdParty, Long> {
}
