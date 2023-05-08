package Database;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Client.User;
import Client.UserFactory;
import ParkingManagement.ManagementAccount;
import ParkingManagement.ManagementAccountFactory;

public class Database {
	
	private String filePath = "C:\\Users\\aeris\\OneDrive\\Desktop\\3311project\\YorkuParkingBookingSystem\\src\\Database\\database.csv";

	
	
	
	public void csvRegistrationWriter(String type, String email, String password) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath,true);

			fileWriter.append(type);
			fileWriter.append(",");
			fileWriter.append(email);
			fileWriter.append(",");
			fileWriter.append(password);
			fileWriter.append("\n");
		}catch(Exception e) {
			
		}finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			}catch(Exception e) {
				
			}
		}
	}
	
	public void csvparkingLotWriter(String type, String email, String password) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath,true);

			fileWriter.append(type);
			fileWriter.append(",");
			fileWriter.append(email);
			fileWriter.append(",");
			fileWriter.append(password);
			fileWriter.append("\n");
		}catch(Exception e) {
			
		}finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			}catch(Exception e) {
				
			}
		}
	}
	
	public void csvManagementWriter(String email, String password) {
		FileWriter fileWriter = null;
		this.filePath = "C:\\Users\\aeris\\OneDrive\\Desktop\\3311project\\YorkuParkingBookingSystem\\src\\Database\\managementdatabase.csv";
		try {
			fileWriter = new FileWriter(filePath,true);

			fileWriter.append(email);
			fileWriter.append(",");
			fileWriter.append(password);
			fileWriter.append("\n");
		}catch(Exception e) {
			
		}finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			}catch(Exception e) {
				
			}
		}
	}
	
	public List<ManagementAccount> csvManagementReader(ManagementAccountFactory managementFactory, List<ManagementAccount> managementAccounts) {
		BufferedReader reader = null;
		this.filePath = "C:\\Users\\aeris\\OneDrive\\Desktop\\3311project\\YorkuParkingBookingSystem\\src\\Database\\managementdatabase.csv";
		
		try {
			managementAccounts = new ArrayList<ManagementAccount>();
			String line = "";
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();
			
			while((line = reader.readLine()) != null) {
				String[] fields = line.split(",");
				
				if(fields.length > 0) {
					ManagementAccount managementAccount = managementFactory.createManagementAccount( fields[0], fields[1]);
					managementAccounts.add(managementAccount);
				}		
			}
		}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					reader.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		return managementAccounts;
	}
	
	
	public List<User> csvReader(UserFactory userFactory, List<User> users) {
		BufferedReader reader = null;
		
		try {
			users = new ArrayList<User>();
			String line = "";
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();
			
			while((line = reader.readLine()) != null) {
				String[] fields = line.split(",");
				
				if(fields.length > 0) {
					User user = userFactory.createUser(fields[0], fields[1], fields[2]);
					users.add(user);
				}
						
			}
		}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					reader.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		return users;
	}
	

}
