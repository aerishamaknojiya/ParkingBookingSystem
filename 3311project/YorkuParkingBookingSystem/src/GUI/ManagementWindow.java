package GUI;



import javax.swing.*;

import Client.User;
import Client.UserFactory;
import Database.Database;
import Util.Utilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;  


public class ManagementWindow extends JFrame implements ActionListener
{  
	JTextField field;
	JButton EDparkingLotButton,EDparkingSpaceButton, addParkingSpaceButton;
	JLabel message;
	Database database = new Database();

	//constructor  
	public ManagementWindow()  
	{  		
	
	EDparkingLotButton = new JButton("Enable/Disable Parking Lot");
	EDparkingSpaceButton = new JButton("Enable/Disable Parking Space");
	addParkingSpaceButton = new JButton("Add Parking Lot");
	field = new JTextField();
	field.setColumns(15);
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5,5,5,5);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 0;
    gbc.gridy = 0;
	add(EDparkingLotButton,gbc);
	gbc.gridx = 0;
    gbc.gridy = 1;
	add(EDparkingSpaceButton,gbc);
	gbc.gridx = 0;
    gbc.gridy = 2;
	add(field,gbc);
	gbc.gridx = 1;
    gbc.gridy = 2;
	add(addParkingSpaceButton,gbc);
	setTitle("manage Parking system");
	setSize(700, 400);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setVisible(true);

	// Add action listeners to buttons
	EDparkingLotButton.addActionListener(this);
	EDparkingSpaceButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e ) {
		
		if(e.getSource() == EDparkingLotButton) {
			EnableDisablePKLot ELPKLOT = new EnableDisablePKLot(); 
			
			
		}else if(e.getSource() == EDparkingSpaceButton) {
			EnableDisablePKSpace ELPKSPC = new EnableDisablePKSpace(); 
		}

	}  
} 

