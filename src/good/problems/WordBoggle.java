package good.problems;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class WordBoggle {

	static Set<String> words = new HashSet<>();

	static {
		words.add("db");
		words.add("bcd");
	}

	static Set<String> wordsFound = new TreeSet<>();

	public static void main(String[] args) {
		 String[][] input = { { "d", "d" }, { "b", "f" }, { "e", "c" }, { "b","c" }, { "d", "c" } };
//		 String[][] input = { { "d", "d", "b", "f", "e" }, { "c", "b", "c", "d", "c" } };
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				find(input, i, j, "", new HashSet<String>());
			}
		}
		System.out.println(wordsFound);
	}

	static void find(String[][] input, int x, int y, String path, Set<String> set) {
		if (boundaryCheck(x, y, input.length, input[0].length)) {
			if (set.contains(x + "," + y)) {
				return;
			} else {
				set.add(x + "," + y);

			}
			if (words.contains(path)) {
				wordsFound.add(path);
			}
			find(input, x, y + 1, path + input[x][y], set);
			find(input, x + 1, y + 1, path + input[x][y], set);
			find(input, x + 1, y, path + input[x][y], set);
			find(input, x + 1, y - 1, path + input[x][y], set);
			find(input, x, y - 1, path + input[x][y], set);
			find(input, x - 1, y - 1, path + input[x][y], set);
			find(input, x - 1, y, path + input[x][y], set);
			find(input, x - 1, y + 1, path + input[x][y], set);
			path.substring(0, path.length());
			set.remove(x + "," + y);
		}
	}

	private static boolean boundaryCheck(int x, int y, int lengthX, int lengthY) {
		if (x < 0 || y < 0 || x >= lengthX || y >= lengthY) {
			return false;
		}
		return true;
	}

}
