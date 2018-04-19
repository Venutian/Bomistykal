package Model;

public class Room {
	
	private String desc;
	private int price;
	private String roomNumber;
	private int floor;
	private int roomSize;
	private int numOfBed;
	
	private enum RoomType {
		Smoking,
		Non_Smoking,
		View,
		Adjoint,
		Pets_Allowed;
	}
	private enum BedType{
		Single,
		Double,
		Twin,
	}
	
	public Room (int floor, String roomNumber, String desc, int price, int roomSize, int numOfBed, BedType bd, RoomType rt ) {
		this.desc = desc;
		this.floor = floor;
		this.price = price;
		this.roomNumber = roomNumber;
		this.roomSize = roomSize;
		this.numOfBed = numOfBed;
		
		
		
		
	} 
	public int getFloor() {
		return floor;
	} 
	public void setFloor(int floor) {
		this.floor = floor;
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
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getNumOfBed() {
		return numOfBed;
	}
	public void setNumOfBed(int numOfBed) {
		this.numOfBed = numOfBed;
		
	}public int getRoomSize() {
		return roomSize;
	
	} public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
	}
	
		
	
	
} 
