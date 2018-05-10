package Model;

public enum QualityLevel {
    q1("single",20);
	
	private final String bedType;
	private final int roomSize;
	
  QualityLevel(String bedTyp,int roomSiz){
		bedType = bedTyp;
		roomSize = roomSiz;
	}
	
  public String getBedType() {
	  return bedType;
  }
  public int getRoomSize() {
	  return roomSize;
  }
  
}
