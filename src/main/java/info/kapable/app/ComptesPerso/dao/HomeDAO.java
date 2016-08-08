package info.kapable.app.ComptesPerso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.kapable.app.ComptesPerso.pojo.Home;

@Repository
public interface HomeDAO extends JpaRepository<Home, Long> {	
}
