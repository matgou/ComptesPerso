package info.kapable.app.ComptesPerso.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@Entity
@Table(name = "OPERATION")
@JsonIgnoreProperties(ignoreUnknown = false)
/**
 * Transaction entity, a financial operation on a account
 * 
 * @author Mathieu GOULIN <mathieu.goulin@gadz.org>
 */
public class Operation extends Pojo {

	/* Private properties */
	private Long id;
	private Double credit = 0.;
	private Double debit = 0.;
	private Date date; 
	@Size(min=2, max=255, message = "{errors.label.size}") 
	private String description = "";
	private Boolean pointedTransaction = false;
	
	/* Link */
	private Account account;
	
	/* Optional */
	private String transfertNumber;
	private String chequeNumber;
	private String slipNumber;
	

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
	 * @return the credit
	 */
	@Column(name = "CREDIT", nullable = false)
	public Double getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(Double credit) {
		this.credit = credit;
	}

	/**
	 * @return the debit
	 */
	@Column(name = "DEBIT", nullable = false)
	public Double getDebit() {
		return debit;
	}

	/**
	 * @param debit the debit to set
	 */
	public void setDebit(Double debit) {
		this.debit = debit;
	}

	/**
	 * @return the date
	 */
	@Column(name = "DATE_OPERATION", nullable = false)
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the description
	 */
	@Column(name = "DESCRIPTION", nullable = false)
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the pointedTransaction
	 */
	@Column(name = "OPERATION_POINTEE", nullable = false)
	public Boolean getPointedTransaction() {
		return pointedTransaction;
	}

	/**
	 * @param pointedTransaction the pointedTransaction to set
	 */
	public void setPointedTransaction(Boolean pointedTransaction) {
		this.pointedTransaction = pointedTransaction;
	}

	/**
	 * @return the transfertNumber
	 */
	@Column(name = "NUMERO_VIREMENT", nullable = true)
	public String getTransfertNumber() {
		return transfertNumber;
	}

	/**
	 * @param transfertNumber the transfertNumber to set
	 */
	public void setTransfertNumber(String transfertNumber) {
		this.transfertNumber = transfertNumber;
	}

	/**
	 * @return the chequeNumber
	 */
	@Column(name = "NUMERO_CHEQUE", nullable = true)
	public String getChequeNumber() {
		return chequeNumber;
	}

	/**
	 * @param chequeNumber the chequeNumber to set
	 */
	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	/**
	 * @return the slipNumber
	 */
	@Column(name = "NUMERO_BORDEREAU", nullable = true)
	public String getSlipNumber() {
		return slipNumber;
	}

	/**
	 * @param slipNumber the slipNumber to set
	 */
	public void setSlipNumber(String slipNumber) {
		this.slipNumber = slipNumber;
	}

	/**
	 * @return the account
	 */
	@ManyToOne
    @JoinColumn(name="COMPTE_ID", nullable = false)
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
}
