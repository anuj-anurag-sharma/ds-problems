package gfg.array;

import java.util.Arrays;

public class ChocolateDistribution {
	public static void main(String[] args) {
		int[] input = { 7, 3, 2, 4, 9, 12, 56 };
		System.out.println(distributeChocolate(input, 3));
	}

	static int distributeChocolate(int[] input, int k) {
		Arrays.sort(input);
		int i = 0;
		int min = Integer.MAX_VALUE;
		while (i < input.length - k + 1) {
			min = Math.min(min, input[i + k - 1] - input[i]);
			i++;
		}
		return min;
	}
}