package gfg.array;

public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		int[] input = { 468, 335, 501, 170, 725, 479, 359, 963, 465, 706, 146, 282, 828, 962, 492, 996, 943, 828, 437,
				392, 605, 903, 154, 293, 383, 422, 717, 719, 896, 448, 727, 772, 539, 870, 913, 668, 300, 36, 895, 704,
				812, 323 };

		System.out.println(findMaxSumSubsequence(input));

	}

	static int findMaxSumSubsequence(int[] input) {
		int len = input.length;
		int max = 0;
		int[] maxSum = new int[len];

		for (int i = 0; i < len; i++) {
			maxSum[i] = input[i];
		}

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (input[i] > input[j] && maxSum[i] < maxSum[j] + input[i]) {
					maxSum[i] = maxSum[j] + input[i];
				}
			}
		}

		for (int i = 0; i < len; i++) {
			max = Math.max(max, maxSum[i]);
		}
		return max;
	}
}
