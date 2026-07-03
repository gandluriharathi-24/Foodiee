package DAO;

import java.util.List;
import Model.Ordertable;

public interface OrdertableDAO {

    // Add a new order
    void addOrdertable(Ordertable ordertable);

    // Get an order by Order ID
    Ordertable getOrdertable(int orderId);

    // Update an existing order
    void updateOrdertable(Ordertable ordertable);

    // Delete an order
    void deleteOrdertable(int orderId);

    // Get all orders
    List<Ordertable> getAllOrdertable();

    // Get all orders of a particular user
    List<Ordertable> getOrdersByUserId(int userId);

    // Get the latest generated Order ID
    int getLatestOrderId();
}