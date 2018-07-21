package gfg.array;

public class EquilibriumPoint {

	public static void main(String[] args) {
		int[] input = { 2, 8, 7, 14, -4 };

		System.out.println(findEquilibriumPoint(input));
	}

	public static int findEquilibriumPoint(int[] input) {
		int[] leftSum = new int[input.length];
		int[] rightSum = new int[input.length];

		leftSum[0] = 0;
		for (int i = 1; i < input.length; i++) {
			leftSum[i] = leftSum[i - 1] + input[i - 1];
		}

		rightSum[input.length - 1] = 0;
		for (int i = input.length - 2; i >= 0; i--) {
			rightSum[i] = rightSum[i + 1] + input[i + 1];
		}

		for (int i = 0; i < input.length; i++) {
			if (leftSum[i] == rightSum[i]) {
				return i;
			}
		}
		return -1;
	}
}
