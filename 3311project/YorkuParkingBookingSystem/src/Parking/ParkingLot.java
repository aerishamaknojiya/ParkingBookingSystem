package Parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	   private String id;
	   private List<ParkingSpace> parkingSpaces;

	   // Constructor to set the ID of the parking lot
	   public ParkingLot(String id) {
	      this.id = id;
	      this.parkingSpaces = new ArrayList<ParkingSpace>();
	   }
	   
	   public List<ParkingSpace> getParkingSpaces(){
		   return parkingSpaces;
	   }
	   public String getId(){
		   return this.id;
	   }
	   public void parkingSpaceInit()
	   {
		  String location="";
		      if(this.id.equals("YL")) {
		    	 location = "York Lanes";
		      }else if(this.id.equals("WSC")) {
		    	  location = "Willaim Small Centre";
		      }else if(this.id.equals("TM")) {
		    	  location = "Tait Mckenzie";
		      }
		      for(int i = 1; i <= 100; i++) {
		    	  ParkingSpace ps = new ParkingSpace(i,location, this);
		    	  this.parkingSpaces.add(ps);
		      }
	   }
	}
