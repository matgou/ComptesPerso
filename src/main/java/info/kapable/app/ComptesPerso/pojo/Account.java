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
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "COMPTE")
@JsonIgnoreProperties(ignoreUnknown = false)
/**
 * Un foyer est un ensemble de comptes associ� a des utilisateur
 * 
 * @author matgou
 *
 */
public class Account extends Pojo {

	/* STATIC PARAM */
	public static final Integer TYPE_COMPTE_COURANT = 1;

	/* Private properties */
	private Long id;
	private String label;
	private boolean enable = true;
	private Integer type;
	private Double intialValue;

	/* Link to object */
	private List<Transaction> transactions;

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
	 * @return the transactions
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	@OrderBy("date")
	public List<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * @param transactions
	 *            the transactions to set
	 */
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	/**
	 * Return current balance of account with all transaction
	 * @return
	 */
	@Transient
	public double getRealBalance() {
		Double realBalance = this.intialValue;
		for (Transaction t : this.getTransactions()) {
			if (t.getCredit() != null) {
				realBalance = realBalance + t.getCredit();
			}
			if (t.getDebit() != null) {
				realBalance = realBalance - t.getDebit();
			}

		}
		return realBalance;
	}

	/**
	 * Return current balance of account with only pointed transaction
	 * @return
	 */
	@Transient
	public double getPointedBalance() {
		Double pointedBalance = this.intialValue;
		for (Transaction t : this.getTransactions()) {
			if (t.getPointedTransaction()) {
				if (t.getCredit() != null) {
					pointedBalance = pointedBalance + t.getCredit();
				}
				if (t.getDebit() != null) {
					pointedBalance = pointedBalance - t.getDebit();
				}
			}

		}
		return pointedBalance;
	}

}
