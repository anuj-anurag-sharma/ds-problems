package gfg.tree;

import java.util.HashMap;
import java.util.Map;

public class CreateTree {

	public static void main(String[] args) {
		int in[] = { 1, 2, 3, 4, 5, 6, 7 };
		int post[] = { 1, 3, 2, 5, 7, 6, 4 };
		Node node = new CreateTree().buildTree(in, post, in.length);

		preOrder(node);
	}

	private static void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	Node buildTree(int in[], int post[], int n) {

		Map<Integer, Integer> inorderMap = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			inorderMap.put(in[i], i);
		}

		Node root = construct(in, post, 0, in.length - 1, 0, post.length - 1, inorderMap);
		return root;
	}

	private Node construct(int[] in, int[] post, int inStart, int inEnd, int postStart, int postEnd,
			Map<Integer, Integer> inorderMap) {

		if (postEnd < 0) {
			return null;
		}

		int rootKey = post[postEnd];

		int leftInEnd = inorderMap.get(rootKey) - 1;
		int leftInStart = inStart;

		int rightInStart = inorderMap.get(rootKey) + 1;
		int rightInEnd = inEnd;

		int leftSubtreeSize = leftInEnd - leftInStart + 1;
		int rightSubtreeSize = rightInEnd - rightInStart + 1;

		int leftPostEnd = postEnd - rightSubtreeSize - 1;
		int leftPostStart = leftPostEnd - leftSubtreeSize + 1;

		int rightPostEnd = postEnd - 1;
		int rightPostStart = postEnd - rightSubtreeSize;

		Node root = new Node(post[postEnd]);
		if (leftSubtreeSize > 0) {
			root.left = construct(in, post, leftInStart, leftInEnd, leftPostStart, leftPostEnd, inorderMap);
		}
		if (rightSubtreeSize > 0) {
			root.right = construct(in, post, rightInStart, rightInEnd, rightPostStart, rightPostEnd, inorderMap);
		}

		return root;
	}

}

class Node {
	int data;
	Node left;
	Node right;

	Node(int value) {
		data = value;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		return data + "";
	}

}