package info.kapable.app.ComptesPerso.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FOYER")
/**
 * Un foyer est un ensemble de comptes associé a des utilisateur
 * 
 * @author matgou
 *
 */
public class Foyer {
	private Long id;
	private String name;

	public Foyer(String name) {
		this.name = name;
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

	@Column(name = "NOM_FOYER")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
