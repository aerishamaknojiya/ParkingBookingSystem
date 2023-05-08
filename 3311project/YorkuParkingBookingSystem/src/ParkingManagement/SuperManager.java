package ParkingManagement;

import java.util.ArrayList;
import java.util.List;


public class SuperManager {
	private static SuperManager instance = null;

    private static String name;
    private static String password;
    private List<ManagementAccount> managementAccounts;



    private SuperManager(String name, String password) {
    	System.out.println("supermanager constructor");
        SuperManager.name = name;
        SuperManager.password = password;
        managementAccounts = new ArrayList<ManagementAccount>();
    }
    public static SuperManager getInstance() {
		if (instance == null) {
			instance = new SuperManager("supermanager@gmail.com" , "Super@12345");
			System.out.println("supermanager instance created!");
		}else {
			System.out.println("I am here   ");
		}
		return instance;
	}

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }


    public void generateManagementAccount(String name, String password) {
    	System.out.println("Super manager is generating accounts");
        // create an instance of the ManagementAccountFactory
        ManagementAccountFactory accountFactory = ManagementAccountFactory.getInstance();

        // create an instance of the ManagementAccount with the ManagementAccountFactory
        System.out.println("activating auto account generator");
        ManagementAccount newAccount = accountFactory.createManagementAccount(name, password);
        // generate a new management account with the given name and password

        // add the new account to the list of management accounts
        managementAccounts.add(newAccount);
        System.out.println(managementAccounts.get(0).getPassword());
        
    }

    // other methods and variables of the SuperManager class
}