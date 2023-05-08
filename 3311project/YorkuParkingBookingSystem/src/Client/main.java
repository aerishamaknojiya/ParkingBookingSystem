package Client;

public class main {

	public static void main(String[] args) throws Exception {
		UserFactory ufac = new UserFactory();
		User user  = ufac.getUser(0);
		System.out.println(user.getEmail().toString());
	}

}
