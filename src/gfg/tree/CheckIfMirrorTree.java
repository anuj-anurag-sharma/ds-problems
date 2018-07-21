package gfg.tree;

public class CheckIfMirrorTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);

		System.out.println(isSymmetric(root));
	}

	static boolean isSymmetric(Node root) {
		return areTreesMirror(root.left, root.right);
	}

	static private boolean areTreesMirror(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		Node left = node1;
		Node right = node2;
		while (left != null && right != null) {
			if ((left.data != right.data)) {
				return false;
			}
			left = left.left;
			right = right.right;
		}

		left = node2;
		right = node1;

		while (left != null && right != null) {
			if ((left.data != right.data)) {
				return false;
			}
			left = left.left;
			right = right.right;
		}

		return true;
	}

}
