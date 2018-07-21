package gfg.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchTargetInString {

	public static void main(String[] args) {
		System.out.println(strstr("ab", "b"));
		System.out.println(strstr("z", "z"));
	}

	public static int strstr(String str, String target) {

		Map<Character, List<Integer>> charMap = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			if (charMap.containsKey(str.charAt(i))) {
				List<Integer> list = charMap.get(str.charAt(i));
				if (list == null) {
					list = new ArrayList<>();
				}
				list.add(i);
				charMap.put(str.charAt(i), list);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				charMap.put(str.charAt(i), list);
			}
		}

		List<Integer> list = charMap.get(target.charAt(0));

		if (list == null) {
			return -1;
		} else {
			boolean found = true;
			for (int i = 0; i < list.size(); i++) {
				int idx = list.get(i);
				int nextIdx = idx + 1;
				for (int j = 1; j < target.length(); j++) {
					if (nextIdx < str.length() && str.charAt(nextIdx) == target.charAt(j)) {
						nextIdx++;
						found = true;
					} else {
						found = false;
						break;
					}
				}

				if (found) {
					return idx;
				}
			}
		}
		return -1;
	}

}
