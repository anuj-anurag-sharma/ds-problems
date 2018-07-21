package good.problems;

public class MergeSort {

	public static void main(String[] args) {
		int[] input = { -7, 6, 5, 3, 4, 3, 2, 1, 0 };
		mergeSort(input);

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}

	public static void mergeSort(int[] input) {
		mergesortutil(input, 0, input.length - 1);
	}

	private static void mergesortutil(int[] input, int start, int end) {
		if (end > start + 1) {
			int mid = (start + (end - start) / 2);
			mergesortutil(input, start, mid);
			mergesortutil(input, mid + 1, end);
			merge(input, start, mid, mid + 1, end);

		} else {
			if (end - start == 1) {
				if (input[start] > input[end]) {
					int tmp = input[start];
					input[start] = input[end];
					input[end] = tmp;
				}
			}
		}
	}

	private static void merge(int[] input, int start, int mid, int afterMid, int end) {
		int[] output = new int[mid - start + end - afterMid + 2];
		int count = 0;

		int i = start;
		int j = afterMid;
		while (i <= mid && j <= end) {
			if (input[j] > input[i]) {
				output[count] = input[i];
				i++;
			} else if (input[i] > input[j]) {
				output[count] = input[j];
				j++;
			} else {
				output[count] = input[i];
				count++;
				output[count] = input[j];
				i++;
				j++;
			}
			count++;
		}
		while (j <= end) {
			output[count] = input[j];
			count++;
			j++;
		}
		while (i <= mid) {
			output[count] = input[i];
			count++;
			i++;
		}
		for (int a = start, b = 0; b < output.length; a++, b++) {
			input[a] = output[b];
		}
	}

}
