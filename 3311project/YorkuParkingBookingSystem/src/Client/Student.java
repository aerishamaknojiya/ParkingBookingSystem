package Client;

import java.util.ArrayList;


public class Student extends User {
    
    private boolean validated;
    private int hourlyRate;
    private int balance;
    
    public Student(String email, String password) throws Exception {
        super(email, password);
        this.hourlyRate = 5;
        this.validated = false;
     System.out.println("creates student");
    }

    
    
}