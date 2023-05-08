package Client;


import java.util.ArrayList;


public class FacultyMember extends User {
    
    private boolean validated;
    private int hourlyRate;
    private int balance;
    private ArrayList paymentMethods;    
    
    public FacultyMember(String email, String password) throws Exception {
        super(email, password);
        this.hourlyRate = 8;
        this.validated = false;
    }
    
    
}