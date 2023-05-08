package Booking;

public class Status {
private BookingState curState;
	
	public Status() {
		curState = new BookOpen();
	}
	
	public void setState(BookingState state) {
		curState = state;
	}
	
	public void state() {
		curState.status(this);
	} 
	
	public BookingState getState() {
		return this.curState;
	} 
}
