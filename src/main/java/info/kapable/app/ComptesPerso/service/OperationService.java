package info.kapable.app.ComptesPerso.service;

import java.util.List;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.Operation;

/**
 * Service to access on transaction ressources
 * @author matgou
 */
public abstract class OperationService implements BasicService<Operation> {
	public abstract List<Operation> getOperationsForAccount(Account a);
}
