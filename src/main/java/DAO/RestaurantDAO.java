package DAO;

import java.util.List;

import Model.restarunt;

public interface RestaurantDAO {

    void addRestaurant(restarunt restaurant);

    restarunt getRestaurant(int RestaruntId);

    int updateRestaurant(restarunt restaurant);

    int deleteRestaurant(int RestaruntId);

    List<restarunt> getAllRestaurant();
}