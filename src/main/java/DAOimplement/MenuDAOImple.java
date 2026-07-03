package DAOimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.MenuDAO;
import Model.Menu;
import utility.DBConnection;

public class MenuDAOImple implements MenuDAO {

    private static final String INSERT_QUERY =
            "INSERT INTO menu (RestaurantId, ItemName, Description, Price, IsAvailable, Category, Image, CreatedAt, UpdatedAt) VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String UPDATE_QUERY =
            "UPDATE menu SET RestaurantId=?, ItemName=?, Description=?, Price=?, IsAvailable=?, Category=?, Image=?, UpdatedAt=?, DeletedAt=? WHERE MenuId=?";

    private static final String DELETE_QUERY =
            "DELETE FROM menu WHERE MenuId=?";

    private static final String GET_QUERY =
            "SELECT * FROM menu WHERE MenuId=?";

    private static final String GETALL_QUERY =
            "SELECT * FROM menu";

    private static final String GET_MENU_BY_RESTAURANT_ID =
            "SELECT * FROM menu WHERE RestaurantId=?";

    public int addMenu1(Menu menu) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(INSERT_QUERY)) {

            pst.setInt(1, menu.getRestaurantId());
            pst.setString(2, menu.getItemName());
            pst.setString(3, menu.getDescription());
            pst.setFloat(4, menu.getPrice());
            pst.setBoolean(5, menu.isIsAvailable());
            pst.setString(6, menu.getCategory());
            pst.setString(7, menu.getImage());
            pst.setTimestamp(8, menu.getCreatedAt());
            pst.setTimestamp(9, menu.getUpdatedAt());

            return pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Menu getMenu(int menuId) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(GET_QUERY)) {

            pst.setInt(1, menuId);

            try (ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {

                    Menu menu = new Menu();

                    menu.setMenuId(rs.getInt("MenuId"));
                    menu.setRestaurantId(rs.getInt("RestaurantId"));
                    menu.setItemName(rs.getString("ItemName"));
                    menu.setDescription(rs.getString("Description"));
                    menu.setPrice(rs.getFloat("Price"));
                    menu.setIsAvailable(rs.getBoolean("IsAvailable"));
                    menu.setCategory(rs.getString("Category"));
                    menu.setImage(rs.getString("Image"));
                    menu.setCreatedAt(rs.getTimestamp("CreatedAt"));
                    menu.setUpdatedAt(rs.getTimestamp("UpdatedAt"));
                    menu.setDeletedAt(rs.getTimestamp("DeletedAt"));

                    return menu;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int updateMenu1(Menu menu) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(UPDATE_QUERY)) {

            pst.setInt(1, menu.getRestaurantId());
            pst.setString(2, menu.getItemName());
            pst.setString(3, menu.getDescription());
            pst.setFloat(4, menu.getPrice());
            pst.setBoolean(5, menu.isIsAvailable());
            pst.setString(6, menu.getCategory());
            pst.setString(7, menu.getImage());
            pst.setTimestamp(8, menu.getUpdatedAt());
            pst.setTimestamp(9, menu.getDeletedAt());
            pst.setInt(10, menu.getMenuId());

            return pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteMenu(int menuId) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(DELETE_QUERY)) {

            pst.setInt(1, menuId);

            return pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Menu> getAllMenu() {

        List<Menu> menuList = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(GETALL_QUERY);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                Menu menu = new Menu();

                menu.setMenuId(rs.getInt("MenuId"));
                menu.setRestaurantId(rs.getInt("RestaurantId"));
                menu.setItemName(rs.getString("ItemName"));
                menu.setDescription(rs.getString("Description"));
                menu.setPrice(rs.getFloat("Price"));
                menu.setIsAvailable(rs.getBoolean("IsAvailable"));
                menu.setCategory(rs.getString("Category"));
                menu.setImage(rs.getString("Image"));
                menu.setCreatedAt(rs.getTimestamp("CreatedAt"));
                menu.setUpdatedAt(rs.getTimestamp("UpdatedAt"));
                menu.setDeletedAt(rs.getTimestamp("DeletedAt"));

                menuList.add(menu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menuList;
    }

    @Override
    public List<Menu> getMenuByRestaruntId(int restaruntid) {

        List<Menu> menuList = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(GET_MENU_BY_RESTAURANT_ID)) {

            pst.setInt(1, restaruntid);

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {

                    Menu menu = new Menu();

                    menu.setMenuId(rs.getInt("MenuId"));
                    menu.setRestaurantId(rs.getInt("RestaurantId"));
                    menu.setItemName(rs.getString("ItemName"));
                    menu.setDescription(rs.getString("Description"));
                    menu.setPrice(rs.getFloat("Price"));
                    menu.setIsAvailable(rs.getBoolean("IsAvailable"));
                    menu.setCategory(rs.getString("Category"));
                    menu.setImage(rs.getString("Image"));
                    menu.setCreatedAt(rs.getTimestamp("CreatedAt"));
                    menu.setUpdatedAt(rs.getTimestamp("UpdatedAt"));
                    menu.setDeletedAt(rs.getTimestamp("DeletedAt"));

                    menuList.add(menu);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menuList;
    }

    @Override
    public int addMenu(Menu menu) {
        return addMenu1(menu);
    }

    @Override
    public int updateMenu(Menu menu) {
        return updateMenu1(menu);
    }
}