package info.kapable.app.ComptesPerso.pojo;

public class AccountWithBalance extends Account {

	private Double realBalance;
	private Double pointedBalance;
	public AccountWithBalance(Account account, double realBalance, double pointedBalance) {
		this.setId(account.getId());
		this.setEnable(account.isEnable());
		this.setRealBalance(realBalance);
		this.setIntialValue(account.getIntialValue());
		this.setLabel(account.getLabel());
		this.setPointedBalance(pointedBalance);
		//this.setOperations(account.getOperations());
		this.setType(account.getType());
		
	}
	/**
	 * @return the currentBalance
	 */
	public Double getRealBalance() {
		return realBalance;
	}
	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setRealBalance(Double realBalance) {
		this.realBalance = realBalance;
	}
	/**
	 * @return the pointedBalance
	 */
	public Double getPointedBalance() {
		return pointedBalance;
	}
	/**
	 * @param pointedBalance the pointedBalance to set
	 */
	public void setPointedBalance(Double pointedBalance) {
		this.pointedBalance = pointedBalance;
	}

}
