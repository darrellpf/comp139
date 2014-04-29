package forest;

public class Clearing {
	private boolean hasBeer;
	private int identifier;
	private int [] connections;
	private boolean checked;
	
	public Clearing(int id, int [] inConnections) {
		hasBeer = false;
		identifier = id;
		connections = inConnections;
		checked = false;
	}
	
	public boolean isChecked() {
		return checked;
	}
	
	public void checked(boolean value) {
		checked = value;
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
	
	public int [] getConnections() {
		return connections;
	}
	
	@Override
	public String toString() {
		return "" + identifier;
	}
}
