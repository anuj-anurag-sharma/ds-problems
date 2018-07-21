import java.io.IOException;

public class FirstAndLastOccurence {

	public static void main(String[] args) throws IOException {
		int[] input = { 0, 0, 0, 1, 1, 4 };
		System.out.println(firstOccurence(input, 2, 0, input.length - 1) != -1 ?
				firstOccurence(input, 2, 0, input.length - 1) + " " + lastOccurence(input, 2, 0, input.length - 1) : "-1");

	}

	public static int findElement(int[] input, int i) {
		return findElement(input, i, 0, input.length - 1);
	}

	static int findElement(int[] input, int number, int start, int end) {
		while (start < end) {
			if (input[(start + end) / 2] == number) {
				return (start + end) / 2;
			} else if (input[(start + end) / 2] > number) {
				System.out.println("Checked " + input[(start + end) / 2]);
				end = (start + end) / 2;
			} else {
				System.out.println("Checked " + input[(start + end) / 2]);
				start = (start + end) / 2;
			}
		}
		return -1;
	}

	public static int firstOccurence(int[] input, int number, int start, int end) {
		if (input[start] == number) {
			return start;
		}
		while (start < end) {
			int mid = (start + end) / 2;
			if (input[mid] == number) {
				if (input[mid - 1] != number) {
					return mid;
				} else {
					end = mid;
				}
			} else if (input[mid] > number) {
				end = mid;
			} else {
				start = mid;
			}

		}
		return -1;
	}

	public static int lastOccurence(int[] input, int number, int start, int end) {

		if (input[end] == number) {
			return end;
		}
		while (start < end) {
			int mid = (start + end) / 2;
			if (input[mid] == number) {
				if (input[mid + 1] != number) {
					return mid;
				} else {
					start = mid;
				}
			} else if (input[mid] > number) {
				end = mid;
			} else {
				start = mid;
			}

		}
		return -1;
	}

	static int[] firstAndLastOccurences(int[] input, int number, int start, int end) {
		int[] occurences = { -1, -1 };
		if (input[start] == number) {
			occurences[0] = start;
		}
		if (input[end] == number) {
			occurences[1] = end;
		}
		int startFirst = start;
		int endFirst = end;

		int startLast = start;
		int endLast = end;

		boolean first = true;
		boolean last = true;

		while (first || last) {
			if (first) {
				int midFirst = (startFirst + endFirst) / 2;

				if (input[midFirst] == number) {
					if (input[midFirst - 1] != number) {
						occurences[0] = midFirst;
						first = false;
					} else {
						endFirst = midFirst;
					}
				} else if (input[midFirst] > number) {
					endFirst = midFirst;
				} else {
					startFirst = midFirst;
				}
			}

			if (last) {
				int midLast = (startLast + endLast) / 2;
				if (input[midLast] == number) {
					if (input[midLast + 1] != number) {
						occurences[1] = midLast;
						last = false;
					} else {
						startLast = midLast;
					}
				} else if (input[midLast] > number) {
					endLast = midLast;
				} else {
					startLast = midLast;
				}
			}
		}

		return occurences;
	}

}
