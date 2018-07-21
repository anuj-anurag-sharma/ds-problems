package gfg.tree;

/**
 * https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-4/
 * https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
 * https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-2/
 * https://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
 * */

public class BinaryTreeToDLL {

	static Node head = null;

	static Node previous = null;

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);

		binaryTreeToDLL(root);

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
	}

	static void binaryTreeToDLL(Node root) {
		// Base cases
		if (root == null)
			return;

		// Recursively convert right subtree
		binaryTreeToDLL(root.right);

		// insert root into DLL
		root.right = head;

		// Change left pointer of previous head
		if (head != null)
			head.left = root;

		// Change head of Doubly linked list
		head = root;

		// Recursively convert left subtree
		binaryTreeToDLL(root.left);
	}

	static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}

}
