
public class SortedAndRotated {

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 7, 0 };
		System.out.println(findPivot(input, 0, input.length - 1));
	}

	public static int findPivot(int[] input, int start, int end) {
		if (start > end) {
			return input[0];
		}
		if (start == end) {
			return input[start];
		}
		int mid = (start + end) / 2;
		if (mid < end && input[mid] > input[mid + 1]) {
			return input[mid];
		} else if (mid > start && input[mid - 1] > input[mid]) {
			return input[mid - 1];
		}
		if (input[end] > input[mid]) {
			return findPivot(input, start, mid - 1);
		}
		return findPivot(input, mid + 1, end);
	}

}
