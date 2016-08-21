package info.kapable.app.ComptesPerso.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Category object 
 * 
 * @author Mathieu GOULIN <mathieu.goulin@gadz.org>
 */
@Entity
@Table(name = "TIERS")
@JsonIgnoreProperties()
public class ThirdParty extends Pojo {
	/* Private properties */
	private Long id;

	/**
	 * Getter and Setter
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
