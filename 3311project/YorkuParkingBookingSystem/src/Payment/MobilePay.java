package Payment;

import Client.User;

public class MobilePay extends PaymentStrategy{
	
	private User user;
	private String phoneNumber;
	private String yorkAccount;
	private int funds;
	
	public MobilePay(User user, String phoneNumber, String yorkAccount, int funds) {
		this.user = user;
		this.phoneNumber = phoneNumber;
		this.yorkAccount = yorkAccount;
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