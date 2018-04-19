package Model;

public class Room {
	
	private String desc;
	private int price;
	private String roomNumber;
	private int floor;
	
	private boolean isAvailable;
	
	public Room (int floor, String roomNumber, String desc, int price ) {
		this.desc = desc;
		this.floor = floor;
		this.price = price;
		
	} 
	public int getId() {
		return id;
	} 
	public void setId(int id) {
		this.id = id;
	} 
	public String getDescription() {
		return desc;
	}
	public void setDescription(String description) {
		this.desc = description;
	}
	public int getPrice() {
		return price;
	} 
	public void setPrice(int price) {
		this.price = price;
	}
	
	
} 
