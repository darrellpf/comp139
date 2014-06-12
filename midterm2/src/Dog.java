import java.util.Comparator;

public class Dog implements Comparable<Dog> {
	private String name;
	private String breed;
	private int weight;
	private int ribbons;

	public Dog(String inName, String inBreed, int inWeight, int inRibbons) {
		name = inName;
		breed = inBreed;
		weight = inWeight;
		ribbons = inRibbons;
	}

	public void addWeight(int amount) {
		weight += amount;
	}

	public void addRibbons(int howMany) {
		ribbons += howMany;
	}

	public boolean equals(Object what) {
		Dog other = (Dog) what;

		if (!name.equals(other.name)) {
			return false;
		}

		return breed.equals(other.breed);
	}

	public int hashCode() {
		return name.hashCode() + breed.hashCode();
	}

	public int compareTo(Dog other) {
		int comparison = weight - other.weight;
		if (comparison != 0) {
			return comparison;
		}

		return name.compareTo(other.name);
	}

	public int getWeight() {
		return weight;
	}

	public int getRibbons() {
		return ribbons;
	}

	public String getBreed() {
		return breed;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name + " " + breed + " " + weight + " " + ribbons;
	}

	public static Comparator<Dog> byUnknown() {
		return new Comparator<Dog>() {
			public int compare(Dog a, Dog b) {
				return a.name.compareTo(b.name);
			}
		};
	}
}
