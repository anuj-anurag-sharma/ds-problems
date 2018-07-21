package gfg.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxOfKSizeSubarray {

	public static void main(String[] args) {
		int[] input = { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 };
		printMaxOfKSizeSubarray(input, 4);
	}

	public static void printMaxOfKSizeSubarray(int[] input, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		for (int i = 0; i < input.length - k + 1; i++) {
			for (int j = i; j < i + k; j++) {
				pq.add(input[j]);
			}
			System.out.print(pq.poll() + " ");
			pq.clear();
		}
	}

}
