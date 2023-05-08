package Parking;

import java.util.TimerTask;

public class Update extends TimerTask {
	private ParkingSpace space;
	
	public Update(ParkingSpace space) {
		this.space = space;
	}
	
	@Override
	public void run() {
		space.setOpen();
		
	}

}
