package info.kapable.app.ComptesPerso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.kapable.app.ComptesPerso.pojo.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long> {
	
}
