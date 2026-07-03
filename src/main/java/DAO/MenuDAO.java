package DAO;

import java.util.List;

import Model.Menu;

public interface MenuDAO {

    int addMenu(Menu menu);

    Menu getMenu(int menuId);

    int updateMenu(Menu menu);

    int deleteMenu(int menuId);

    List<Menu> getAllMenu();
    
    List<Menu> getMenuByRestaruntId(int restaurantId);
}