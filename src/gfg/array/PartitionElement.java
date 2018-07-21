package gfg.array;

import java.util.Scanner;

public class PartitionElement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int len = sc.nextInt();
			int[] input = new int[len];
			for (int i = 0; i < len; i++) {
				input[i] = sc.nextInt();
			}
			System.out.println(partitionElement(input));
		}
	}

	static int partitionElement(int[] input) {
		int[] left = new int[input.length];
		int[] right = new int[input.length];

		left[0] = Integer.MIN_VALUE;
		right[right.length - 1] = Integer.MAX_VALUE;

		for (int i = 1; i < input.length - 1; i++) {
			left[i] = Math.max(left[i - 1], input[i - 1]);
		}

		for (int i = input.length - 2; i >= 0; i--) {
			right[i] = Math.min(right[i + 1], input[i + 1]);
		}

		for (int i = 1; i < input.length - 1; i++) {
			if (input[i] >= left[i] && input[i] <= right[i]) {
				return input[i];
			}
		}

		return -1;
	}
}