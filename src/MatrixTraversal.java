
public class MatrixTraversal {

	public static void main(String[] args) {
		int[][] input = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		traverse(input, new Point(0, 0), new Point(3, 3), new Point(0, 0), 1);
	}

	public static void traverse(int[][] input, Point upper, Point lower, Point start, int direction) {
		System.out.println("Bounds " + upper + "," + lower);
		if (lower.equals(upper)) {
			return;
		}
		switch (direction) {
		case 1: {
			for (int j = start.y; j <= lower.y; j++) {
				System.out.print(input[start.x][j] + " ");
				start.y = j;
			}
			start.x = start.x + 1;
			upper.x = upper.x + 1;
			traverse(input, upper, lower, start, 2);
		}
		case 2: {
			if (start.x != lower.x) {
				for (int i = start.x; i <= lower.x; i++) {
					System.out.print(input[i][start.y] + " ");
					start.x = i;
				}
				start.y = start.y - 1;
				lower.y = lower.y - 1;
			}
			traverse(input, upper, lower, start, 3);
		}
		case 3: {
			for (int j = start.y; j >= upper.y; j--) {
				System.out.print(input[start.x][j] + " ");
				start.y = j;
			}
			start.x = start.x - 1;
			lower.x = lower.x - 1;
			traverse(input, upper, lower, start, 4);
		}
		case 4: {
			for (int i = start.x; i >= upper.x; i--) {
				System.out.print(input[i][start.y] + " ");
				start.x = i;
			}
			start.y = start.y + 1;
			upper.y = upper.y + 1;
			traverse(input, upper, lower, start, 1);
		}

		}
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return x + "," + y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}