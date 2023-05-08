package Client;

import java.util.ArrayList;
import java.util.List;


public class UserFactory {
	private List<User> accounts  = new ArrayList<User>();
	private User currUser;

	public User createUser(String userType, String email, String password) throws Exception {
		if (userType.equals("Student")) {

			currUser = (User) new Student(email, password );
			return currUser;

		} else if (userType.equals("Facultymember")) {

			currUser = (User) new FacultyMember(email, password);
			return currUser;

		} else if (userType.equals("NonFacultyStaff")) {

			currUser= (User) new NonFacultyStaff(email, password);
			return currUser;
		} else if (userType.equals("Visitor")) {

			currUser = (User) new Visitor(email, password);

			return currUser;
		} else {
			return null;
		}
	}
	public User getUser(int index) {
		return accounts.get(index);
		
	}
	
	public void setAccounts(List<User> account) {
	  this.accounts = account;
	}
	public List<User> getAccounts(){
		return this.accounts;
	}
	public boolean getUser(String email, String password) {
		System.out.println(accounts.size());
		for(int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getEmail().toString().equals(email) &&
					accounts.get(i).getPassword().toString().equals(password)){
				return true;
			}
		}
		return false;
		
	}
}