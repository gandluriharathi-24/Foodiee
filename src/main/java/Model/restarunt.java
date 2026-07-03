package Model;

public class restarunt {
	private int RestaruntId;
	private String Name;
	private String CulsineType;
	private int DeliveryTime;
	private String Address;
	private int AdminUserId;
	private float Rating;
	private boolean IsActive;
	private String image;

	public restarunt() {}

	public restarunt(String name, String culsineType, int deliveryTime, String address,
            int adminUserId, float rating, boolean isActive, String image) {
super();
Name = name;
CulsineType = culsineType;
DeliveryTime = deliveryTime;
Address = address;
AdminUserId = adminUserId;
Rating = rating;
IsActive = isActive;
this.image = image;
}
	

	public int getRestaurantId() {
		return RestaruntId;
	}

	public void setRestaurantId(int RestaruntId) {
		this.RestaruntId = RestaruntId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCulsinType() {
		return CulsineType;
	}

	public void setCulsinType(String culsineType) {
		CulsineType = culsineType;
	}

	public int getDeliveryTime() {
		return DeliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		DeliveryTime = deliveryTime;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getAdminUserId() {
		return AdminUserId;
	}

	public void setAdminUserId(int adminUserId) {
		AdminUserId = adminUserId;
	}

	public float getRating() {
		return Rating;
	}

	public void setRating(float rating) {
		Rating = rating;
	}

	public boolean isActive() {
		return IsActive;
	}

	public void setActive(boolean isActive) {
		this.IsActive = isActive;
	}
	public String getImage() {
	    return image;
	}
	public void setImage(String image) {
	    this.image = image;
	}

	
	@Override
	public String toString() {
	    return "Restaurant [RestaurantId=" + RestaruntId
	            + ", Name=" + Name
	            + ", CulsineType=" + CulsineType
	            + ", DeliveryTime=" + DeliveryTime
	            + ", Address=" + Address
	            + ", AdminUserId=" + AdminUserId
	            + ", Rating=" + Rating
	            + ", IsActive=" + IsActive
	            + ", image=" + image + "]";
	}
	
}
		
	
	