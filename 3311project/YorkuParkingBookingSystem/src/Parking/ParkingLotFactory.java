package Parking;

import java.util.ArrayList;
import java.util.List;

import Client.FacultyMember;
import Client.NonFacultyStaff;
import Client.Student;
import Client.User;
import Client.Visitor;

public class ParkingLotFactory {
	private List<ParkingLot> availableLot  = new ArrayList<ParkingLot>();
	private List<ParkingLot> disableLot  = new ArrayList<ParkingLot>();

	private ParkingLot currLot;

	public ParkingLot createLot(String id) {
		if(!id.equals("")) {
			currLot = new ParkingLot(id);
			currLot.parkingSpaceInit();
			availableLot.add(currLot);
			return currLot;

		} else {
			return null;
		}

	}
	public ParkingLot getLot(int index) {
		return  availableLot.get(index);
		
	}
	public ParkingLot getLot(String id) {
		System.out.println(availableLot.size());
		for(int i = 0; i < availableLot.size(); i++) {
			if(availableLot.get(i).getId().toString().equals(id)){
				return availableLot.get(i);
			}
		}
		return null;
	}
	
	public void enableLot(String id) {
		System.out.println(availableLot.size());
		for(int i = 0; i < disableLot.size(); i++) {
			if(disableLot.get(i).getId().toString().equals(id)){
				availableLot.add(disableLot.get(i));
				disableLot.remove(i);
			}
		}
	}
	public void disableLot(String id) {
		System.out.println(availableLot.size());
		for(int i = 0; i < availableLot.size(); i++) {
			if(availableLot.get(i).getId().toString().equals(id)){
				disableLot.add(availableLot.get(i));
				availableLot.remove(i);
			}
		}
	}
}