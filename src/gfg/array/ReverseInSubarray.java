package gfg.array;

public class ReverseInSubarray {
	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42 };
		reverseInSubarray(input, 30);
	}

	public static void reverseInSubarray(int[] input, int k) {
		for (int i = 0; i < input.length;) {
			int j = i;
			int l = Math.min(i + k - 1, input.length - 1);
			while (j < l) {
				int tmp = input[j];
				input[j] = input[l];
				input[l] = tmp;
				j++;
				l--;
			}
			i = i + k;
		}
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
}