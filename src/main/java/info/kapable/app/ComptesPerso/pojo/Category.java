package info.kapable.app.ComptesPerso.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import info.kapable.app.ComptesPerso.validator.MaxCategoryLevel;

/**
 * Category object 
 * 
 * @author Mathieu GOULIN <mathieu.goulin@gadz.org>
 */
@Entity
@Table(name = "CATEGORIE")
@JsonIgnoreProperties({"child", "operations"})
public class Category extends Pojo {
	/* STATIC PARAM */

	/* Private properties */
	private Long id;
	private boolean categoryDebit = true;
	
	@Size(min=2, max=255, message = "{errors.label.size}") 
	@NotNull(message = "{error.label.notnull}")
	private String label;
	@MaxCategoryLevel()
	private Category parent;

	/* Link to object */
	private List<Category> child;
	private List<Operation> operations;

	public Category(String label) {
		this.label = label;
	}
	
	public Category() {
		
	}
	
	/**
	 * Getter and Setter
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the label
	 */
	@Column(name = "LIBELLE", nullable = false)
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * @return the categoryDebit
	 */
	@Column(name = "CATEGORIEDEDEBIT", nullable = false)
	public boolean isCategoryDebit() {
		return categoryDebit;
	}
	/**
	 * @param categoryDebit the categoryDebit to set
	 */
	public void setCategoryDebit(boolean categoryDebit) {
		this.categoryDebit = categoryDebit;
	}
	
	/**
	 * @return the parent
	 */
	@ManyToOne
    @JoinColumn(name="CATEGORIE_PARENT_ID", nullable = true)
	public Category getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(Category parent) {
		this.parent = parent;
	}
	
	/**
	 * @return the child
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
	public List<Category> getChild() {
		return child;
	}
	/**
	 * @param child the child to set
	 */
	public void setChild(List<Category> child) {
		this.child = child;
	}

	/**
	 * @return the operations
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	@OrderBy("date")
	public List<Operation> getOperations() {
		return operations;
	}

	/**
	 * @param operations the operations to set
	 */
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}


}
