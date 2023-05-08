package Client;


import java.util.ArrayList;

public class Visitor extends User {
    
    private boolean validated;
    private int hourlyRate;
    private int balance;
    
    public Visitor(String email, String password) throws Exception {
        super(email, password);
        this.hourlyRate = 15;
        this.validated = true;
    }
    
}