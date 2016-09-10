package info.kapable.app.ComptesPerso.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * PaymentMethod object 
 * 
 * @author Johanna GOULIN <ptitedjo@gmail.com>
 */
@Entity
@Table(name = "MOYEN_PAIEMENT")
@JsonIgnoreProperties({"paymentMethods"})
public class PaymentMethod extends Pojo {
	/* Private properties */
	private Long id;

	@Size(min=2, max=255, message = "{errors.label.size}") 
	private String label;
	
	
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
