package good.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianOfStream {

	static PriorityQueue<Integer> lowerMaxHeap = new PriorityQueue<Integer>(new DescendingComparator());

	static PriorityQueue<Integer> upperMinHeap = new PriorityQueue<Integer>();

	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();

		while (true) {
			System.out.println(findMedianOfStream(sc.nextInt()));
//			t--;
		}
	}

	static double findMedianOfStream(int number) {

		count++;
		if (count == 1) {
			lowerMaxHeap.add(number);
			return number;
		}

		if (count == 2) {
			if (lowerMaxHeap.peek() < number) {
				upperMinHeap.add(number);
			} else {
				upperMinHeap.add(lowerMaxHeap.poll());
				lowerMaxHeap.add(number);
			}
			return (lowerMaxHeap.peek() + upperMinHeap.peek()) / 2.0;
		}

		else {
			if (count % 2 == 0) {
				if (number < lowerMaxHeap.peek()) {
					upperMinHeap.add(lowerMaxHeap.poll());
					lowerMaxHeap.add(number);
				} else {
					upperMinHeap.add(number);
				}
				return (lowerMaxHeap.peek() + upperMinHeap.peek()) / 2.0;
			} else {
				if (number > upperMinHeap.peek()) {
					lowerMaxHeap.add(upperMinHeap.poll());
					upperMinHeap.add(number);
				} else {
					lowerMaxHeap.add(number);
				}
				return lowerMaxHeap.peek();
			}
		}

	}
}

class DescendingComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}

}


class DescendingComparator1 implements Comparator<Integer>{
    public int compare(Integer o1, Integer o2){
        return o2.compareTo(o1);
    }
}