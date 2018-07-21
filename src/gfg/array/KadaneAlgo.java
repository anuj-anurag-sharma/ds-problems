package gfg.array;

public class KadaneAlgo {

	public static void main(String[] args) {
		int[] input = { 1,2,3,4 };
		int maximumSum = findMaximumSum(input);

		System.out.println(maximumSum);

		int[] output = findMaximumSumIndices(input);
		System.out.println(output[0] + " - " + output[1]);
	}

	public static int findMaximumSum(int[] input) {
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			if (sum + input[i] < 0) {
				sum = input[i];
			} else {
				sum = sum + input[i];
			}
			maxSum = Math.max(sum, maxSum);
		}
		return maxSum;
	}

	public static int[] findMaximumSumIndices(int[] input) {
		int[] output = new int[2];
		int sum = input[0];
		int maxSum = input[0];
		output[0] = 0;
		output[1] = 0;

		for (int i = 1; i < input.length; i++) {
			if (sum + input[i] < 0) {
				sum = input[i];
				output[0] = i;
				output[1] = i;
			} else {
				sum = sum + input[i];
			}
			if (sum > maxSum) {
				output[1] = i;
				maxSum = sum;
			}
		}

		return output;

	}

}
