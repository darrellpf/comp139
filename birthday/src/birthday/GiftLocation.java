package birthday;

public class GiftLocation {
	private String gift;
	private GiftLocation nextLocation;
	
	public GiftLocation(String inGift) {
		gift = inGift;
		nextLocation = null;
	}
	
	public void setNextLocation(GiftLocation next) {
		nextLocation = next;
	}
	
	public String getGift() {
		return gift;
	}
	
	public GiftLocation getNext() {
		return nextLocation;
	}

}
