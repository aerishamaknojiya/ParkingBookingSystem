package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParkingLotGUI extends JFrame implements ActionListener {

    private JButton[] parkingSpaces;
    private JLabel label;
    private JTextField addTime;
    private JButton SubmitButton;
    private JLabel message;
    public boolean isselected = false;

    public ParkingLotGUI(String location) {
        // Create a 10x10 grid of parking spaces
        JPanel parkingLot = new JPanel(new GridLayout(14, 10));
        parkingSpaces = new JButton[100];

        // Initialize the parking spaces
        
        for (int i = 0; i < parkingSpaces.length; i++) {
            parkingSpaces[i] = new JButton(Integer.toString(i+1));
            parkingSpaces[i].setBackground(Color.GREEN); // Green for vacant, red for occupied
            parkingLot.add(parkingSpaces[i]);
            parkingSpaces[i].addActionListener(this);
        }

        // Add the parking lot to the JFrame
        getContentPane().add(parkingLot);
    
        
      
      
        // Set JFrame properties
        setTitle(location);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton) e.getSource();
		if(!isselected) {
		if(buttonClicked.getText() != "Submit") {
		 buttonClicked.setBackground(Color.RED);
		 isselected = true;
		}
		}
		
	
	}
}
