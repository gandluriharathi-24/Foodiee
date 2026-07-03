package DAOimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utility.DBConnection;

import DAO.UserDAO;
import Model.User;

public class UserDAOimplement implements UserDAO {

    private static Scanner scan = new Scanner(System.in);

    public void addUser(User user) {

    	String INSERT_QUERY =
    			"INSERT INTO user(userName,password,email,address,role,lastLoginData) VALUES(?,?,?,?,?,?)";        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(INSERT_QUERY);

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getRole());
            ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("User Added Successfully");
            } else {
                System.out.println("User Not Added");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getuser(int userId) {

        String query = "SELECT * FROM `user` WHERE userId=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement prst = con.prepareStatement(query);

            prst.setInt(1, userId);

            ResultSet result = prst.executeQuery();

            if (result.next()) {

                User user = new User();

                user.setUserId(result.getInt("userId"));
                user.setUserName(result.getString("userName"));
                user.setPassword(result.getString("password"));
                user.setEmail(result.getString("email"));
                user.setAddress(result.getString("address"));
                user.setRole(result.getString("role"));
                user.setCreateData(result.getTimestamp("createData"));
                user.setLastLoginData(result.getTimestamp("lastLoginData"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int updateUser(int userId) {

        User user = getuser(userId);

        if (user == null) {
            System.out.println("User Not Found");
            return 0;
        }

        System.out.println("Current User Details");
        System.out.println(user.getUserId() + " "
                + user.getUserName() + " "
                + user.getPassword() + " "
                + user.getEmail() + " "
                + user.getAddress() + " "
                + user.getRole());

        System.out.println("\nEnter Updated Details");

        System.out.print("Enter UserName: ");
        String userName = scan.next();

        System.out.print("Enter Password: ");
        String password = scan.next();

        System.out.print("Enter Email: ");
        String email = scan.next();

        System.out.print("Enter Address: ");
        String address = scan.next();

        System.out.print("Enter Role: ");
        String role = scan.next();

        String update_query =
                "UPDATE `user` SET userName=?,password=?,email=?,address=?,role=?,createData=?,lastLoginData=? WHERE userId=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement prst = con.prepareStatement(update_query);

            prst.setString(1, userName);
            prst.setString(2, password);
            prst.setString(3, email);
            prst.setString(4, address);
            prst.setString(5, role);
            prst.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            prst.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            prst.setInt(8, userId);

            int i = prst.executeUpdate();

            System.out.println("User Updated Successfully");

            return i;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteUser(int userId) {

        String delete_query = "DELETE FROM `user` WHERE userId=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement prst = con.prepareStatement(delete_query);

            prst.setInt(1, userId);

            int i = prst.executeUpdate();

            System.out.println(i + " Row Deleted Successfully");

            return i;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();

        String query = "SELECT * FROM `user`";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement prst = con.prepareStatement(query);

            ResultSet res = prst.executeQuery();

            while (res.next()) {

                User user = new User();

                user.setUserId(res.getInt("userId"));
                user.setUserName(res.getString("userName"));
                user.setPassword(res.getString("password"));
                user.setEmail(res.getString("email"));
                user.setAddress(res.getString("address"));
                user.setRole(res.getString("role"));
                user.setCreateData(res.getTimestamp("createData"));
                user.setLastLoginData(res.getTimestamp("lastLoginData"));

                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
    
    
    public User validateUser(String email, String password) {

        String query = "SELECT * FROM user WHERE email=? AND password=?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getString("role"));
                user.setCreateData(rs.getTimestamp("createData"));
                user.setLastLoginData(rs.getTimestamp("lastLoginData"));

                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

	}