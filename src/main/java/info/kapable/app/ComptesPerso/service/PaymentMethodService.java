 package info.kapable.app.ComptesPerso.service;

import info.kapable.app.ComptesPerso.pojo.PaymentMethod;

public abstract class PaymentMethodService implements BasicService<PaymentMethod> {

	public abstract int getNbPaymentMethod();
}
