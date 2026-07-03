package utility;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import DAOimplement.MenuDAOImple;
import Model.Menu;

public class MenuLaunch {

    private static MenuDAOImple mdao = new MenuDAOImple();
    private static Scanner scan = new Scanner(System.in);

    public static int addMenu() {

        System.out.println("Enter Restaurant Id:");
        int restaurantId = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter Item Name:");
        String itemName = scan.nextLine();

        System.out.println("Enter Description:");
        String description = scan.nextLine();

        System.out.println("Enter Price:");
        float price = scan.nextFloat();

        System.out.println("Enter Availability (true/false):");
        boolean isAvailable = scan.nextBoolean();
        scan.nextLine();

        System.out.println("Enter Category:");
        String category = scan.nextLine();

        System.out.println("Enter Image Path:");
        String image = scan.nextLine();

        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

        Menu menu = new Menu(
                restaurantId,
                itemName,
                description,
                price,
                isAvailable,
                category,
                image,
                createdAt,
                updatedAt
        );

        int i = mdao.addMenu(menu);

        System.out.println(i + " row inserted");

        return i;
    }

    public static void getMenu() {

        System.out.println("Enter Menu Id:");
        int id = scan.nextInt();

        Menu menu = mdao.getMenu(id);

        if (menu != null) {
            System.out.println(menu);
        } else {
            System.out.println("Menu not found");
        }
    }

    public static int updateMenu() {

        System.out.println("Enter Menu Id:");
        int id = scan.nextInt();
        scan.nextLine();

        Menu menu = mdao.getMenu(id);

        if (menu == null) {
            System.out.println("Menu not found");
            return 0;
        }

        System.out.println("Enter Item Name:");
        menu.setItemName(scan.nextLine());

        System.out.println("Enter Description:");
        menu.setDescription(scan.nextLine());

        System.out.println("Enter Price:");
        menu.setPrice(scan.nextFloat());

        System.out.println("Enter Availability (true/false):");
        menu.setIsAvailable(scan.nextBoolean());
        scan.nextLine();

        System.out.println("Enter Category:");
        menu.setCategory(scan.nextLine());

        System.out.println("Enter Image Path:");
        menu.setImage(scan.nextLine());

        menu.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        int i = mdao.updateMenu(menu);

        System.out.println(i + " row updated");

        return i;
    }

    public static void deleteMenu() {

        System.out.println("Enter Menu Id:");
        int id = scan.nextInt();

        int i = mdao.deleteMenu(id);

        if (i > 0) {
            System.out.println(i + " row deleted");
        } else {
            System.out.println("Menu not found");
        }
    }

    public static void getAllMenu() {

        List<Menu> list = mdao.getAllMenu();

        if (list.isEmpty()) {
            System.out.println("No records found");
        } else {
            for (Menu menu : list) {
                System.out.println(menu);
            }
        }
    }

    public static void getMenuByRestaurantId() {

        System.out.println("Enter Restaurant Id:");
        int restaurantId = scan.nextInt();

        List<Menu> menuList = mdao.getMenuByRestaruntId(restaurantId);

        if (menuList.isEmpty()) {
            System.out.println("No menu items found.");
        } else {
            for (Menu menu : menuList) {
                System.out.println(menu);
            }
        }
    }

    public static void main(String[] args) {

        addMenu();
        // getMenu();
        // updateMenu();
        // deleteMenu();
        // getAllMenu();
        // getMenuByRestaurantId();

    }
}