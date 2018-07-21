package gfg.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class AlienDictionary {

	public static void main(String[] args) {
		// String[] input = { "baa", "abcd", "abca", "cab", "cad" };
		String[] input = { "aaa", "abb", "b", "cbe", "daa", "eg" };
		orderOfCharacters(input);
	}

	static void orderOfCharacters(String[] input) {
		Map<Character, List<Character>> relations = findRelations(input);
		findOrder(relations);
	}

	private static void findOrder(Map<Character, List<Character>> relations) {
		Set<Character> processed = new HashSet<>();
		Stack<Character> stack = new Stack<>();

		Iterator<Character> iterator = relations.keySet().iterator();

		while (iterator.hasNext()) {
			Character next = iterator.next();
			populateStack(next, relations, processed, stack);
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private static void populateStack(Character next, Map<Character, List<Character>> relations,
			Set<Character> processed, Stack<Character> stack) {
		if (!processed.contains(next)) {
			processed.add(next);
			List<Character> list = relations.get(next);
			if (list == null) {
				stack.push(next);
			} else {
				for (Character c : list) {
					populateStack(c, relations, processed, stack);
				}
				stack.push(next);
			}
		}
	}

	private static Map<Character, List<Character>> findRelations(String[] input) {

		Map<Character, List<Character>> map = new HashMap<>();
		for (int i = 0; i < input.length - 1; i++) {
			String current = input[i];
			String next = input[i + 1];
			for (int l = 0, m = 0; l < current.length() && m < next.length(); l++, m++) {
				if (current.charAt(l) != next.charAt(m)) {
					List<Character> list = null;
					if ((list = map.get(current.charAt(l))) != null) {
						list.add(next.charAt(m));
					} else {
						list = new ArrayList<>();
						list.add(next.charAt(m));
					}
					map.put(current.charAt(l), list);
					break;
				}
			}
		}
		return map;
	}

}
