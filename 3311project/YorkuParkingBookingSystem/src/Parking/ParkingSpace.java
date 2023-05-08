package Parking;

import Booking.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;




public class ParkingSpace {
	   private int id;
	   private String location;
	   private ParkingLot parkingLot;
	   private Date startDate, endDate;
	   
	   private Status booking;
	   Timer timer;
	   
	   TimerTask task;

	   // Constructor to set the ID, location, and parking lot of the parking space
	   public ParkingSpace(int id, String location, ParkingLot parkingLot) {
	      this.id = id;
	      this.location = location;
	      this.parkingLot = parkingLot;
	      this.booking = new Status();
	      this.timer = new Timer();
	      this.task = new Update(this);
	   }
	   
	   public void Status() {
		  booking.state();
	   }
	   public Status getStatus() {
		   return this.booking;
	   }
	   public TimerTask getTask() {
		   return this.task;
	   }
	   
	   public Date getBookingTime() {
		   return this.startDate;
	   }
	   
	   public Date getBookingEnd() {
		   return this.endDate;
	   }
	   
	   public void setBookingTime(Date newDate) {
		   this.startDate = newDate;
	   }
	   
	   public void setBookingEnd( Date newDate) {
		   this.endDate = newDate;
		   TimerTask newTask = new Update(this);
		   timer.schedule(newTask, newDate); //update lot status at tend time
	   }
	   
	   public void setClosed() {
			  booking.setState(new BookClosed());
	   }
	   
	   public void setOpen() {
			  booking.setState(new BookOpen());
	   }

	   // Other methods to manage the status and details of the parking space
	}
