package Model;

import java.sql.Timestamp;

public class User {
	private int userId;
	private String userName;
	private String password;
	private String email;
	private String address;
	private String role;
	private Timestamp createData;
	private Timestamp lastLoginData;
	
	public User() {
		
	}
	
	public User(String userName, String password, String email, String address, String role) {
	    this.userName = userName;
	    this.password = password;
	    this.email = email;
	    this.address = address;
	    this.role = role;
	}
	
	public User(String userName, String password, String email, String address, String role, Timestamp createData,
			Timestamp lastLoginData) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
		this.createData = createData;
		this.lastLoginData = lastLoginData;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Timestamp getCreateData() {
		return createData;
	}
	public void setCreateData(Timestamp createData) {
		this.createData = createData;
	}
	public Timestamp getLastLoginData() {
		return lastLoginData;
	}
	public void setLastLoginData(Timestamp lastLoginData) {
		this.lastLoginData = lastLoginData;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", role=" + role + ", createData=" + createData + ", lastLoginData="
				+ lastLoginData + "]";
	}
	
}
