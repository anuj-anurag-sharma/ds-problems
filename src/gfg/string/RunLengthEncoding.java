package gfg.string;

public class RunLengthEncoding {

	public static void main(String[] args) {
		String[] input = { "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "b", "b", "b", "c", "d", "a",
				"a", "e", "e" };
		String[] output = rle(input);
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
	}

	static String[] rle(String[] input) {
		int back = 0;
		int fwd = 1;
		int fill = 0;
		int count = 1;

		for (; fwd < input.length;) {
			if (input[back].equals(input[fwd])) {
				fwd++;
				count++;
			} else {
				if (count > 1) {
					input[fill] = input[back];
					input[fill + 1] = "" + count;
					fill = fill + 2;
					back = fwd;
					fwd++;
					count = 1;
				} else {
					input[fill] = input[back];
					fill = fill + 1;
					back = fwd;
					fwd++;
				}
			}
		}

		input[fill] = input[back];
		if (count > 1) {
			input[fill + 1] = "" + count;
			fill++;
		}
		String[] output = new String[fill + 1];
		for (int i = 0; i < fill + 1; i++) {
			output[i] = input[i];
		}
		return output;
	}

}
