import java.util.Comparator;

public class Fighter implements Comparable<Fighter>{
	private String name;
	private String alias;
	private int wins;
	private int losses;
	
	public Fighter(String inName, String inAlias, int inWins, int inLosses) {
		name = inName;
		alias = inAlias;
		wins = inWins;
		losses = inLosses;
	}
	
	public void addWins(int amount) {
		wins += amount;
	}
	
	public void addLosses(int howMany) {
		losses += howMany;
	}
	
	public boolean equals(Object what) {
		Fighter other = (Fighter) what;
		return alias.equals(other.alias);
	}
	
	public int hashCode() {
		return alias.hashCode();
	}
	
	public int compareTo(Fighter other) {
		int comparison = wins - other.wins;
		if(comparison != 0) {
			return comparison;
		}
		
		return name.compareTo(other.name);
	}
	
	public int getWins() {
		return wins;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name + " " + alias + " " + wins + " " + losses;
	}
	
	public static Comparator<Fighter> byLosses() {
		return new Comparator<Fighter>() {
			public int compare(Fighter a, Fighter b) {
				return a.losses - b.losses;
			}
		};
	}
}
