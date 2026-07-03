package utility;

import java.util.List;
import java.util.Scanner;

import DAOimplement.UserDAOimplement;
import Model.User;

public class Launch {
	private static UserDAOimplement udao=new UserDAOimplement(); 
	private static Scanner scan = new Scanner(System.in);
	public static void addUser(){
	System.out.println("Enter the userName: ");
	String userName=scan.next();
	System.out.println("Enter the password: ");
	String password=scan.next();
	System.out.println("Enter the email: ");
	String email=scan.next();
	System.out.println("Enter the address: ");
	String address=scan.next();
	System.out.println("Enter the role: ");
	String role=scan.next();
	
	User u1 = new User(userName,password,email,address,role,null,null);
	
	UserDAOimplement udao=new UserDAOimplement();
	udao.addUser(u1);
	}
	
	public static void getuser() {
		System.out.println("Enter the userId: ");
		int id=scan.nextInt();
		User user=udao.getuser(id);
		System.out.println(user.getUserName()+" "+user.getPassword()+" "+user.getEmail()+" "+user.getAddress()+" "+user.getRole()
		+" "+user.getCreateData()+" "+user.getLastLoginData());
	}
	
	
	public static void updateUser() {
		System.out.println("Enter User id: ");
	    int id=scan.nextInt();
		int i=udao.updateUser(id);
		System.out.println(i+" updated successfully!!");
	}
	
	public static int deleteUser() {
		System.out.println("Enter id: ");
		int id=scan.nextInt();
		int user=udao.deleteUser(id);
		System.out.println("row deleted");
		return user;
	}
	public static void getAllUsers() {
		List<User> users=udao.getAllUsers();
		
		for(User u:users) {
			System.out.println("UserId: "+u.getUserId());
			System.out.println("Username: "+u.getUserName());
			System.out.println("Password: "+u.getPassword());
			System.out.println("Email: "+u.getEmail());
			System.out.println("Address: "+u.getAddress());
			System.out.println("Role: "+u.getRole());
			
			System.out.println("-------------------------");
		}
	}
	
	public static void main(String[] args) {
		
		addUser();
		getuser();
		updateUser();
		deleteUser();
		getAllUsers();
		
	}
	 
	
	
}
