package Model;

public class Orderitem {
	private int orderitemId;
	private int orderId;
	private int menuId;
	private int quantity;
	private float itemTotal;
	
	public Orderitem() {
		
	}

	public Orderitem(int orderId, int menuId, int quantity, float itemTotal) {
		super();
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}

	public int getOrderitemId() {
		return orderitemId;
	}

	public void setOrderitemId(int orderitemId) {
		this.orderitemId = orderitemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(float itemTotal) {
		this.itemTotal = itemTotal;
	}

	@Override
	public String toString() {
		return "Orderitem [orderitemId=" + orderitemId + ", orderId=" + orderId + ", menuId=" + menuId + ", quantity="
				+ quantity + ", itemTotal=" + itemTotal + "]";
	}

	public void setQuantity1(int int1) {
		// TODO Auto-generated method stub
		
	}

	

	

	
	
}
