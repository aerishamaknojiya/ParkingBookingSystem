package Payment;

import Client.User;

public class CreditCardPay extends PaymentStrategy{
	
	private User user;
	private String cardNumber;
	private String cvv;
	private String expiryDate;
	private int funds;
	
	
	public CreditCardPay(User user, String cardNumb, String cvv, String expiryDate, int funds){
		this.user = user;
		this.cardNumber = cardNumb;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
		this.funds = funds;
		
	}	

	public void pay(int amount) {
		// TODO Auto-generated method stub
		if (this.funds >= amount) {
			this.funds -= amount;
		}
		else {
			System.out.println("Insufficient funds - Please reload card or use another method.");
		}		
	}

	public void addFunds(int amount) {
		this.funds += amount;		
	}

	
	
}