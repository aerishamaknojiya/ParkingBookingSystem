package Booking;

import Client.User;
import Parking.*;
import java.util.Calendar;
import java.util.Date;

import Booking.BookOpen;

public class BookingSystem {
	
	// REQ4 Allow user to book a parking space, Charge them for 1 hour, remember to deduct this amount at checkout
	// TODO don't refund for no show
	public void bookSpace(User user, ParkingSpace space, String license, int month, int day, int hour, int time) {
		if(license != "") {//TODO check for valid license
			Parking.ParkingSpace check = new ParkingSpace(1, license, null);
			if(space.getStatus().getState().getClass() == check.getStatus().getState().getClass()) {// check for open parking space
				Calendar calendar = Calendar.getInstance(); // used for scheduling a booking date
				if(user.pay(user.getHourlyRate()) == 1) {// user pays deposit
					
				}
				else {
					calendar.set(2023,month,day,hour,0);		// set start time of booking
					Date date = calendar.getTime();
					space.setBookingTime(date);
					
					user.setBalance(time);						// amount to be paid set to user balance
					
					
					calendar.set(2023,month,day,hour+time,0);	// set end time
					date = calendar.getTime();
					space.setBookingEnd(date);
					
					user.setParking(space);						// set user's parking space for future modification
					user.getParking().setClosed();
				}
				
				
				
				
			}
			else {
				System.out.println("Parking space is unavailable.");
			}
			
		}
		else {
			System.out.println("Invalid license plate.");
		}
	}
	
	
	//extend booking time
	public void extendBooking(User user, int time) throws InterruptedException {
		if(user.getParking() != null) { // check if user has an active booking
			Calendar calendar = Calendar.getInstance();// get current time
			if(calendar.after(user.getParking().getBookingEnd())) {	
				System.out.println("Booking has already expired!");	// if current time is after booking it cannot be extended
			}
			else {
				calendar.setTime(user.getParking().getBookingEnd()); 
				calendar.add(Calendar.HOUR_OF_DAY, time);					// add extra hours to end time
				user.setBalance(user.getBalance()+user.getHourlyRate()*time);// charge for extra hours
				Date modifiedDate = calendar.getTime();			
				
				user.getParking().getTask().cancel(); // cancel system status update
				
				user.getParking().setBookingEnd(modifiedDate);				// update new end date
				Thread.sleep(100);
				user.getParking().setClosed();
			}
			
		}
		else {
			System.out.println("User does not have an active booking");
		}
	}

	public void cancelBooking(User user) {
		if(user.getParking() != null) { // check if user has an active booking
			Calendar calendar = Calendar.getInstance();// get current time
			if(calendar.after(user.getParking().getBookingTime())) {	
				System.out.println("Booking has already started!");	// if current time is during booking it cannot be cancelled
			}
			else {
				user.getParking().getTask().cancel();
				user.getParking().setOpen();
				user.setParking(null);
				
			}
			
		}
		else {
			System.out.println("User does not have an active booking");
		}
	}
	// Other methods to manage the parking spaces, bookings, clients, and payments
}

