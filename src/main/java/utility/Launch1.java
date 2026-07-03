package utility;

import java.util.List;
import java.util.Scanner;

import DAOimplement.RestaurantDAOImple;
import Model.restarunt;

public class Launch1 {

    private static RestaurantDAOImple rdao = new RestaurantDAOImple();
    private static Scanner scan = new Scanner(System.in);

    public static void addRestaurant() {

        System.out.println("Enter Restaurant Id:");
        int restaurantId = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter Restaurant Name:");
        String name = scan.nextLine();

        System.out.println("Enter Cuisine Type:");
        String cuisineType = scan.nextLine();

        System.out.println("Enter Delivery Time:");
        int deliveryTime = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter Address:");
        String address = scan.nextLine();

        System.out.println("Enter Admin User Id:");
        int adminUserId = scan.nextInt();

        System.out.println("Enter Rating:");
        float rating = scan.nextFloat();

        System.out.println("Enter IsActive (true/false):");
        boolean isActive = scan.nextBoolean();
        scan.nextLine();

        System.out.println("Enter Image Name (Example: paradise.jpg):");
        String image = scan.nextLine();

        restarunt restaurant = new restarunt(
                name,
                cuisineType,
                deliveryTime,
                address,
                adminUserId,
                rating,
                isActive,
                image
        );

        restaurant.setRestaurantId(restaurantId);

        rdao.addRestaurant(restaurant);

        System.out.println("Restaurant inserted successfully.");
    }

    public static void getRestaurant() {

        System.out.println("Enter Restaurant Id:");
        int id = scan.nextInt();

        restarunt r = rdao.getRestaurant(id);

        if (r != null) {
            System.out.println(r);
        } else {
            System.out.println("Restaurant not found.");
        }
    }

    public static void updateRestaurant() {

        System.out.println("Enter Restaurant Id:");
        int id = scan.nextInt();
        scan.nextLine();

        restarunt r = rdao.getRestaurant(id);

        if (r == null) {
            System.out.println("Restaurant not found.");
            return;
        }

        System.out.println("Enter New Restaurant Name:");
        r.setName(scan.nextLine());

        System.out.println("Enter New Cuisine Type:");
        r.setCulsinType(scan.nextLine());

        System.out.println("Enter New Delivery Time:");
        r.setDeliveryTime(scan.nextInt());
        scan.nextLine();

        System.out.println("Enter New Address:");
        r.setAddress(scan.nextLine());

        System.out.println("Enter New Admin User Id:");
        r.setAdminUserId(scan.nextInt());

        System.out.println("Enter New Rating:");
        r.setRating(scan.nextFloat());

        System.out.println("Enter IsActive (true/false):");
        r.setActive(scan.nextBoolean());
        scan.nextLine();

        System.out.println("Enter New Image Name:");
        r.setImage(scan.nextLine());

        int result = rdao.updateRestaurant(r);

        if (result > 0) {
            System.out.println("Restaurant updated successfully.");
        } else {
            System.out.println("Update failed.");
        }
    }

    public static void deleteRestaurant() {

        System.out.println("Enter Restaurant Id:");
        int id = scan.nextInt();

        int result = rdao.deleteRestaurant(id);

        if (result > 0) {
            System.out.println("Restaurant deleted successfully.");
        } else {
            System.out.println("Delete failed.");
        }
    }

    public static void getAllRestaurants() {

        List<restarunt> list = rdao.getAllRestaurant();

        for (restarunt r : list) {
            System.out.println(r);
        }
    }

    public static void main(String[] args) {

        addRestaurant();
        // getRestaurant();
        // updateRestaurant();
        // deleteRestaurant();
        // getAllRestaurants();
    }
}