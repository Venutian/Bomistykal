package Model;

import java.util.ArrayList;

public class Campus {
	private ArrayList<Room> campusList;

	public Campus() {
 
    setCampusList(new ArrayList<Room>());
	
	}
	public ArrayList<Room> getCampusList() {
		return campusList;
	}

	public void setCampusList(ArrayList<Room> campusList) {
		this.campusList = campusList;
	}
	
	public void addRoom(Room room) {
		this.campusList.add(room);
	}
	
	public void removeRoom(Room room) {
	for(int i = 0; i < campusList.size(); i ++) {
			if(campusList.get(i).equals(room))
				campusList.remove(i);
		}
	}
	
}
