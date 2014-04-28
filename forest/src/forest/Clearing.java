package forest;

public class Clearing {
	private boolean hasBeer;
	private int identifier;
	private int [] connections;
	
	public Clearing(int id, int [] inConnections) {
		hasBeer = false;
		identifier = id;
		connections = inConnections;
	}
	
	public void setHasBeer(boolean value) {
		hasBeer = value;
	}
	
	public boolean getHasBeer() {
		return hasBeer;
	}
	
	public int getIdentifier() {
		return identifier;
	}
}
