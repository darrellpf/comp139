public class Recursion {
	int[] numbers = { 2, 4, 6, 8, 10, 12 };

	public static void main(String[] args) {
		new Recursion();
	}

	public Recursion() {
		printNumbers(numbers, 0);
	}
	
	public void printNumbers(int[] numbers, int position) {
		if(position >= numbers.length) {
			return;
		}
		
		System.out.println(numbers[position] + " ");
		
		printNumbers(numbers, position + 1);
	}
	
	public void printNumbers2(int[] numbers, int position) {
		if(position >= numbers.length) {
			return;
		}
		
		printNumbers2(numbers, position + 1);
		
		System.out.println(numbers[position] + " ");
		

	}

}