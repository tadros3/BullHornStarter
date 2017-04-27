
public class DbUser {
	public static User getUserById(int userID){
		User u = new User();
		//populate the user object
		u.userId = 100;
		u.username = "Bart Simpson";
		u.email = "bart@fox.net";
		u.password = "blue123";
		u.motto = "Don't have a cow, man!";
		return u;
	}
	public static User getUserByEmail(String userEmail){
		User u = new User();
		//populate the user object
		
		if (userEmail.equals("bart@fox.net")){
			u.userId = 100;
			u.username = "Bart Simpson";
			u.email = "bart@fox.net";
			u.password = "blue123";
			u.motto = "Don't have a cow, man!";	
		}else{
			u.userId = 101;
			u.username = "Lisa Simpson";
			u.email = "lisa@fox.net";
			u.password = "blue123";
			u.motto = "Mom! Bart's annoying me!";
		}
	
		return u;
	}
	public static User addUser(String username, String userPassword, String userEmail, String userMotto){
		User u = new User();
		//populate the user object
		u.userId = 101;
		u.username = username;
		u.email = userEmail;
		u.password = userPassword;
		u.motto = userMotto;
		return u;

	}
}
