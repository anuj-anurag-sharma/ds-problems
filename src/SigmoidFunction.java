public class SigmoidFunction {

	public static double sigmoid(double x) {
		return (1 / (1 + Math.exp((-1 * x))));
	}

	public static void main(String[] args) {
		System.out.println(sigmoid(0));
	}

}
