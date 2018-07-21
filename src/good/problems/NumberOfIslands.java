package good.problems;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {

	static int count = 0;
	private static Set<String> processed = new HashSet<>();

	public static void main(String[] args) {
		int[][] input = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 },
				{ 1, 0, 1, 0, 1 } };
		numberOfIslands(input);
		System.out.println(count);
	}

	static void numberOfIslands(int[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				if (input[i][j] == 1 && !processed.contains(i + "," + j)) {
					move(input, i, j);
					count++;
				}

			}
		}
	}

	private static void move(int[][] input, int i, int j) {
		if (!processed.contains(i + "," + j) && i >= 0 && j >= 0 && i < input.length && j < input[0].length
				&& input[i][j] == 1) {
			processed.add(i + "," + j);
			move(input, i + 1, j);
			move(input, i - 1, j);
			move(input, i + 1, j + 1);
			move(input, i - 1, j + 1);

			move(input, i, j + 1);
			move(input, i, j - 1);
			move(input, i - 1, j + 1);
			move(input, i + 1, j - 1);
		}
	}

}
