package info.kapable.app.ComptesPerso.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Category object 
 * 
 * @author Mathieu GOULIN <mathieu.goulin@gadz.org>
 */
@Entity
@Table(name = "TIERS")
@JsonIgnoreProperties({"operations"})
public class ThirdParty extends Pojo {
	/* Private properties */
	private Long id;

	@Size(min=2, max=255, message = "{errors.label.size}") 
	private String label;
	
	private List<Operation> operations;
	
	/**
	 * Getter and Setter
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the operations
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "thirdParty")
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
	/**
	 * @return the label
	 */
	@Column(name = "LIBELLE", nullable = false)
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

}
