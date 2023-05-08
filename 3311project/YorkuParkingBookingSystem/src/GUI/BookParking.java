package GUI;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;  

public class BookParking extends JFrame implements ActionListener {
	private JComboBox selectParkingLot;
	private JComboBox selectLocation;
	private JButton YLaction;
	private JButton TMaction;
	private JButton WSCaction;
	private JLabel location;
	private ParkingLotGUI YLParkingLot;
	private ParkingLotGUI TMParkingLot;
	private ParkingLotGUI WSCParkingLot;

	public BookParking() {
		String[] lot = {"YL", "TM","WSC"};
		selectParkingLot = new JComboBox(lot);
		YLaction = new JButton("Book");
		TMaction = new JButton("Book");
		WSCaction = new JButton("Book");
		this.setActionVisibility(false);
		location = new JLabel("");
		add(selectParkingLot);
		add(location);
		add(YLaction);
		add(TMaction);
		add(WSCaction);
		setTitle("YorkU Parking Booking System - Booking");
		setSize(700, 400);
		setLayout(new GridLayout(3, 2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		selectParkingLot.addActionListener(this);
		YLaction.addActionListener(this);
		TMaction.addActionListener(this);
		WSCaction.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == selectParkingLot) {
		
			if(selectParkingLot.getSelectedItem().equals("YL")) {
				location.setText("Location: York Lanes");
				this.setActionVisibility(false);
				YLaction.setVisible(true);
			}else if(selectParkingLot.getSelectedItem().equals("TM")) {
				location.setText("Location: Tait Mckenzie");
				this.setActionVisibility(false);
				TMaction.setVisible(true);
			}else if(selectParkingLot.getSelectedItem().equals("WSC")) {
				location.setText("Location: William Small Centre");
				this.setActionVisibility(false);
				WSCaction.setVisible(true);
			}
		}
		if(e.getSource() == YLaction) {
			this.YLParkingLot = new ParkingLotGUI("York Lanes Parking YL");
		}else if(e.getSource() == TMaction) {
			this.TMParkingLot = new ParkingLotGUI("Tait Mackenzie Parking TM");
		}else if(e.getSource() == WSCaction) {
			this.WSCParkingLot = new ParkingLotGUI("William Small Center Parking WSC");
		}
		
	}
	
	public void setActionVisibility(boolean flag) {
		YLaction.setVisible(flag);
		TMaction.setVisible(flag);
		WSCaction.setVisible(flag);
	}
}
