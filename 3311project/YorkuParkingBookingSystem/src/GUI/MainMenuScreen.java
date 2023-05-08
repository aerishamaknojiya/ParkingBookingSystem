package GUI;

//Java code for main menu screen

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuScreen extends JFrame implements ActionListener {
 JLabel parkingStatusLabel;
 JButton bookButton, cancelButton, extendButton, payButton;

 public MainMenuScreen() {
     // Initialize components
     parkingStatusLabel = new JLabel("You currently have no active parking session.");
     bookButton = new JButton("Book a Parking Space");
     cancelButton = new JButton("Cancel Parking Session");
     extendButton = new JButton("Extend Parking Session");
     payButton = new JButton("Pay Parking Fee");

     // Add components to frame
     add(parkingStatusLabel);
     add(bookButton);
     add(cancelButton);
     add(extendButton);
     add(payButton);

     // Set frame properties
     setTitle("YorkU Parking Booking System - Main Menu");
     setSize(700, 400);
     setLayout(new GridLayout(3, 2));
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLocationRelativeTo(null);
     setVisible(true);

     // Add action listeners to buttons
     bookButton.addActionListener(this);
     cancelButton.addActionListener(this);
     extendButton.addActionListener(this);
     payButton.addActionListener(this);
 }

 // Action listener for buttons
 public void actionPerformed(ActionEvent e) {
     if (e.getSource() == bookButton) {
         BookParking booking = new BookParking();
     } else if (e.getSource() == cancelButton) {
         // Handle cancel button press
     } else if (e.getSource() == extendButton) {
         // Handle extend button press
     } else if (e.getSource() == payButton) {
         // Handle pay button press
     }
 }
}
