package gfg.string;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StringPermutation {

	static Set<String> set = new TreeSet<>();

	public static void main(String[] args) {

		permute("", "ABCA");

		Iterator<String> iterator = set.iterator();

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println(set.size());

	}

	static void permute(String str, String remaining) {
		if (remaining.equals("")) {
			set.add(str);
			return;
		}

		int len = remaining.length();

		for (int i = 0; i < len; i++) {
			permute(str + String.valueOf(remaining.charAt(i)), getRemainingString(remaining, i));
		}
	}

	private static String getRemainingString(String str, int i) {
		String front = "";
		String back = "";

		if (i > 0) {
			front = str.substring(0, i);
		}

		if (i + 1 < str.length()) {
			back = str.substring(i + 1);
		}
		return front + back;
	}
}
