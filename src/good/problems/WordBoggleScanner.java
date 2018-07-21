package good.problems;

/*package whatever //do not write package name here */
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordBoggleScanner {

	static int maxWordSize = 0;
	static Set<String> wordsFound = new TreeSet<String>();
	static Set<String> words = new HashSet<String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int l = sc.nextInt();

			while (l-- > 0) {
				String word = sc.next();
				words.add(word);
				maxWordSize = Math.max(word.length(), maxWordSize);
			}

			int x = sc.nextInt();
			int y = sc.nextInt();

			if (y > x) {
				int tmp = y;
				y = x;
				x = tmp;
			}

			String[][] input = new String[y][x];

			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					input[i][j] = sc.next();
				}
			}

			for (int i = 0; i < input.length; i++) {
				for (int j = 0; j < input[0].length; j++) {
					find(input, i, j, "", new HashSet<String>());
				}
			}

			Iterator<String> itr = wordsFound.iterator();
			while (itr.hasNext()) {
				System.out.print(itr.next() + " ");
			}
			System.out.println();
			wordsFound.clear();
			words.clear();
			maxWordSize = 0;
		}
	}

	static void find(String[][] input, int x, int y, String path, Set<String> set) {
		if (boundaryCheck(x, y, input.length, input[0].length) && path.length() <= maxWordSize) {
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