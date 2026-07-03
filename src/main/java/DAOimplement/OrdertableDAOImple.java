package DAOimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.OrdertableDAO;
import Model.Ordertable;
import utility.DBConnection;

public class OrdertableDAOImple implements OrdertableDAO {

    Connection con = DBConnection.getConnection();

    // ====================== ADD ORDER ======================
    @Override
    public void addOrdertable(Ordertable ordertable) {

        String query = "INSERT INTO ordertable(UserId, RestaurantId, TotalAmount, Status, PaymentMethod) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, ordertable.getUserId());
            ps.setInt(2, ordertable.getRestaurantId());
            ps.setFloat(3, ordertable.getTotalAmount());
            ps.setString(4, ordertable.getStatus());
            ps.setString(5, ordertable.getPaymentMethod());

            int x = ps.executeUpdate();

            if (x > 0) {
                System.out.println("Order Added Successfully");
            } else {
                System.out.println("Order Not Added");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ====================== GET ORDER ======================
    @Override
    public Ordertable getOrdertable(int orderId) {

        String query = "SELECT * FROM ordertable WHERE OrderId=?";

        Ordertable order = null;

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, orderId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                order = new Ordertable();

                order.setOrderId(rs.getInt("OrderId"));
                order.setUserId(rs.getInt("UserId"));
                order.setRestaurantId(rs.getInt("RestaurantId"));
                order.setOrderDate(rs.getTimestamp("OrderDate"));
                order.setTotalAmount(rs.getFloat("TotalAmount"));
                order.setStatus(rs.getString("Status"));
                order.setPaymentMethod(rs.getString("PaymentMethod"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return order;
    }

    // ====================== UPDATE ORDER ======================
    @Override
    public void updateOrdertable(Ordertable ordertable) {

        String query = "UPDATE ordertable SET UserId=?, RestaurantId=?, OrderDate=?, TotalAmount=?, Status=?, PaymentMethod=? WHERE OrderId=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, ordertable.getUserId());
            ps.setInt(2, ordertable.getRestaurantId());
            ps.setTimestamp(3, ordertable.getOrderDate());
            ps.setFloat(4, ordertable.getTotalAmount());
            ps.setString(5, ordertable.getStatus());
            ps.setString(6, ordertable.getPaymentMethod());
            ps.setInt(7, ordertable.getOrderId());

            int x = ps.executeUpdate();

            if (x > 0) {
                System.out.println("Order Updated Successfully");
            } else {
                System.out.println("Order Not Updated");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ====================== DELETE ORDER ======================
    @Override
    public void deleteOrdertable(int orderId) {

        String query = "DELETE FROM ordertable WHERE OrderId=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, orderId);

            int x = ps.executeUpdate();

            if (x > 0) {
                System.out.println("Order Deleted Successfully");
            } else {
                System.out.println("Order Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ====================== GET ALL ORDERS ======================
    @Override
    public List<Ordertable> getAllOrdertable() {

        List<Ordertable> list = new ArrayList<>();

        String query = "SELECT * FROM ordertable";

        try {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Ordertable order = new Ordertable();

                order.setOrderId(rs.getInt("OrderId"));
                order.setUserId(rs.getInt("UserId"));
                order.setRestaurantId(rs.getInt("RestaurantId"));
                order.setOrderDate(rs.getTimestamp("OrderDate"));
                order.setTotalAmount(rs.getFloat("TotalAmount"));
                order.setStatus(rs.getString("Status"));
                order.setPaymentMethod(rs.getString("PaymentMethod"));

                list.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ====================== DUPLICATE INTERFACE METHOD ======================
    public List<Ordertable> getAllOrdertables() {
        return getAllOrdertable();
    }

    // ====================== INTERFACE METHOD ======================
    public void addOrderitem(Ordertable ordertable) {
        addOrdertable(ordertable);
    }

    @Override
    public int getLatestOrderId() {

        String query =
            "SELECT MAX(OrderId) AS OrderId FROM ordertable";

        try{

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()){
                return rs.getInt("OrderId");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return 0;
    }

	public List<Ordertable> getOrdersByUserId(int userId) {

	    List<Ordertable> list = new ArrayList<>();

	    String query = "SELECT * FROM ordertable WHERE UserId=? ORDER BY OrderDate DESC";

	    try {

	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setInt(1, userId);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            Ordertable order = new Ordertable();

	            order.setOrderId(rs.getInt("OrderId"));
	            order.setUserId(rs.getInt("UserId"));
	            order.setRestaurantId(rs.getInt("RestaurantId"));
	            order.setOrderDate(rs.getTimestamp("OrderDate"));
	            order.setTotalAmount(rs.getFloat("TotalAmount"));
	            order.setStatus(rs.getString("Status"));
	            order.setPaymentMethod(rs.getString("PaymentMethod"));

	            list.add(order);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	
	
	
	public String getRestaurantName(int restaurantId) {

	    String restaurantName = "";

	    String query = "SELECT Name FROM restarunt WHERE RestaruntId=?";

	    try {

	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setInt(1, restaurantId);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            restaurantName = rs.getString("Name");

	        } else {

	            System.out.println("Restaurant Not Found");

	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return restaurantName;
	}
	
	
	
	
	
}