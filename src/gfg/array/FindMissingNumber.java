package gfg.array;

public class FindMissingNumber {

	static int findMissingNumber(int[] input, int n) {

		int expectedSum = (n * (n + 1)) / 2;
		int actualSum = input[0];
		for (int i = 1; i < input.length; i++) {
			actualSum = actualSum + input[i];
		}
		return expectedSum - actualSum;
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 5 };
		System.out.println(findMissingNumber(input, 5));
	}
}
