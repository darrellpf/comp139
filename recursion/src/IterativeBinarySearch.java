public class IterativeBinarySearch {

	public static void main(String[] args) {
		int[] orderedNumbers = { -55, -10, 23, 57, 91, 101, 132, 333, 444 };

		int numberToFind = 91;

		int position = findNumber(orderedNumbers, numberToFind, 0, orderedNumbers.length - 1);

		System.out.println("Position is " + position);
	}

	public static int findNumber(int[] orderedNumbers, int numberToFind, int leftPosition, int rightPosition) {

		while (leftPosition <= rightPosition) {

			int middlePosition = (rightPosition + leftPosition) / 2;

			if (orderedNumbers[middlePosition] == numberToFind) {
				return middlePosition;
			}

			if (numberToFind < orderedNumbers[middlePosition]) {
				rightPosition = middlePosition - 1;
			} else {
				leftPosition = middlePosition + 1;
			}
		}

		return -1;
	}
}
