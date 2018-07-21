package good.problems;

public class PrintTriangle {

	public static void main(String[] args) {
		print(10);
	}

	static void print(int num) {
		for (int i = 1; i <= num; i++) {
			for (int k = num - i; k > 0; k--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			int l = i;
			while (l-- > 1) {
				System.out.print(l);
			}
			System.out.println();
		}
	}

}
