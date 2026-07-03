package utility;

import java.util.List;
import java.util.Scanner;

import DAOimplement.OrderitemDAOImple;
import Model.Orderitem;

public class OrderitemLaunch {

    private static OrderitemDAOImple odao = new OrderitemDAOImple();

    private static Scanner scan = new Scanner(System.in);



    // ADD
    public static void addOrderitem() {

        System.out.println("Enter Order Id:");
        int orderId = scan.nextInt();

        System.out.println("Enter Menu Id:");
        int menuId = scan.nextInt();

        System.out.println("Enter Quantity:");
        int quantity = scan.nextInt();

        System.out.println("Enter Item Total:");
        float itemTotal = scan.nextFloat();


        // IMPORTANT
        Orderitem o = new Orderitem(
                orderId,
                menuId,
                quantity,
                itemTotal
        );

        odao.addOrderitem(o);
    }



    // GET
    public static void getOrderitem() {

        System.out.println("Enter Order Item Id:");
        int id = scan.nextInt();

        Orderitem o = odao.getOrderitem(id);

        if(o != null) {

            System.out.println(o.getOrderitemId() + " "
                    + o.getOrderId() + " "
                    + o.getMenuId() + " "
                    + o.getQuantity() + " "
                    + o.getItemTotal());
        }
        else {
            System.out.println("Order Item Not Found");
        }
    }



    // UPDATE
    public static void updateOrderitem() {

        System.out.println("Enter Order Item Id:");
        int id = scan.nextInt();

        Orderitem o = odao.getOrderitem(id);

        if(o != null) {

            System.out.println("Enter Order Id:");
            o.setOrderId(scan.nextInt());

            System.out.println("Enter Menu Id:");
            o.setMenuId(scan.nextInt());

            System.out.println("Enter Quantity:");
            o.setQuantity(scan.nextInt());

            System.out.println("Enter Item Total:");
            o.setItemTotal(scan.nextFloat());

            odao.updateOrderitem(o);

            System.out.println("Updated Successfully");
        }
        else {
            System.out.println("Order Item Not Found");
        }
    }



    // DELETE
    public static void deleteOrderitem() {

        System.out.println("Enter Order Item Id:");
        int id = scan.nextInt();

        odao.deleteOrderitem(id);

        System.out.println("Deleted Successfully");
    }



    // GET ALL
    public static void getAllOrderitems() {

        List<Orderitem> list = odao.getAllOrderitem();

        for(Orderitem o : list) {

            System.out.println(o.getOrderitemId() + " "
                    + o.getOrderId() + " "
                    + o.getMenuId() + " "
                    + o.getQuantity() + " "
                    + o.getItemTotal());
        }
    }



    // MAIN METHOD
    public static void main(String[] args) {

        addOrderitem();

//        getOrderitem();

//        updateOrderitem();

//        deleteOrderitem();

//        getAllOrderitems();
    }
}