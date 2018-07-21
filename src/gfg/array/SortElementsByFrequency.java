package gfg.array;

/*package whatever //do not write package name here */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class SortElementsByFrequency {
	public static void main(String[] args) {
		int[] input = { 5, 5, 4, 6, 4 };
		printElementsByFrequency(input);
	}

	static void printElementsByFrequency(int[] input) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			if (map.get(input[i]) != null) {
				int freq = map.get(input[i]);
				map.put(input[i], freq + 1);
			} else {
				map.put(input[i], 1);
			}
		}

		PriorityQueue<Custom> pq = new PriorityQueue<Custom>(new Comparator<Custom>() {
			public int compare(Custom o1, Custom o2) {
				if (o1.frequency > o2.frequency) {
					return -1;
				} else if (o1.frequency == o2.frequency) {
					return o1.element > o2.element ? 1 : -1;
				} else {
					return 1;
				}
			}
		});

		Iterator<Entry<Integer, Integer>> itr = map.entrySet().iterator();

		while (itr.hasNext()) {
			Entry<Integer, Integer> ent = itr.next();
			pq.add(new Custom(ent.getKey(), ent.getValue()));
		}

		while (!pq.isEmpty()) {
			Custom cus = pq.poll();

			while (cus.frequency-- > 0) {
				System.out.print(cus.element + " ");
			}
		}
		System.out.println();
	}
}

class Custom {
	int element;
	int frequency;

	Custom(int element, int frequency) {
		this.element = element;
		this.frequency = frequency;
	}
}