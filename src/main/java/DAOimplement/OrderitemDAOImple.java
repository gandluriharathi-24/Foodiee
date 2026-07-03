package DAOimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utility.DBConnection;

import DAO.OrderitemDAO;
import Model.Orderitem;

public class OrderitemDAOImple implements OrderitemDAO {

    Connection con = DBConnection.getConnection();

    public void addOrderitem1(Orderitem orderitem) {

        String query =
                "INSERT INTO orderitem(OrderId,MenuId,Quantity,ItemTotal) VALUES(?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, orderitem.getOrderId());
            ps.setInt(2, orderitem.getMenuId());
            ps.setInt(3, orderitem.getQuantity());
            ps.setFloat(4, orderitem.getItemTotal());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Orderitem getOrderitem(int orderitemId) {

        String query =
                "SELECT * FROM orderitem WHERE OrderitemId=?";

        Orderitem o = null;

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, orderitemId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                o = new Orderitem();

                o.setOrderitemId(rs.getInt("OrderitemId"));
                o.setOrderId(rs.getInt("OrderId"));
                o.setMenuId(rs.getInt("MenuId"));
                o.setQuantity(rs.getInt("Quantity"));
                o.setItemTotal(rs.getFloat("ItemTotal"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return o;
    }

    public void updateOrderitem1(Orderitem orderitem) {

        String query =
                "UPDATE orderitem SET OrderId=?, MenuId=?, Quantity=?, ItemTotal=? WHERE OrderitemId=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, orderitem.getOrderId());
            ps.setInt(2, orderitem.getMenuId());
            ps.setInt(3, orderitem.getQuantity());
            ps.setFloat(4, orderitem.getItemTotal());
            ps.setInt(5, orderitem.getOrderitemId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int deleteOrderitem(int orderitemId) {

        String query =
                "DELETE FROM orderitem WHERE OrderitemId=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, orderitemId);

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Orderitem> getAllOrderitem() {

        String query = "SELECT * FROM orderitem";

        List<Orderitem> list = new ArrayList<>();

        try {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Orderitem o = new Orderitem();

                o.setOrderitemId(rs.getInt("OrderitemId"));
                o.setOrderId(rs.getInt("OrderId"));
                o.setMenuId(rs.getInt("MenuId"));
                o.setQuantity(rs.getInt("Quantity"));
                o.setItemTotal(rs.getFloat("ItemTotal"));

                list.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

	@Override
	public void addOrderitem(Orderitem orderitem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrderitem(Orderitem orderitem) {
		// TODO Auto-generated method stub
		
	}
}