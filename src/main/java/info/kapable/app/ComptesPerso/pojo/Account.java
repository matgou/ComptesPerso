package info.kapable.app.ComptesPerso.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "COMPTE")
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false) 
/**
 * Un foyer est un ensemble de comptes associé a des utilisateur
 * 
 * @author matgou
 *
 */
public class Account {
	private Long id;
	private String label;
	private boolean enable;
	private Integer type;
	private Double intialValue;
	

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

	@Column(name = "LIBELLE")
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the enable
	 */
	@Column(name = "COMPTE_ACTIF")
	public boolean isEnable() {
		return enable;
	}

	/**
	 * @param enable the enable to set
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	/**
	 * @return the type
	 */
	@Column(name = "TYPE_COMPTE")
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the intialValue
	 */
	@Column(name = "SOLDE_INITIAL")
	public Double getIntialValue() {
		return intialValue;
	}

	/**
	 * @param intialValue the intialValue to set
	 */
	public void setIntialValue(Double intialValue) {
		this.intialValue = intialValue;
	}


}
