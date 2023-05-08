package GUI;

import javax.swing.*;

import Database.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateLoginForm extends JFrame implements ActionListener  
{  
	
	public static void main(String[] args) {
		try  
		{  
			//create instance of the CreateLoginForm  
			LoginScreen form = new LoginScreen(); 
		}  
		catch(Exception e)  
		{     
			//handle exception   
			JOptionPane.showMessageDialog(null, e.getMessage());  
		}  

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}





