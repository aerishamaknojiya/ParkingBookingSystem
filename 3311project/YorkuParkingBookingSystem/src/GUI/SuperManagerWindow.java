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


public class SuperManagerWindow extends JFrame implements ActionListener
{  
	JLabel Label;
	JComboBox numbers;
	JButton generateButton,logoutButton;
	JLabel message;
	Database database = new Database();

	//constructor  
	public SuperManagerWindow()  
	{  		
	Label = new JLabel("Number of Accounts to generate :");
	String[] users = {"1","2","3","4","5"};
	numbers = new JComboBox(users);
	generateButton = new JButton("Generate");
	logoutButton = new JButton("Log Out");
    message = new JLabel("");
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5,5,5,5);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 0;
    gbc.gridy = 0;
	add(Label,gbc);
	gbc.gridx = 0;
    gbc.gridy = 1;
	add(numbers,gbc);
	gbc.gridx = 0;
    gbc.gridy = 2;
	add(generateButton,gbc);
	gbc.gridx = 0;
    gbc.gridy = 3;
	add(logoutButton,gbc);
	gbc.gridx = 0;
    gbc.gridy = 4;
	add(message,gbc);
	setTitle("Auto Account Generation SubSystem");
	setSize(700, 400);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setVisible(true);

	// Add action listeners to buttons
	generateButton.addActionListener(this);
	logoutButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e ) {
		
		if(e.getSource() == generateButton) {
			String mes = "";
			int number = Integer.parseInt(numbers.getSelectedItem().toString());
			for(int i = 0; i < number; i++) {
		        String uuid = UUID.randomUUID().toString();
		        uuid = uuid.substring(0,6);
		        String managementEmail = uuid + "@gmail.com";
		        uuid = UUID.randomUUID().toString();
		        String managementPassword = uuid.substring(0,8);
		        this.database.csvManagementWriter(managementEmail,managementPassword);
		        mes += managementEmail + " - " + managementPassword + " ";
			}
			
			message.setText(mes);
		}else if(e.getSource() == logoutButton) {
			LoginScreen LS = new LoginScreen();
		}

	}  
} 

