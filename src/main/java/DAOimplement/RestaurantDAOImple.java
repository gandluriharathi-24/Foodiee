package DAOimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.RestaurantDAO;
import Model.restarunt;
import utility.DBConnection;

public class RestaurantDAOImple implements RestaurantDAO {

    private static final String INSERT_QUERY =
            "INSERT INTO restarunt(Name,CulsineType,DeliveryTime,Address,AdminUserId,Rating,IsActive,image) VALUES(?,?,?,?,?,?,?,?)";

    private static final String GET_QUERY =
            "SELECT * FROM restarunt WHERE RestaruntId=?";

    private static final String UPDATE_QUERY =
            "UPDATE restarunt SET Name=?,CulsineType=?,DeliveryTime=?,Address=?,AdminUserId=?,Rating=?,IsActive=?,image=? WHERE RestaruntId=?";

    private static final String DELETE_QUERY =
            "DELETE FROM restarunt WHERE RestaruntId=?";

    private static final String GET_ALL_QUERY =
            "SELECT * FROM restarunt";

    @Override
    public void addRestaurant(restarunt restaurant) {

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(INSERT_QUERY)
        ) {

            pst.setString(1, restaurant.getName());
            pst.setString(2, restaurant.getCulsinType());
            pst.setInt(3, restaurant.getDeliveryTime());
            pst.setString(4, restaurant.getAddress());
            pst.setInt(5, restaurant.getAdminUserId());
            pst.setFloat(6, restaurant.getRating());
            pst.setBoolean(7, restaurant.isActive());
            pst.setString(8, restaurant.getImage());

            int rows = pst.executeUpdate();

            System.out.println(rows + " Row Inserted Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public restarunt getRestaurant(int restaurantId) {

        restarunt restaurant = null;

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(GET_QUERY)
        ) {

            pst.setInt(1, restaurantId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                restaurant = new restarunt();

                restaurant.setRestaurantId(rs.getInt("RestaruntId"));
                restaurant.setName(rs.getString("Name"));
                restaurant.setCulsinType(rs.getString("CulsineType"));
                restaurant.setDeliveryTime(rs.getInt("DeliveryTime"));
                restaurant.setAddress(rs.getString("Address"));
                restaurant.setAdminUserId(rs.getInt("AdminUserId"));
                restaurant.setRating(rs.getFloat("Rating"));
                restaurant.setActive(rs.getBoolean("IsActive"));
                restaurant.setImage(rs.getString("image"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurant;
    }

    @Override
    public int updateRestaurant(restarunt restaurant) {

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(UPDATE_QUERY)
        ) {

            pst.setString(1, restaurant.getName());
            pst.setString(2, restaurant.getCulsinType());
            pst.setInt(3, restaurant.getDeliveryTime());
            pst.setString(4, restaurant.getAddress());
            pst.setInt(5, restaurant.getAdminUserId());
            pst.setFloat(6, restaurant.getRating());
            pst.setBoolean(7, restaurant.isActive());
            pst.setString(8, restaurant.getImage());
            pst.setInt(9, restaurant.getRestaurantId());

            return pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteRestaurant(int restaurantId) {

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(DELETE_QUERY)
        ) {

            pst.setInt(1, restaurantId);

            return pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<restarunt> getAllRestaurant() {

        List<restarunt> restaurantList = new ArrayList<>();

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(GET_ALL_QUERY);
                ResultSet rs = pst.executeQuery()
        ) {

            while (rs.next()) {

                restarunt restaurant = new restarunt();

                restaurant.setRestaurantId(rs.getInt("RestaruntId"));
                restaurant.setName(rs.getString("Name"));
                restaurant.setCulsinType(rs.getString("CulsineType"));
                restaurant.setDeliveryTime(rs.getInt("DeliveryTime"));
                restaurant.setAddress(rs.getString("Address"));
                restaurant.setAdminUserId(rs.getInt("AdminUserId"));
                restaurant.setRating(rs.getFloat("Rating"));
                restaurant.setActive(rs.getBoolean("IsActive"));
                restaurant.setImage(rs.getString("image"));

                restaurantList.add(restaurant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurantList;
    }
}