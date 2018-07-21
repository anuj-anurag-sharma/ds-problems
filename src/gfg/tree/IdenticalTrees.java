package gfg.tree;

public class IdenticalTrees {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);

		Node node1 = new Node(1);
		node1.left = new Node(2);
		node1.right = new Node(2);
		node1.left.left = new Node(3);
		node1.left.right = new Node(4);
		node1.right.left = new Node(4);

		System.out.println(identicalTrees(root, node1));

	}

	static boolean identicalTrees(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null && root2 != null) {
			return false;
		}

		if (root2 == null && root1 != null) {
			return false;
		}

		if (root1.data == root2.data) {
			return identicalTrees(root1.left, root2.left) && identicalTrees(root1.right, root2.right);
		} else {
			return false;
		}
	}

}
