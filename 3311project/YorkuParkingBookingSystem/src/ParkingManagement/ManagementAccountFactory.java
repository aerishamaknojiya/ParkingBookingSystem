package ParkingManagement;

import java.util.ArrayList;
import java.util.List;

public class ManagementAccountFactory {

	private List<ManagementAccount> accounts  = new ArrayList<ManagementAccount>();
	private ManagementAccount currAcc;

	// Singleton instance
	private static ManagementAccountFactory instance;

	// Private constructor to prevent external instantiation
	public ManagementAccountFactory() {
		
	}
	
	public List<ManagementAccount> getAccounts() {
		return this.accounts;
	}
	
	public void setAccounts(List<ManagementAccount> acc) {
		this.accounts = acc;
	}

	// Get the singleton instance
	public static ManagementAccountFactory getInstance() {
		if (instance == null) {
			instance = new ManagementAccountFactory();
			System.out.println("Management account factory instance created");
		}else {
			System.out.println("alrady exists");
		}
		return instance;
	}

	// Create a new management account with the given name and password
	public ManagementAccount createManagementAccount(String name, String password) {
		
		return new ManagementAccount(name, password);
		

	}
	
	public boolean getTeamMember(String email, String password) {
		for(int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getEmail().toString().equals(email) &&
					accounts.get(i).getPassword().toString().equals(password)){
				return true;
			}
		}
		return false;
		
	}
	
}
