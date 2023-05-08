package Client;

import java.util.ArrayList;


public class NonFacultyStaff extends User {
    
    private boolean validated;
    private int hourlyRate;
    private int balance;
    
    public NonFacultyStaff(String email, String password) throws Exception {
        super(email, password);
        this.hourlyRate = 10;
        this.validated = false;
    }
    
    
}