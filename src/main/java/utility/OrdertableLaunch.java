package utility;

import java.util.List;
import java.util.Scanner;

import DAO.OrdertableDAO;
import DAOimplement.OrdertableDAOImple;
import Model.Ordertable;

public class OrdertableLaunch {

    private static OrdertableDAO odao = new OrdertableDAOImple();
    private static Scanner scan = new Scanner(System.in);

    // ADD ORDER
    public static void addOrder() {

        System.out.print("Enter User Id: ");
        int userId = scan.nextInt();

        System.out.print("Enter Restaurant Id: ");
        int restaurantId = scan.nextInt();

        System.out.print("Enter Total Amount: ");
        float totalAmount = scan.nextFloat();
        scan.nextLine();

        System.out.print("Enter Status: ");
        String status = scan.nextLine();

        System.out.print("Enter Payment Method: ");
        String paymentMethod = scan.nextLine();

        Ordertable order = new Ordertable(
                userId,
                restaurantId,
                totalAmount,
                status,
                paymentMethod
        );

        odao.addOrdertable(order);
        System.out.println("Order Added Successfully");
    }

    // GET ORDER
    public static void getOrder() {

        System.out.print("Enter Order Id: ");
        int id = scan.nextInt();

        Ordertable o = odao.getOrdertable(id);

        if (o != null) {
            System.out.println("Order ID      : " + o.getOrderId());
            System.out.println("User ID       : " + o.getUserId());
            System.out.println("Restaurant ID : " + o.getRestaurantId());
            System.out.println("Order Date    : " + o.getOrderDate());
            System.out.println("Total Amount  : " + o.getTotalAmount());
            System.out.println("Status        : " + o.getStatus());
            System.out.println("Payment Method: " + o.getPaymentMethod());
        } else {
            System.out.println("Order Not Found");
        }
    }

    // UPDATE ORDER
    public static void updateOrder() {

        System.out.print("Enter Order Id: ");
        int id = scan.nextInt();

        Ordertable o = odao.getOrdertable(id);

        if (o != null) {

            System.out.print("Enter User Id: ");
            o.setUserId(scan.nextInt());

            System.out.print("Enter Restaurant Id: ");
            o.setRestaurantId(scan.nextInt());

            System.out.print("Enter Total Amount: ");
            o.setTotalAmount(scan.nextFloat());
            scan.nextLine();

            System.out.print("Enter Status: ");
            o.setStatus(scan.nextLine());

            System.out.print("Enter Payment Method: ");
            o.setPaymentMethod(scan.nextLine());

            odao.updateOrdertable(o);

            System.out.println("Updated Successfully");
        } else {
            System.out.println("Order Not Found");
        }
    }

    // DELETE ORDER
    public static void deleteOrder() {

        System.out.print("Enter Order Id: ");
        int id = scan.nextInt();

        odao.deleteOrdertable(id);

        System.out.println("Deleted Successfully");
    }

    // GET ALL ORDERS
    public static void getAllOrders() {

        List<Ordertable> list = odao.getAllOrdertable();

        if (list.isEmpty()) {
            System.out.println("No Orders Found");
            return;
        }

        for (Ordertable o : list) {

            System.out.println("--------------------------------");
            System.out.println("Order ID      : " + o.getOrderId());
            System.out.println("User ID       : " + o.getUserId());
            System.out.println("Restaurant ID : " + o.getRestaurantId());
            System.out.println("Order Date    : " + o.getOrderDate());
            System.out.println("Total Amount  : " + o.getTotalAmount());
            System.out.println("Status        : " + o.getStatus());
            System.out.println("Payment Method: " + o.getPaymentMethod());
        }
    }

    public static void main(String[] args) {

        addOrder();

        // getOrder();
        // updateOrder();
        // deleteOrder();
        // getAllOrders();

        scan.close();
    }
}