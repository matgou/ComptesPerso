package info.kapable.app.ComptesPerso.service;

import java.util.List;

import org.springframework.data.domain.Page;

import info.kapable.app.ComptesPerso.pojo.Category;

public abstract class CategoryService implements BasicService<Category>{

	public abstract long getNbCategory();

	public abstract Page<Category> searchByLabelAndParent(int pageNumber, int pageSize, String label, int parentId);

	public abstract List<Category> getCategoriesWithNoParent();

}
