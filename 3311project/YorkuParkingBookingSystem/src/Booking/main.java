package Booking;

import Client.Student;
import Client.User;
import Parking.*;

public class main {

	public static void main(String[] args) throws Exception {
		BookingSystem bsys = new BookingSystem();
		ParkingSpace space = new ParkingSpace(123, "a1", null);
		
		User john = new Student("j@gmail.com","Apple123!");
		
		space.Status(); //initial lot status
		
		bsys.bookSpace(john, space, "A1B23G", 2, 25, 8, 2); // fail payment
		
		space.Status();	//check still open
		
		john.addCreditCard("123", "123", "123", 100);  // add but dont set payment method
		
		bsys.bookSpace(john, space, "A1B23G", 2, 25, 8, 2); // fail payment
		
		space.Status(); //check still open
		
		john.setPaymentMethod(john.getMethods().get(0)); //set payment method
		
		bsys.bookSpace(john, space, "A1B23G", 2, 25, 9, 2); //get space
		
		space.Status(); // check closed
		
		System.out.println("Booking end" + space.getBookingEnd()); // check booking end time
		
		bsys.extendBooking(john, 2); // extend booking time
		
		System.out.println("Booking end" + space.getBookingEnd()); // check booking end time
		
		space.Status(); // check closed
		
		bsys.cancelBooking(john); //cancel booking
		
		space.Status(); // check open
		
		
	}
}
