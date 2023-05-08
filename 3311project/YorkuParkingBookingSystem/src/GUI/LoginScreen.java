package GUI;

//Java code for login screen

import javax.swing.*;


import Client.User;
import Client.UserFactory;
import Database.Database;
import ParkingManagement.ManagementAccountFactory;
import ParkingManagement.SuperManager;
import ParkingManagement.ManagementAccount;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JFrame implements ActionListener {
	JLabel emailLabel, passwordLabel;
	JTextField emailTextField;
	JPasswordField passwordField;
	JButton loginButton, registerButton;
	JLabel message;
	JComboBox userType;
	Database database = new Database();
	private UserFactory userFactory;
	private ManagementAccountFactory managementFactory;

	public LoginScreen() {
		// Initialize components
		emailLabel = new JLabel("Email:");
		passwordLabel = new JLabel("Password:");
		emailTextField = new JTextField();
		emailTextField.setColumns(15);
		passwordField = new JPasswordField();
		passwordField.setColumns(15);
		loginButton = new JButton("Login");
		registerButton = new JButton("Register");
		String[] users = {"User","Management Team", "Super Manager"};
		userType = new JComboBox(users);
		message = new JLabel("");
		message.setVisible(false);
		setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(5,5,5,5);
	    gbc.anchor = GridBagConstraints.WEST;
		// Add components to frame
	    gbc.gridx = 0;
	    gbc.gridy = 0;
		add(emailLabel,gbc);
		gbc.gridx = 1;
	    gbc.gridy = 0;
		add(emailTextField,gbc);
		gbc.gridx = 0;
	    gbc.gridy = 1;
		add(passwordLabel,gbc);
		gbc.gridx = 1;
	    gbc.gridy = 1;
		add(passwordField,gbc);
		gbc.gridx = 1;
	    gbc.gridy = 2;
		add(userType,gbc);
		gbc.gridx = 1;
	    gbc.gridy = 3;
		add(loginButton,gbc);
		gbc.gridx = 1;
	    gbc.gridy = 4;
		add(registerButton,gbc);
		gbc.gridx = 0;
	    gbc.gridy = 5;
		add(message,gbc);
		// Set frame properties
		setTitle("YorkU Parking Booking System - Login");
		setSize(700, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		// Add action listeners to buttons
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);
		 userFactory = new UserFactory();	
		 managementFactory = new ManagementAccountFactory();

	}

	// Action listener for buttons
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton && userType.getSelectedItem().equals("User")) {
			String email = emailTextField.getText().toString();
			String password = new String(passwordField.getPassword());
		
			userFactory.setAccounts(this.database.csvReader(userFactory, userFactory.getAccounts()));
			if(userFactory.getUser(this.emailTextField.getText(),new String(this.passwordField.getPassword()))) {
				MainMenuScreen mainMenu = new MainMenuScreen();
				this.message.setVisible(false);
			}else {
				this.message.setText("Incorrect Credentials! In case you are new user please register.");
				this.message.setVisible(true);
			}
			
		
			
			
		}else if(e.getSource() == loginButton && userType.getSelectedItem().equals("Management Team")) {
			String email = emailTextField.getText().toString();
			String password = new String(passwordField.getPassword());
			managementFactory.setAccounts(this.database.csvManagementReader(managementFactory, managementFactory.getAccounts()));
			if(managementFactory.getTeamMember(this.emailTextField.getText(),new String(this.passwordField.getPassword()))) {
				ManagementWindow mw = new ManagementWindow();
				this.message.setVisible(false);
			}else {
				this.message.setText("Incorrect Credentials! please contact Super Manager.");
				this.message.setVisible(true);
			}
			
		}else if(e.getSource() == loginButton && userType.getSelectedItem().equals("Super Manager")) {
			String email = emailTextField.getText().toString();
			String password = new String(passwordField.getPassword());
			SuperManager superManager = SuperManager.getInstance();
	
			if(superManager.getName().equals(email) && superManager.getPassword().equals(password)) {
				SuperManagerWindow smw = new SuperManagerWindow();
				this.message.setVisible(false);
			}else {
				this.message.setText("Incorrect Credentials for Super Manager!");
				this.message.setVisible(true);
			}
			
		}
		
		else if (e.getSource() == registerButton) {

			Registration registr = new Registration();
		}
	}
}
