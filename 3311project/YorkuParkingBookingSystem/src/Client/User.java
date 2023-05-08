package Client;


import java.util.ArrayList;

import Parking.ParkingSpace;
import Payment.CreditCardPay;
import Payment.DebitCardPay;
import Payment.MobilePay;
import Payment.PaymentStrategy;
import Util.Utilities;


public abstract class User {
	private String email;
	private String password;
	// private Car car; - will need to create car object
	private boolean validated;
	private int hourlyRate;
	private int balance;
	private ArrayList<PaymentStrategy> paymentMethods;	
	private PaymentStrategy strat;
	private ParkingSpace bookedSpace;
	private Utilities util;



	public User(String email, String password) throws Exception {
		this.email = email;
		this.password = password;
		paymentMethods = new ArrayList<>();
		this.util = new Utilities();
		try {
		if(!util.isValidPassword(this.password)) {
			throw new Exception("Invalid Password!");

		}
		}catch(Exception e){
			System.out.println("The password must contain Uppercase, Lowercase letters, numbers and symbols.");
			System.exit(1);
		}

	}


	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public int getBalance() {
		return this.balance;
	}
	public int getHourlyRate() {
		return this.hourlyRate;
	}
	
	public ParkingSpace getParking() {
		return this.bookedSpace;
	}
	
	public ArrayList<PaymentStrategy> getMethods() {
		return this.paymentMethods;
	}

	public void setBalance(int time) {
		this.balance = (time * this.hourlyRate);		
	}
	
	public void setParking(ParkingSpace space) {
		this.bookedSpace = space;		
	}

	public void addCreditCard(String cardNumb, String cvv, String expiryDate, int funds) {
		CreditCardPay creditCard = new CreditCardPay(this, cardNumb, cvv, expiryDate, funds);
		System.out.println(paymentMethods);
		paymentMethods.add(creditCard);		
	}

	public void addDebitCard(String cardNumb,String expiryDate, int funds) {
		DebitCardPay debitCard = new DebitCardPay(this, cardNumb, expiryDate, funds);
		paymentMethods.add(debitCard);		
	}

	public void addMobilePay(String phoneNumb,  String yorkAccount, int funds) {
		MobilePay mobileAccount = new MobilePay(this, phoneNumb, yorkAccount, funds);
		paymentMethods.add(mobileAccount);		
	}
	
	public void setPaymentMethod(PaymentStrategy strat) {
		if(paymentMethods.contains(strat)) {
			this.strat = strat;
		}
		else {
			System.out.println("There is no such payment method.");
		}
	}

	public void addFunds(int amount) {
			strat.addFunds(amount);
	}
	
	public int pay(int amount) {
		if(!paymentMethods.isEmpty() && strat != null) {
			strat.pay(amount);
			this.balance -= amount;
			
			//TODO do not return deposit if no show 1 hour 
			
			if(this.getBalance() == 0) {
				this.addFunds(hourlyRate); // return deposit
			}
			return 0;
		}
		else {
			System.out.println("There is no payment method set");
			return 1;
		}
		
}

}