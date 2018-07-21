package gfg.array;

public class ZeroesToEnd {

	public static void main(String[] args) {
		int x = 10;
		--x;
		--x;
		int y = x--;

		x = 101;
		y = 3;
		int a,b=3;
		a = 101;
		if (a != 101 && a / 0 == 2) {
			System.out.println(b);
		} else {
			System.out.println(++b);
		}

		System.out.println(x + " " + y);
		
		double num[] = {5.5,10.1};
		double result;
		result = 0;
		for(int i = 0;i<1;++i){
			result = result + num[i];
		}
		System.out.println(result/4);
		
		
		final int z = 22;
		byte ba = z;
		System.out.println(z+" "+ba);
		
		int[] input = { 0, 1, 0, 2, 0, 0, 4, 0, 0, 1 };
		moveZeroesToEnd(input);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}

	static void moveZeroesToEnd(int[] input) {
		int slow = 0;
		int fast = 0;

		while (fast < input.length) {
			if (input[slow] != 0) {
				slow++;
				fast++;
			} else {
				while (fast < input.length) {
					if (input[fast] != 0) {
						break;
					}
					fast++;
				}
				if (fast < input.length) {
					input[slow] = input[fast];
					input[fast] = 0;
					slow++;
				}

			}
		}
	}

}
