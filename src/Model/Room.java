package Model;

/* This class handles the room attributes
 * Room types and bed types 
 */
public class Room {

    private String desc;
    private int price;
    private String roomID;
    private int roomSize;
    private int numOfBed;
    private String adjoinedRoomID;
    private boolean Location;
    private boolean smoking;
    private boolean view;
    private boolean adjoint;



    public Room(String roomID, int price, int roomSize,int numOfBeds ,boolean Location,boolean view ,boolean smoking,boolean adjoint) {
       
        this.numOfBed = numOfBeds;
        this.price = price;
        this.roomID = roomID;
        this.roomSize = roomSize;
        this.Location = Location;
        this.view = view;
        this.smoking = smoking;
        this.adjoint = adjoint;
        this.adjoinedRoomID = "0";
    }

    // getters and setters for Room object

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

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomNumber) {
        this.roomID = roomNumber;
    }

    public int getNumOfBed() {
        return numOfBed;
    }

    public void setNumOfBed(int numOfBed) {
        this.numOfBed = numOfBed;

    }

    public int getRoomSize() {
        return roomSize;

    }

    public void setRoomSize(int roomSize) {
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

    }

    public void setView(boolean view) {
        this.view = view;
    }

    public boolean getAdjoint() {
        return adjoint;
    }

    public void setAdjoint(boolean adjoint) {
        this.adjoint = adjoint;
    }

    public boolean getLocation() {
        return Location;
    }

    public void setLocation(boolean location) {
        this.Location = location;

    }
    public void setAdjoindsRoomID(String id) {
    	this.adjoinedRoomID = id;
    }
    public String getAdjoindsRoomID() {
    	return this.adjoinedRoomID;
    }
    
    
} 
