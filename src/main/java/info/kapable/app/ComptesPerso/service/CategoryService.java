package info.kapable.app.ComptesPerso.service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;

import info.kapable.app.ComptesPerso.pojo.Category;

public abstract class CategoryService implements BasicService<Category>{

	public abstract long getNbCategory();
}
