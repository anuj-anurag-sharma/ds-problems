package gfg.array;

import java.util.PriorityQueue;

public class SwapBitwise {

	public static void main(String[] args) {
		int a = 2;
		int b = 3;

		System.out.println(a + " " + b);

		a = a ^ b; // a -> ab
		b = a ^ b; // b -> a
		a = a ^ b; // 

		System.out.println(2^0);
		
		System.out.println(a + " " + b);
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
	}

}
