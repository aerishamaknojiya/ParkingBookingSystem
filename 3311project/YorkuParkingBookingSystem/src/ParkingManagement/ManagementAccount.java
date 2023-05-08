package ParkingManagement;

public class ManagementAccount {
    private String email;
    private String password;


    public ManagementAccount(String email, String password) {
    	System.out.println("management account generated");
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    // Other methods related to managing parking services
}
