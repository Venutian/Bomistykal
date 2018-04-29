package Model;
/* This class handles the room attributes 
 * Room types and bed types 
 */
public class Room {
	
	private String desc;
	private int price;
	private String roomNumber;
	private int floor;
	private int roomSize;
	private int numOfBed;
	private String Location;
	private boolean smoking;
	private boolean view;
	private boolean petsAllowed;
	private boolean adjoint;
	private boolean singlebed;
	private boolean doubleBed;
	private boolean twin;

	
	
	public Room (int floor, String roomNumber, int price, int roomSize,String Location) {
		this.desc = desc;
		this.floor = floor;
		this.price = price;
		this.roomNumber = roomNumber;
		this.roomSize = roomSize;
		this.numOfBed = numOfBed;
		this.Location = Location;
		
	} 
	// getters and setters for Room object
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
		// getters and setters for RoomType
		public boolean getSmoking() {
			return this.smoking;
		}
		public void setSmoking(boolean smoking) {
			this.smoking = smoking;
		}
		public boolean getView() {
			return this.view;
			
		} public void setView(boolean view) {
			this.view = view;
		}
		public boolean getAdjoint() {
			return adjoint;
		}
		public void setAdjoint(boolean adjoint) {
			this.adjoint = adjoint;
		}
		public boolean getPetsAllowed() {
			return petsAllowed;
		}
		public void setPetsAllowed(boolean petsAllowed) {
			this.petsAllowed = petsAllowed;
		}
		
		//getters and setter for bedType
		public boolean getSingleBed() {
			return singlebed;
			
		}
		public void setSingleBed(boolean singleBed) {
			this.singlebed = singleBed;
		}
		public boolean getDoubleBed() {
		return doubleBed;
		}
		public void setDoubleBed(boolean doubleBed) {
		this.doubleBed = doubleBed;
		}
		public boolean getTwinBed() {
		return twin;
		}
		public void setTwinBed(boolean twin) {
		this.twin = twin;
	}
		public String getLocation() {
			return Location;
		}
		public void setLocation(String location) {
			this.Location = location;
		
		}
} 
