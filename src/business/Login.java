package business;

import java.io.Serializable;

import interfaces.PrimaryKey;

public class Login implements Serializable, PrimaryKey{
	private String userid;
	private String password;
	
	public Login(String username, String password){
		this.userid = username;
		this.password = password;		
	}

	public String getUsername() {
		return userid;
	}

	public void setUsername(String username) {
		this.userid = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return userid;
	}
	
	

}
