
public class Bully implements Comparable<Bully> {
	private String	name;
	private int		weight;
	private int		lunchMoney;	
	private int		peoplePummeled;
	
	public Bully(String inName, int inWeight, int inLunchMoney) {
		name			= inName;
		weight			= inWeight;
		lunchMoney		= inLunchMoney;
		peoplePummeled	= 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getLunchMoney() {
		return lunchMoney;
	}
	
	public void addToLunchMoney(int amount) {
		lunchMoney += amount;
	}
	
	public int loseLunchMoney() {
		int moneyBeingStolen = lunchMoney;
		lunchMoney = 0;
		return moneyBeingStolen;
	}
	
	public int compareTo(Bully otherGuy) {
		return weight - otherGuy.weight;
	}
	
	public int getPeoplePummeled() {
		return peoplePummeled;
	}
	
	public void addToPeoplePummeled(int howMany) {
		peoplePummeled += howMany;
	}
}

