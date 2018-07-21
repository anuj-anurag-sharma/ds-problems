package gfg.tree;

public class DiameterOfTree {

	static int max = 0;

	public static void main(String[] args) {

		/**
		 * 
		 * 
		 * */

		TNode root = new TNode(1);
		root.left = new TNode(2);
		root.right = new TNode(3);
		root.left.left = new TNode(4);
		root.left.right = new TNode(5);
		root.left.right.left = new TNode(10);
		root.left.right.right = new TNode(11);
		root.left.right.right.left = new TNode(13);
		root.left.right.right.left.left = new TNode(15);
		root.left.right.right.left.left.left = new TNode(17);
		root.right.left = new TNode(6);
		root.right.right = new TNode(7);
		root.left.left.left = new TNode(8);
		root.left.left.right = new TNode(9);
		root.left.left.right.left = new TNode(12);
		root.left.left.right.left.left = new TNode(14);
		root.left.left.right.left.left.left = new TNode(16);

		System.out.println(diameter(root));
	}

	static int diameter(TNode root) {
		if (root == null) {
			return 0;
		}
		height(root);
		diameterUtil(root);
		return max;
	}

	static void diameterUtil(TNode root) {
		if (root == null) {
			return;
		}

		int ans = 0;

		if (root.right != null) {
			ans = ans + root.right.height;
		}
		if (root.left != null) {
			ans = ans + root.left.height;
		}

		max = Math.max(max, ans + 1);

		diameterUtil(root.left);
		diameterUtil(root.left);
	}

	static int height(TNode root) {
		if (root == null) {
			return 0;
		}
		root.height = 1 + Math.max(height(root.left), height(root.right));
		return root.height;
	}

}

class TNode {

	int data;

	TNode left;

	TNode right;

	int height;

	public TNode(int data) {
		super();
		this.data = data;
	}

}