package Model;

/* This class handles the room attributes
 * Room types and bed types 
 */
public class Room {

   
    private int price;
    private String roomID;
    private int roomSize;
    private int numOfBed;
    private String adjoinedRoomID;
    private String Location;
    private boolean smoking;
    private boolean view;
    private boolean adjoint;


    public Room (String roomID, int price, int roomSize, int numOfBeds, String Location, boolean view, boolean smoking, boolean adjoint, String adjoinedRoomID) {

        this.numOfBed = numOfBeds;
        this.price = price;
        this.roomID = roomID;
        this.roomSize = roomSize;
        this.Location = Location;
        this.view = view;
        this.smoking = smoking;
        this.adjoint = adjoint;
        this.adjoinedRoomID = adjoinedRoomID;

    }

    // getters and setters for Room object


    public int getPrice ( ) {
        return price;
    }

    public void setPrice (int price) {
        this.price = price;
    }


    public String getRoomID ( ) {
        return roomID;
    }

    public void setRoomID (String roomNumber) {
        this.roomID = roomNumber;
    }

    public int getNumOfBed ( ) {
        return numOfBed;
    }

    public void setNumOfBed (int numOfBed) {
        this.numOfBed = numOfBed;
    }

    public int getRoomSize ( ) {
        return roomSize;

    }

    public void setRoomSize (int roomSize) {
        this.roomSize = roomSize;
    }

    // getters and setters for RoomType
    public String getSmoke ( ) {
        String str = "";
        if (this.smoking == true)
            str = "Y";
        else if (this.smoking == false)
            str = "N";
        return str;
    }

    public void setAdjoint (String str) {
        if (str.equals("Y")) {
            adjoint = true;
        } else if (str.equals("N"))
            adjoint = false;

    }

    public String getAdjoints ( ) {
        String str = "";
        if (this.adjoint == true)
            str = "Y";
        else if (this.adjoint == false)
            str = "N";

        return str;
    }

    public String getViews ( ) {
        String str = "";
        if (this.view == true)
            str = "Y";
        else if (this.view == false)
            str = "N";
        return str;
    }

    public boolean getSmoking ( ) {
        return this.smoking;
    }

    public void setView (String str) {
        if (str.equals("Y"))
            view = true;
        else if (str.equals("N"))
            view = false;

    }

    public void setSmoking (String str) {
        if (str.equals("Y"))
            smoking = true;
        else if (str.equals("N"))
            smoking = false;

    }

    public void setSmoking (boolean smoking) {
        this.smoking = smoking;
    }

    public boolean getView ( ) {
        return this.view;

    }

    public void setView (boolean view) {
        this.view = view;
    }

    public boolean getAdjoint ( ) {
        return adjoint;
    }

    public void setAdjoint (boolean adjoint) {
        this.adjoint = adjoint;
    }

    public String getLocation ( ) {
        return Location;
    }

    public void setLocation (String location) {
        this.Location = location;

    }

    public void setAdjoindsRoomID (String id) {
        this.adjoinedRoomID = id;
    }

    public String getAdjoindsRoomID ( ) {
        return this.adjoinedRoomID;
    }

    public String toString ( ) {
        StringBuilder sb = new StringBuilder();
        sb.append(getSmoking() + ", " + getView() + ", " + getAdjoint() + "\n");


        return sb.toString();
    }

} 
