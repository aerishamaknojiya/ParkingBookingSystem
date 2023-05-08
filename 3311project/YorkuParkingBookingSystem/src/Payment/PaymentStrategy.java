package Payment;

public abstract class PaymentStrategy {
	
	public abstract void pay(int balance);
	
	public abstract void addFunds(int amount);

}
