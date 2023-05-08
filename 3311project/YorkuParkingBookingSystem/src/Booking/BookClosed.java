package Booking;

public class BookClosed implements BookingState {

	public void status(Status s) {
		System.out.println("This parking space is booked");

	}
}