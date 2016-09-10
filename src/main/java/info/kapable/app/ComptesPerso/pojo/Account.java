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

@Entity
@Table(name = "COMPTE")
@JsonIgnoreProperties({"operations"})
/**
 * Un compte représente un compte en banque (livret épargne, compte courant)
 * 
 * @author Mathieu GOULIN <mathieu.goulin@gadz.org>
 *
 */
public class Account extends Pojo {

	/* STATIC PARAM */
	public static final Integer TYPE_COMPTE_COURANT = 1;
	public static final Integer TYPE_EPARGNE_DISPO = 2;
	public static final Integer TYPE_EPARGNE_TERME = 3;

	/* Private properties */
	private Long id;
	
	@Size(min=2, max=255, message = "{errors.label.size}") 
	private String label;
	private boolean enable = true;
	private Integer type;
	private Double intialValue;

	/* Link to object */
	private List<Operation> operations;

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
	 * @return the enable
	 */
	@Column(name = "COMPTE_ACTIF", nullable = false)
	public boolean isEnable() {
		return enable;
	}

	/**
	 * @param enable
	 *            the enable to set
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	/**
	 * @return the type
	 */
	@Column(name = "TYPE_COMPTE", nullable = false)
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the intialValue
	 */
	@Column(name = "SOLDE_INITIAL", nullable = false)
	public Double getIntialValue() {
		return intialValue;
	}

	/**
	 * @param intialValue
	 *            the intialValue to set
	 */
	public void setIntialValue(Double intialValue) {
		this.intialValue = intialValue;
	}

	/**
	 * @return the Operations
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	@OrderBy("date")
	public List<Operation> getOperations() {
		return operations;
	}

	/**
	 * @param operations
	 *            the Operation to set
	 */
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	public String toString() {
		return "id: " + this.getId() + ", label: " + this.getLabel() + ", initialValue: " + this.getIntialValue();
	}
}
