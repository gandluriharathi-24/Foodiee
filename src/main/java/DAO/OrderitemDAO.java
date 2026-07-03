package DAO;

import java.util.List;

import Model.Orderitem;



public interface OrderitemDAO {
	void addOrderitem(Orderitem orderitem);
	Orderitem getOrderitem(int orderitemId);
	void updateOrderitem(Orderitem orderitem);
	int deleteOrderitem(int orderitemId);
	 List <Orderitem> getAllOrderitem();

}
