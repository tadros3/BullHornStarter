import java.sql.Date;

public class User {
	long userId;
	String username;
	String password;
	String email;
	String motto;
	Date joinDate;
	
	public User(){
		
	}
	public long getUserId(){
		return userId;
	}
	public void setUserId(long userId){
		//use the keyword this to refer to the class variable 
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	public java.sql.Date getJoinDate(){
		return joinDate;
	}
	public void setJoinDate(java.sql.Date date){
		joinDate = date;
	}
	public boolean isValidUser(String email){
		//this method should go to the database and query
		//for the email and passowrd. If both are found then
		//the user is valid. Otherwise the user is invalid;
		return true;
	}
	

}
