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


public class EnableDisablePKSpace extends JFrame implements ActionListener
{  

	JComboBox endis;
	JButton ExecuteButton;
	JLabel plLabel;
	JTextField plID;
	JLabel psLabel;
	JTextField psID;
	Database database = new Database();

	//constructor  
	public EnableDisablePKSpace()  
	{  		
	String[] end = {"enable","disable"};
	endis = new JComboBox(end);
	plLabel = new JLabel("parking Lot ID");
	plID = new JTextField();
	plID.setColumns(15);
	psLabel = new JLabel("parking Space ID");
	psID = new JTextField();
	psID.setColumns(15);
	ExecuteButton = new JButton("Execute");
	setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5,5,5,5);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 0;
    gbc.gridy = 0;
	add(endis,gbc);
	gbc.gridx = 0;
    gbc.gridy = 1;
	add(plLabel,gbc);
	gbc.gridx = 1;
    gbc.gridy = 1;
	add(plID,gbc);
	gbc.gridx = 0;
    gbc.gridy = 2;
	add(psLabel,gbc);
	gbc.gridx = 1;
    gbc.gridy = 2;
	add(psID,gbc);
	gbc.gridx = 0;
    gbc.gridy = 3;
	add(ExecuteButton,gbc);
	setTitle("Enable / Disable Parking Space");
	setSize(700, 400);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setVisible(true);

	// Add action listeners to buttons
	ExecuteButton.addActionListener(this);


	}

	@Override
	public void actionPerformed(ActionEvent e ) {
		
		if(e.getSource() == ExecuteButton) {
		
			
		}

	}  
} 

