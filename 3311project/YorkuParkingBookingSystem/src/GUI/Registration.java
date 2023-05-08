package GUI;



import javax.swing.*;

import Client.User;
import Client.UserFactory;
import Database.Database;
import Util.Utilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;  


public class Registration extends JFrame implements ActionListener
{  
	JLabel emailLabel, userTypeLabel, passwordLabel;
	JTextField emailTextField, passwordField;
	JButton registerButton;
	JComboBox userType;
	JLabel message;
	private UserFactory userFactory;
	Database database = new Database();
	Utilities checkCredentials = new Utilities();

	//constructor  
	public Registration()  
	{  		userTypeLabel = new JLabel("User type:");
	emailLabel = new JLabel("Email:");
	passwordLabel = new JLabel("Password:");
	String[] users = {"Student", "Faculty Member", "Non-Faculty staff","Visitor"};
	userType = new JComboBox(users);
	emailTextField = new JTextField();
	emailTextField.setColumns(15);
	passwordField = new JPasswordField();
	passwordField.setColumns(15);
	registerButton = new JButton("Register");
    message = new JLabel("");
    message.setVisible(false);
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5,5,5,5);
    gbc.anchor = GridBagConstraints.WEST;
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
	add(registerButton,gbc);
	gbc.gridx = 0;
    gbc.gridy = 4;
	add(message,gbc);
	setTitle("YorkU Parking Booking System - Registration");
	setSize(700, 400);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setVisible(true);

	// Add action listeners to buttons
	userType.addActionListener(this);
	registerButton.addActionListener(this);

	// backend components initialization
	userFactory = new UserFactory();
	}

	@Override
	public void actionPerformed(ActionEvent e ) {
		if(e.getSource()== userType) {
			if(userType.getSelectedItem().equals("Faculty Member")) {
				System.out.println(userType.getSelectedItem().toString());
			}else if(userType.getSelectedItem().equals("Student")) {

			}else if(userType.getSelectedItem().equals("Non-Faculty staff")) {

			}else if(userType.getSelectedItem().equals("Visitor")) {

			}

		}
		if(e.getSource() == registerButton) {

			String type =userType.getSelectedItem().toString();
			String email =emailTextField.getText().toString();
			String password =passwordField.getText().toString();
			
			if(e.getSource() == registerButton) {
				if(this.checkCredentials.isValidEmail(email) && this.checkCredentials.isValidPassword(password)) {
					//User newUser  = userFactory.createUser(type,email,password);
						this.message.setVisible(false);
						LoginScreen login = new LoginScreen();
						this.database.csvRegistrationWriter(type,email,password);
					}else {
						String message = (!this.checkCredentials.isValidPassword(password)) ? "The password must contain Uppercase, Lowercase letters, numbers and symbols."
								         : "The email address must contain @ and .";
						this.message.setText(message);
						this.message.setVisible(true);
					}
			}

		}

	}  
} 

