package gfg.array;

public class SortArrayWith012 {

	public static void main(String[] args) {

		int[] input = { 0, 2, 1, 2, 0 };

		// sortArrayWith012(input);

		sort012(input);

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}

	}

	static void sortArrayWith012(int[] input) {

		int i = 0;
		int k = input.length - 1;
		int j = 0;

		while (j <= k) {
			if (input[j] == 0) {
				swap(input, i, j);
				i++;
				j++;
			} else if (input[j] == 1) {
				j++;
			} else {
				swap(input, j, k);
				k--;
			}
		}

	}


	static void sort012(int[] input) {
		int i = 0;
		int j = 0;
		int k = input.length - 1;
		while (j <= k) {
			switch (input[j]) {
			case 0: {
				swap(input, i, j);
				i++;
				j++;
				break;
			}
			case 1: {
				j++;
				break;
			}
			case 2: {
				swap(input, j, k);
				k--;
				break;
			}
			}
		}
	}

	static void swap(int[] input, int a, int b) {
		int tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}

}
