package info.kapable.app.ComptesPerso.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import info.kapable.app.ComptesPerso.pojo.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long> {

	@Query(value = "SELECT c FROM Category c WHERE c.parent = :parent")
	Page<Category> findByParent(Pageable page, @Param("parent") Category parent);

	@Query(value = "SELECT c FROM Category c WHERE c.label like %:label%")
	Page<Category> findByLabel(Pageable page, @Param("label") String label);

	@Query(value = "SELECT c FROM Category c WHERE c.label like %:label% AND c.parent = :parent")
	Page<Category> findByParentAndLabel(Pageable page, @Param("parent") Category parent, @Param("label") String label);

	@Query(value = "SELECT c FROM Category c WHERE c.parent = null")
	List<Category> findByParentNull();
	
}
